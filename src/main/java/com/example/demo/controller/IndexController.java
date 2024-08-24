package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	/*
	 * 在MyMvcConfig中自定义了自己的ViewResolver后，该indexPage的controller方法，可以不再需要
	 */
//	@GetMapping({"/", "/index.html"})
//	public String indexPage() {
//		return "index";
//	}

}
