<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Update "${user.firstName}" "${user.lastName}"</title>
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
	background-color: darkblue;
}

body {
	background-color: darkblue;
	border: 2px solid white;
	color: white;
}

.stuff {
	min-width: 100px;
}
</style>
<body>
	<form action="editUser.do" method="POST">
		<label class="stuff">First Name of Employee to Edit:</label> <input
			type="text" name="firstName" value="${user.firstName}" readonly /><br />
		<label class="stuff">Last Name:</label> <input type="text"
			name="lastName" value="${user.lastName}" /><br /> <label
			class="stuff">Username:</label> <input type="text" name="username"
			value="${user.username}" /><br /> <label class="stuff">Password:</label>
		<input type="text" name="password" value="${user.password}" /><br /> <label
			class="stuff">Email:</label> <input type="text" name="email"
			value="${user.email}" /><br /> <input type="hidden" name="id"
			value="${user.id}" /><br /> <input type="submit"
			value="Update Employee Information" />
	</form>

	<form action="InactivateEmployee.do" method="POST">
		<input type="hidden" name="oldId" value="${employee.employeeID}" /><input
			type="submit" value="Make Employee Inactive" />
	</form>
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