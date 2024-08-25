package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	@GetMapping("/emps.html")
	public String list(Model model) {
		Collection employees = employeeDao.getAll();
		model.addAttribute("emps", employees);
		return "emp/list";
	}

	@GetMapping("/emp.html")
	public String toAddPage(Model model) {
		// 查询所有部门
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("departments", departments);
		return "emp/add";
	}

	@PostMapping("/emp.html")
	public String addEmp(Employee employee) {
		System.out.println("addEmp::save=>employee=" + employee);
		employeeDao.save(employee);
		return "redirect:/emps.html";
	}

}
