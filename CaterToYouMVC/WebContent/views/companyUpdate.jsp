<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Company Info</title>
</head>
<body>
	<form action="editCompany.do" method="POST">

		<input type="hidden" name="id" value="${company.id}" /> <input
			type="hidden" name="addId" value="${address.id}" /> Name: <input
			type="text" name="name" value="${company.name}" /><br /> New
		Street: <input type="text" name="street" value="${address.street}" /><br />
		New Street2: <input type="text" name="street2"
			value="${address.street2}" /><br /> New City: <input type="text"
			name="city" value="${address.city}" /><br /> New State: <input
			type="text" name="state" value="${address.state}" /><br /> New Zip:
		<input type="text" name="zip" value="${address.zip}" /><br /> Image
		URL: <input type="text" name="url" value="${image.imageUrl}" /><br />
		<input type="submit" value="Edit Company Profile" />
	</form>
	<c:if test="${not empty menu}">
	<form action="UpdateMenuItem.do" method="POST">
		Update Menu Item: <select name="itemId">
	
			<c:forEach items="${menu}" var="item">
				<option value="${item.id}">${item.name}</option>
			</c:forEach>
		</select> <input type="submit" value="Update Menu Item" />
	</form>
	</c:if>
	<form action="CreateEmployee.do" method="GET">
	<input
			type="hidden" name="companyId" value="${company.id}" />
		<input type="submit" value="Add Employee" />
	</form>
	<c:if test="${not empty staff}">
	<form action="UpdateStaff.do" method="POST">
		Update Staff: <select name="staffId">
	
			<c:forEach items="${staff}" var="user">
				<option value="${user.id}">${user.lastName}, ${user.firstName}</option>
			</c:forEach>
		</select> <input type="submit" value="Update Employee" />
	</form>
	</c:if>
	<c:if test="${not empty inactiveId}">
	<form action="ActivateEmployee.do" method="POST">
	Inactive Employees: <select name="inactiveId">
	
			<c:forEach items="${inactiveStaff}" var="user">
				<option value="${user.id}">${user.lastName}, ${user.firstName} </option>
			</c:forEach></select>
		<input type="submit" value="Make Employee Active" />
	</form>
</c:if>
	<form action="index.do" method="GET">
		<input type="submit" value="Return Home" />
	</form>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document.write('<script src="js/jquery.min.js"><\/script>')
	</script>

	<script src="js/holder.js"></script>

	<script src="js/bootstrap.min.js"></script>
</body>
</html>


