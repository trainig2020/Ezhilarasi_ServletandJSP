<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>
	<center>
		<h3>
			
				<a href="<%=request.getContextPath()%>/list">List of
						Department</a>
			
		</h3>
	</center>
	<div>
		<div>
			<div >
				<c:if test="${dept != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${dept == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${dept != null}">
                                    Edit Department
                                </c:if>
						<c:if test="${dept == null}">
                                    Add New Department
                                </c:if>
					</h2>
				</caption>

				<c:if test="${dept != null}">
					<input type="hidden" name="deptId"
						value="<c:out value='${dept.deptId}' />" />
				</c:if>

				<fieldset >
					<label>DeptId </label> <input type="text"
						value="<c:out value='${dept.deptId}' />" 
						name="deptId" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>DeptName</label> <input type="text"
						value="<c:out value='${dept.deptName}' />" 
						name="deptName">
				</fieldset>



				<button type="submit" >Save</button>

			</div>
		</div>
	</div>
</body>
</html>