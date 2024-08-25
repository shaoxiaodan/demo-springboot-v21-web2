package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

	// 视图跳转
	// 如果要扩展springmvc，官方建议如下这样做（自定义配置）
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		/*
		 * 配置视图跳转和html之间的映射
		 */
		registry.addViewController("/").setViewName("index"); // 主页
		registry.addViewController("/index.html").setViewName("index"); // 主页
		registry.addViewController("/login.html").setViewName("sign-in"); // 登录

	}

	// 注册自定义国际化组件
	// @Bean注入到spring中，使其生效
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver(); // 返回自定义语言组件
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyLoginHandlerInterceptor()) // 注册自定义拦截器
				.addPathPatterns("/**") // 拦截所有请求
//				.excludePathPatterns("/", "/index.html", "/login.html"); // 排除其他请求
				.excludePathPatterns("/login.html") // 排除登录页面
				.excludePathPatterns("/css/**", "/font/**", "/image/**", "/js/**", "/picture/**"); // 排除静态资源
	}

}
