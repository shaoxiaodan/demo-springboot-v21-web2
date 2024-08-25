package com.example.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class MyLoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 登录成功之后，应该有用户的session
		Object loginUser = request.getSession().getAttribute("loginUser");
		System.out.println("preHandle::loginUser=" + loginUser);
		if (loginUser == null) { // 没有登录
			request.setAttribute("msg", "没有权限，请先登录。");
			request.getRequestDispatcher("/login.html").forward(request, response);
			return false;
		} else {
			return true;
		}

	}

}
