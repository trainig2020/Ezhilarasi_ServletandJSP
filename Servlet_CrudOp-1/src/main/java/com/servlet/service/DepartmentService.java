package com.servlet.service;

import java.util.List;

import com.servlet.model.Department;

public interface DepartmentService {

	
	public void insertDepartment(Department dept);
	public List<Department> getAllDepartments();
	public String updateDepartment(Department dept);
	public void deleteDepartment(int deptId);
	public Department getDeptById(int deptId);


}
