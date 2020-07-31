<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String user = request.getParameter("userName");
	if (user != null){
		session.setAttribute("sessionName", user);
		application.setAttribute("applicationName", user);
		pageContext.setAttribute("pageName", user);
		/* pageContext.setAttribute("name1", user, pageContext.APPLICATION_SCOPE); */
	}
%>
User name as request : <%= user %> <br>
Session Name is <%= session.getAttribute("sessionName") %><br>
Application name is <%= application.getAttribute("applicationName") %><br>
Page context name is <%= pageContext.getAttribute("pageName") %>
</body>
</html>