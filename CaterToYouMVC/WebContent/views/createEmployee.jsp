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
<link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
</head>
<body>
	<div id="nav-bar">
		<ul>
			<li style="float: right"><a href="index.do">Return Home</a></li>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
		</ul>
	</div>
	<div id="main-section">
	<form action="MakeEmployee.do" method="POST">
		<input type="hidden" name="companyId" value="${company.id}" /><label
			class="stuff"> FirstName:</label> <input type="text" name="fName"
			value="" /><br />
		<label class="stuff">Last Name:</label> <input type="text"
			name="lName" value="${address.street}" /><br />
		<label class="stuff"> User Name: </label><input type="text"
			name="username" value="" /><br />
		<label class="stuff"> Password: </label> <input type="text"
			name="password" value="" /><br />
		<label class="stuff"> Email: </label> <input type="text" name="email"
			value="" /><br /> <input type="submit" value="Create Employee" />
	</form>
	</div>

</body>
</html>
