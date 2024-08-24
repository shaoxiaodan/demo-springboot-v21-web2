package com.example.demo.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

/*
 * 自定义国际化解析器
 */
public class MyLocaleResolver implements LocaleResolver {

	// 解析请求，获取语言信息
	@Override
	public Locale resolveLocale(HttpServletRequest request) {

		// 获取请求中的语言参数
		String lang = request.getParameter("lang");

		// 获取当前默认语言
		Locale locale = Locale.getDefault(); // 如果lang没有，就使用默认该语言

		// 如果lang不为空（携带了语言参数）
		if (!StringUtils.isEmpty(lang)) {
			// 分割语言参数，如：zh_CN, en_US
			String[] splitArry = lang.split("_");
			
			// 重新设置语言信息
			locale = new Locale(splitArry[0], splitArry[1]);
		}

		return locale; // 返回语言信息
	}

	// 设置语言
	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

	}

}
