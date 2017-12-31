package com.hotyum.stars.web.config.argumentResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.util.ConcurrentReferenceHashMap.ReferenceType;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSONArray;

public class ListArgumentResolver implements HandlerMethodArgumentResolver {

	private static Logger LOGGER = LoggerFactory.getLogger(ListArgumentResolver.class);

	private static final Map<Class<?>, Map<String, Object>> declaredEnumsCache = new ConcurrentReferenceHashMap<Class<?>, Map<String, Object>>(
			256, ReferenceType.SOFT);

	private static final Map<MethodParameter, ListParam> parameterAnnotationCache = new ConcurrentReferenceHashMap<MethodParameter, ListParam>(
			256, ReferenceType.SOFT);

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		ListParam listParamAnnotation = resolveAnnotation(parameter);
		return null != listParamAnnotation;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		ListParam parameterAnnotation = resolveAnnotation(parameter);
		List<Object> list = new ArrayList<>();
		if (parameterAnnotation == null) {
			throw new Exception("List参数获取失败");
			// return list;
		}
		// 参数名,参数值
		String paramName = parameterAnnotation.paramName();
		String parameterValue = webRequest.getParameter(paramName);

		// 解析
		Class<?> type = parameterAnnotation.type();
		if (StringUtils.isNotBlank(parameterValue)) {
			// 枚举
			if (type.isEnum()) {
				List<String> paramValueList = Arrays.asList(parameterValue.split(","));
				paramValueList.stream().forEach(paramValue -> {

					Optional<Object> enumReal = resolveEnum(type, paramValue);
					enumReal.ifPresent(x -> {
						list.add(x);
					});
				});
			} else {
				return JSONArray.parseArray(parameterValue, type);
			}
		}

		return list;
	}

	private ListParam resolveAnnotation(MethodParameter parameter) {
		ListParam listParamAnnotation = parameterAnnotationCache.get(parameter);
		if (listParamAnnotation == null) {
			listParamAnnotation = parameter.getParameterAnnotation(ListParam.class);
			if (listParamAnnotation != null) {
				parameterAnnotationCache.put(parameter, listParamAnnotation);
			}
		}
		return listParamAnnotation;
	}

	private static Optional<Object> resolveEnum(Class<?> type, String paramValue) {
		Object realEnum = null;
		Map<String, Object> map = getSingleEnumMap(type);
		if (map != null) {
			if (StringUtils.isNotBlank(paramValue)) {
				paramValue = paramValue.toUpperCase();
			}
			realEnum = map.get(paramValue);
		}
		// 初始化失败
		else {
			LOGGER.error("初始化枚举类[{}]失败，paramValue[{}]！", type.getName(), paramValue);
		}
		return Optional.ofNullable(realEnum);
	}

	private static Map<String, Object> getSingleEnumMap(Class<?> type) {
		Map<String, Object> map = declaredEnumsCache.get(type);
		if (map == null) {
			initialSingleEnumMap(type);
		}
		return declaredEnumsCache.get(type);
	}

	/**
	 * 根据class 并利用反射获取该类的所有枚举
	 * @param type 类名
	 * @throws InterruptedException 
	 */
	private static void initialSingleEnumMap(Class<?> type) {
		synchronized (type) {
			Map<String, Object> map = declaredEnumsCache.get(type);
			if (map == null) {
				Map<String, Object> enumMap = new ConcurrentReferenceHashMap<>();
				List<?> enums = Arrays.asList(type.getEnumConstants());
				enums.forEach(x -> {
					enumMap.put(x.toString().toUpperCase(), x);
				});
				declaredEnumsCache.put(type, enumMap);
			}
		}
	}

}
