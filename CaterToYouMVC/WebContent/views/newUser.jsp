<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>Customer Registration</title>
</head>

<body>
	<div id="nav-bar">
		<ul>
			<li style="float: right"><a href="index.do">Return Home</a></li>
		</ul>
	</div>
	<div id="main-section">
	<h1>Personal Details</h1>
	<br>
	<form action="newUser.do" method="POST">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>
		</table>
		  <input type=submit value="Create Customer Registration">

	</form>
	</div>

</body>
</html>