<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New or Edit User</title>
</head>
<body>
	<c:url var="saveEmployeeURL" value="/save" />
	<div align="center">
		<h1>New/Edit User</h1>
		<table>
			<form:form action="${saveEmployeeURL}" method="post" modelAttribute="employee">
				<form:hidden path="id" />
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" maxlength="100"/></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" maxlength="100"/></td>
				</tr>
				
<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</form:form>
		</table>
	</div>

</body>
</html>
				