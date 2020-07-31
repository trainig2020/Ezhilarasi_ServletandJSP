package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.model.Department;
import com.servlet.service.DepartmentService;
import com.servlet.service.DepartmentServiceImpl;

@WebServlet("/")
public class HomeController extends HttpServlet {
	public DepartmentService departmentService = new DepartmentServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			
			case "/new":
				createDept(request, response);
			case "/insert":
				insertDept(request, response);
				break;
			case "/delete":
				deleteDept(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateDept(request, response);
				break;
			case "/list":
				listDept(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void createDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> ldept = departmentService.getAllDepartments();
		request.setAttribute("adddept", "regdept");
		request.setAttribute("DeptList", ldept);
		//request.setAttribute("hoser", "hseval");
		RequestDispatcher rdf = request.getRequestDispatcher("home.jsp");
		rdf.forward(request, response);
		
	}

	private void listDept(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Department> listDept = departmentService.getAllDepartments();
		request.setAttribute("listDept", listDept);
		//request.setAttribute("hoser", "hseval");
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		Department existingDept = departmentService.getDeptById(deptId);
		request.setAttribute("dept", existingDept);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		
		dispatcher.forward(request, response);

	}

	private void insertDept(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String deptName = request.getParameter("deptName");
		Department newDept = new Department(deptName);
		departmentService.insertDepartment(newDept);
		response.sendRedirect("list");
	}

	private void updateDept(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String name = request.getParameter("deptName");

		Department dept = new Department(deptId, name);
		departmentService.updateDepartment(dept);
		response.sendRedirect("list");
	}

	private void deleteDept(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		departmentService.deleteDepartment(deptId);
		response.sendRedirect("list");

	}

}
