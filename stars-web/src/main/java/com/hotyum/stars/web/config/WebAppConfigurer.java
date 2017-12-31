package com.hotyum.stars.web.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.hotyum.stars.biz.manager.TokenAccessManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.web.config.argumentResolver.ListArgumentResolver;
import com.hotyum.stars.web.interceptor.AuthcInterceptor;

@Configuration
@EnableWebMvc
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;

	// 过期时间20分钟
	@Value("${app.token.timeout}")
	private int timeout = 20;

	// 最多操作15000次
	private int maxActiveCount = 15000;

	@Value("${app.whiteURL}")
	private String whiteURL = null;

	public final static String SetStorage = "Set-Storage";

	public final static String Storage = "Storage";

	@Autowired
	private TokenAccessManager tokenAccessManager;

	@Autowired
	private UserManager userManager;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		AuthcInterceptor authc = new AuthcInterceptor();
		authc.setWhiteURL(whiteURL);
		authc.setMaxActiveCount(maxActiveCount);
		authc.setTimeout(timeout);
		authc.setTokenManager(tokenAccessManager);
		authc.setUserManager(userManager);
		registry.addInterceptor(authc).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/xdoc/**").addResourceLocations("classpath:/static/xdoc/");
		super.addResourceHandlers(registry);
	}

	/**
	 * 使用过滤器
	 * addCorsMappings 只能捕捉spring返回的请求
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin(CorsConfiguration.ALL); // 允许域名
		config.addAllowedHeader(CorsConfiguration.ALL); // 允许接收的请求头，
		config.addAllowedMethod(CorsConfiguration.ALL); // 允许的请求方式
		config.addExposedHeader(SetStorage);// 允许响应头
		config.setAllowCredentials(true);
		config.setMaxAge(3600l);

		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return new CorsFilter(source);
	}

	/**
	 * 增加字符串转的功能
	 */
	@PostConstruct
	public void initEditableValidation() {
		ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter
				.getWebBindingInitializer();
		if (initializer.getConversionService() != null) {
			initializer = initStringToDate(initializer);
		}
	}

	/**
	 * 配置String转Date
	 * @param initializer
	 * @return
	 */
	private ConfigurableWebBindingInitializer initStringToDate(ConfigurableWebBindingInitializer initializer) {
		GenericConversionService genericConversionService = (GenericConversionService) initializer
				.getConversionService();
		Converter<?, ?> converter = new StringToDateConverter();
		genericConversionService.addConverter(converter);
		return initializer;
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		argumentResolvers.add(new ListArgumentResolver());
		// argumentResolvers.add(localDomainResolver());
	}

	/*
	 * @Bean public DomainResolver localDomainResolver() { return new
	 * DomainResolver(); }
	 */
}