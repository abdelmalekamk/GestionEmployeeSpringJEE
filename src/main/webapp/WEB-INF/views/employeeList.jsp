<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<c:url var="newEmployeeURL" value="/new" />
	<div align="center">
		<h1>Employees List</h1>
		<h2>
			<a href="${newEmployeeURL}">New Employee</a>
		</h2>

		<table border="1">
			<th>No</th>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Actions</th>
<c:forEach var="employee" items="${employeeList}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${employee.id}</td>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td><c:url var="editEmployeeURL" value="/edit">
							<c:param name="id" value="${employee.id}" />
						</c:url> <c:url var="deleteEmployeeURL" value="/delete">
							<c:param name="id" value="${employee.id}" />
						</c:url> <a href="${editEmployeeURL}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
						<form action="${deleteEmployeeURL}" method="post"
							name="deleteEmployee">
							<input type="hidden" name="id" value="${employee.id}" /> <input
								type="submit" value="Delete" />
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
			