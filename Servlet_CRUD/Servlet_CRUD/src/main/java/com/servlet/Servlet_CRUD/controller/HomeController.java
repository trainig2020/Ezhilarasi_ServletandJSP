package com.servlet.Servlet_CRUD.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.Servlet_CRUD.model.Department;
import com.servlet.Servlet_CRUD.service.DepartmentService;
import com.servlet.Servlet_CRUD.service.DepartmentServiceImpl;

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
				showNewForm(request, response);
				break;
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
			default:
				listDept(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listDept(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Department> listDept = departmentService.getAllDepartments();
		request.setAttribute("listDept", listDept);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("newForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		Department existingDept = departmentService.getDeptById(deptId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("newForm.jsp");
		request.setAttribute("dept", existingDept);
		dispatcher.forward(request, response);

	}

	private void insertDept(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("deptName");
		Department newDept = new Department(name);
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
