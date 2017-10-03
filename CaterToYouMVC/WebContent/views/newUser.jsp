<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Registration</title>
</head>



<body>

	<h1>Personal Details</h1><br>
	<form action="newUser.do" method="POST">
		
		First Name:
		<input type="text" name="firstName">
		<br>
		Last Name:
		<input type="text" name="lastName">
		<br>
		Username:
		<input type="text" name="username">
		<br>
		Password:
		<input type="text" name="password">
		<br>
		Email:
		<input type="text" name="email">
		<br>
		<input type=submit value="Create Customer Registration">
	
	</form>



</body>
</html>