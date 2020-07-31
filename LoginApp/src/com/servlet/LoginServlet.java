package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.servlet.model.LoginModel;
import com.servlet.service.LoginService;


@WebServlet("/loginServer")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		boolean result = loginService.authenticate(userId, password);
		if (result){
			LoginModel loginModel=loginService.getUserDetails(userId);
			request.setAttribute("user", loginModel);
			RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else{
			response.sendRedirect("loginForm.jsp");
			return;
		}
	}

}
