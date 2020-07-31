<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>


	<br>
	<center>
		


			<br>
			<br>
			<div align="center">
				<c:if test="${dept.deptId != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${dept.deptId == null}">
					<form action="insert" method="post">
				</c:if>
				<a href="new">Add new department</a>
				
				<table border=1>
					<thead>
						<tr>
							<th>DeptID</th>
							<th>DeptName</th>
							<th>Actions</th>

						</tr>
					</thead>
					<tbody>


						<c:forEach var="depart" items="${listDept}">
							<c:if test="${dept.deptId eq depart.deptId}">

								<tr>
									<td><input type="" name="deptId" value="${dept.deptId}"
										disabled style="background-color: lightgrey;" /></td>
									<td><input type="text" name="deptName"
										value="${dept.deptName}"></td>

									<td>
										<button type="submit">update</button>
							</c:if>
							<%-- <c:if test="${dept.deptId ne depart.deptId}"> --%>
								<tr>
									<td><c:out value="${depart.deptId}" /></td>
									<td><c:out value="${depart.deptName}" /></td>
									<td><a href="edit?deptId=<c:out value='${depart.deptId}' />">Update</a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="delete?deptId=<c:out value='${depart.deptId}' />">Delete</a></td>
								</tr>
							<%-- </c:if> --%>
						</c:forEach>
						<c:if test="${adddept eq 'regdept'}">

							<tr>
								<td><input type="text" name="deptId" /></td>
								<td><input type="text" name="deptName"
									 required /></td>
								
								<td colspan="1">


									<div align="center">
										<button type="submit" >save</button>
									</div>

								</td>
							</tr>
						</c:if>



						

					</tbody>
					

				</table>
				</div>
				
	</center>
</body>
</html>