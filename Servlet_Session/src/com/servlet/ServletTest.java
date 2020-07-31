package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletTest extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String userName = req.getParameter("userName");
		HttpSession session = req.getSession();
		ServletContext context = req.getServletContext();
		if(userName != "" && userName != null){
		session.setAttribute("savedUser", userName);
		context.setAttribute("contextUser", userName);
		}
		
		out.println("Hello user "+userName);
		out.println("session user is "+(String)session.getAttribute("savedUser"));
		out.println("Context user is "+(String)context.getAttribute("contextUser"));
		out.println("Init parameter user is "+ getServletConfig().getInitParameter("defaultName"));
		
	}
	
	
		
		
}


