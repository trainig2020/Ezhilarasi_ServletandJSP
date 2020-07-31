<%@page import="com.servlet.model.LoginModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.servlet.model.LoginModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
<h4>Login Successful.....</h4>

<%-- <%LoginModel loginModel = (LoginModel)request.getAttribute("user"); %>
 --%>
<jsp:useBean id="user" class="com.servlet.model.LoginModel" scope="request"></jsp:useBean>

<%-- Hello..<%= loginModel.getUserName() %> --%>

<%-- Hello...<%= user.getUserName() %> --%>

Hello...<jsp:getProperty property="userName" name="user"/>
</body>
</html>