package com.hotyum.stars.web.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.hotyum.stars.utils.exception.ApplicationException;
import com.hotyum.stars.web.model.Result;

@ControllerAdvice
public class UnifyExceptionHandler {
	protected Logger log = LoggerFactory.getLogger(getClass());

	@ResponseBody
	@ExceptionHandler(value = DataAccessException.class)
	public Result DataAccessException(DataAccessException e, WebRequest request) {
		String message = e.getMessage();
		log.error("数据访问异常:" + message);
		return Result.errorReponse("数据访问异常，请联系管理人员");
	}

	@ResponseBody
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public Result MissingServletRequestParameterException(MissingServletRequestParameterException e,
			WebRequest request) {
		log.error("缺少必要参数：" + e.getParameterName(), e);
		return Result.errorReponse("缺少必要参数：" + e.getParameterName());
	}

	@ResponseBody
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public Result HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		StringBuilder supportMethodMsg = new StringBuilder();
		for (String supportMethod : e.getSupportedMethods()) {
			supportMethodMsg.append(supportMethod).append("|");
		}
		log.error("请求方法[{}]不支持，支持方法[{}]", e.getMethod(), supportMethodMsg.toString());
		return Result.errorReponse("不支持的请求");
	}

	@ResponseBody
	@ExceptionHandler(value = RuntimeException.class)
	public Result RuntimeException(RuntimeException e) {
		log.error("系统故障:", e);
		String message = e.getMessage();
		if (StringUtils.isEmpty(message)) {
			message = "内部服务器异常";
		}
		return Result.errorReponse(message);
	}

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Result Exception(Exception exception, WebRequest request) {
		log.error("异常解析器全局拦截", exception);
		return Result.errorReponse("操作失败，请联系管理人员");
	}

	@ResponseBody
	@ExceptionHandler(value = ApplicationException.class)
	public Result ApplicationException(Exception e) {
		log.error("异常解析器全局拦截", e);
		return Result.errorReponse(e.getMessage());
	}

}
