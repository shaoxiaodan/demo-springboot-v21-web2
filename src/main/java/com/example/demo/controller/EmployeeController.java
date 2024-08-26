package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	// 员工列表page
	@GetMapping("/emps.html")
	public String toListEmp(Model model) {
		Collection employees = employeeDao.getAll();
		model.addAttribute("emps", employees);
		return "emp/list";
	}

	// 员工添加page
	@GetMapping("/emp.html")
	public String toAddEmp(Model model) {
		// 查询所有部门
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("departments", departments);
		return "emp/add";
	}

	// 员工添加
	@PostMapping("/emp.html")
	public String addEmp(Employee employee) {
		System.out.println("addEmp::save=>employee=" + employee);
		employeeDao.save(employee);
		return "redirect:/emps.html";
	}

	// 员工更新page
	@GetMapping("/emp.html/{id}")
	public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
		// 根据id查询员工
		Employee employee = employeeDao.getEmployeeById(id);
		model.addAttribute("emp", employee);

		// 查询所有部门
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("departments", departments);

		return "emp/update";
	}

	// 员工更新
	@PostMapping("/updateEmp.html")
	public String updateEmp(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps.html";
	}

	// 员工删除
	@GetMapping("/deleteEmp.html/{id}")
	public String deleteEmp(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps.html";
	}

}
