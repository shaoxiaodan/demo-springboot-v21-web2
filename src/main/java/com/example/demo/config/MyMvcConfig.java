package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

	// 视图跳转
	// 如果要扩展springmvc，官方建议如下这样做（自定义配置）
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		// 登录
		registry.addViewController("/login").setViewName("sign-in");
		registry.addViewController("/login.html").setViewName("sign-in");

		// 主页
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index.html").setViewName("index");
	}

	// 注册自定义国际化组件
	// @Bean注入到spring中，使其生效
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver(); // 返回自定义语言组件
	}

}
