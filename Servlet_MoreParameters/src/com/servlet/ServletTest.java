package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String userName = req.getParameter("userName");
		out.println("Hello user "+userName);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String userName = req.getParameter("userName");
		String password = req.getParameter("pass");
		out.println("Hello user "+userName + " ur password is "+password);
		String prof = req.getParameter("prof");
		out.println("Ur profession is "+prof);
		
		//String location = req.getParameter("location");
		//out.println("Ur location is "+location);
		String[] places = req.getParameterValues("location");
		for(int i=0;i<places.length;i++){
			out.println("Ur location is "+places[i]);
		}
		
		
	}

}
