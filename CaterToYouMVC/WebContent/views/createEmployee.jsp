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
<title>Add Employee</title>
</head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
	border-right: 1px solid #bbb;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

html {
	background-image: url("css/food2.jpg");
	background-repeat: no-repeat;
	background-origin: inheret;
	background-size: 100%;
	background-color: blue;
}

body {
	background-color: darkblue;
	border: 2px solid white;
	color: white;
	
}
</style>
	<form action="MakeEmployee.do" method="POST">
		<input type="hidden" name="companyId" value="${company.id}" /> FirstName: <input
			type="text" name="fName" value="" /><br /> Last Name: <input
			type="text" name="lName" value="${address.street}" /><br /> User
		Name: <input type="text" name="username" value="" /><br /> Password:
		<input type="text" name="password" value="" /><br /> Email: <input
			type="text" name="email" value="" /><br /> <input type="submit"
			value="Create Employee" />
	</form>


</body>
</html>