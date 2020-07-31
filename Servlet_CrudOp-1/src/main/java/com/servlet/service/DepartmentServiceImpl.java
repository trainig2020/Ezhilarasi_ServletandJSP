package com.servlet.service;

import java.util.List;

import com.servlet.dao.DepartmentDao;
import com.servlet.dao.DepartmentDaoImpl;
import com.servlet.model.Department;


public class DepartmentServiceImpl implements DepartmentService{
	
	DepartmentDao dao = new DepartmentDaoImpl();

	

	@Override
	public void insertDepartment(Department dept) {
		 dao.insertDepartment(dept);
	}

	@Override
	public List<Department> getAllDepartments() {
		
		return dao.getAllDepartments();
	}

	@Override
	public String updateDepartment(Department dept) {
		return dao.updateDepartment(dept);
	}

	@Override
	public void deleteDepartment(int deptId) {
		 dao.deleteDepartment(deptId);
	}

	@Override
	public Department getDeptById(int deptId) {
		
		return dao.getDeptById(deptId);
	}


}
