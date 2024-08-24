package com.example.demo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Department;

// 部门操作dao
@Repository
public class DepartmentDao {

	// 模拟数据库数据
	private static Map<Integer, Department> Departments = null;
	static {
		Departments = new HashMap<Integer, Department>(); // 创建了一个部门表

		// 添加数据
		Departments.put(101, new Department(101, "教学部"));
		Departments.put(102, new Department(102, "市场部"));
		Departments.put(103, new Department(103, "教研部"));
		Departments.put(104, new Department(104, "运营部"));
		Departments.put(105, new Department(105, "后勤部"));
	}

	// 获取部门所有信息
	public Collection<Department> getDepartments() {
		return Departments.values();
	}

	// 通过id获取部门
	public Department getDeparmentById(Integer id) {
		return Departments.get(id);
	}

}
