package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login.html")
	public String loginPage() {
		System.out.println("loginPage...");
		return "sign-in";
	}
	
	@PostMapping("/login.html")
//	@ResponseBody
	public String doLogin(
			@RequestParam("username") String userName, 
			@RequestParam("password") String passWord,
			Model model,
			HttpSession session) {

		String msg = "";
		
		if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(passWord)) {
			if ("123".equals(passWord)) {
				// 登录成功
				session.setAttribute("loginUser", userName);
				return "redirect:/index.html";
			} else {
				msg = "用户名或密码错误。";
				System.out.println("doLogin::msg=" + msg);
//				model.addAttribute("msg", msg);
//				model.addAttribute("msg", "login.err1");
				model.addAttribute("msg", "login.err2");
//				model.addAttribute("msg", "login.err3");
				return "/sign-in";
//				return "redirect:/login.html";
			}
		}else {
			msg = "用户名或密码不能为空。";
			System.out.println("doLogin::msg=" + msg);
			return "redirect:/login.html";
		}
	}

}
