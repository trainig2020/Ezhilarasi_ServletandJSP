package com.servlet.Servlet_CRUD.dao;

import java.util.List;

import com.servlet.Servlet_CRUD.model.Department;

public interface DepartmentDao {
	

		public void insertDepartment(Department dept);

		public List<Department> getAllDepartments();
		
		public String updateDepartment(Department dept);
		
		public void deleteDepartment(int deptId);

		public Department getDeptById(int deptId);

	

}
