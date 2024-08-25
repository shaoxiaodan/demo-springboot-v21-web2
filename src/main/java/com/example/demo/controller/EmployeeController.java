package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.EmployeeDao;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping("/emps.html")
	public String list(Model model) {
		Collection employees = employeeDao.getAll();
		model.addAttribute("emps", employees);
		return "emp/list";
	}
}
