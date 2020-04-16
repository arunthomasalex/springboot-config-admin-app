package com.run.clientapp.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public FilterRegistrationBean<AuthenticationFilter> filterRegistrationBean() {
		FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<AuthenticationFilter>();
		AuthenticationFilter filter = new AuthenticationFilter();
		registrationBean.setFilter(filter);
		registrationBean.addUrlPatterns("/*");
//		registrationBean.setOrder(2);
		return registrationBean;
	}
}
