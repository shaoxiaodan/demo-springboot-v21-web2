package com.example.demo.pojo;

// 部门表
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Department {

	private Integer id;
	private String departmentName;

	public Department() {
		super();
	}

	public Department(Integer id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
