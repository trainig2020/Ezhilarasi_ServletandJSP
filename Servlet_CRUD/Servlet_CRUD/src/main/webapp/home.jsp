<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

	<center>
		<h1>Department Management</h1>


		<div >

			<a href="<%=request.getContextPath()%>/new" >Add
				New Department</a>
		</div>
	</center>
	<br>
	<center>
		<table border=1>
			<thead>
				<tr>
					<th>DeptID</th>
					<th>DeptName</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="dept" items="${listDept}">

					<tr>
						<td><c:out value="${dept.deptId}" /></td>
						<td><c:out value="${dept.deptName}" /></td>
						<td><a href="edit?deptId=<c:out value='${dept.deptId}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="delete?deptId=<c:out value='${dept.deptId}' />">Delete</a></td>
					</tr>
				</c:forEach>
				<tr>
				<td><input type="text" name = "deptId"></td>
				<td><input type="text" name="deptName"></td>
				<td><input type="submit" value="save"></td></tr>
				<!-- } -->
			</tbody>

		</table>
	</center>
</body>
</html>