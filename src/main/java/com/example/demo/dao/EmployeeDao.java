package com.example.demo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;

// 员工操作dao
@Repository
public class EmployeeDao {

	// 模拟数据库数据
	private static Map<Integer, Employee> employees = null;

	// 员工有所属的部门
	@Autowired
	private DepartmentDao departmentDao;

	static {
		employees = new HashMap<Integer, Employee>(); // 创建了一个员工表

		// 添加数据
		employees.put(1001, new Employee(1001, "AAA", "aaa@gmail.com", 0, new Department(101, "教学部")));
		employees.put(1002, new Employee(1002, "BBB", "bbb@gmail.com", 1, new Department(102, "市场部")));
		employees.put(1003, new Employee(1003, "CCC", "ccc@gmail.com", 0, new Department(103, "教研部")));
		employees.put(1004, new Employee(1004, "DDD", "ddd@gmail.com", 1, new Department(104, "运营部")));
		employees.put(1005, new Employee(1005, "EEE", "eee@gmail.com", 0, new Department(105, "后勤部")));
	}

	// 主键自增
	private static Integer initId = 1006;

	// 增加一个新员工
	public void save(Employee employee) {
		// 设置id自增
		if (employee.getId() == null) {
			employee.setId(initId++);
		}

		// 设置员工部门
		employee.setDepartment(departmentDao.getDeparmentById(employee.getDepartment().getId()));

		// 添加员工数据
		employees.put(employee.getId(), employee);
	}

	// 查询所有员工信息
	public Collection<Employee> getAll() {
		return employees.values();
	}

	// 通过id查询员工
	public Employee getEmployeeById(Integer id) {
		return employees.get(id);
	}

	// 通过id删除员工
	public void delete(Integer id) {
		employees.remove(id);
	}

}
