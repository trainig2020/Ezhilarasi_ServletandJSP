package com.servlet.Servlet_CRUD.service;

import java.util.List;

import com.servlet.Servlet_CRUD.model.Department;

public interface DepartmentService {

	
	public void insertDepartment(Department dept);
	public List<Department> getAllDepartments();
	public String updateDepartment(Department dept);
	public void deleteDepartment(int deptId);
	public Department getDeptById(int deptId);


}
