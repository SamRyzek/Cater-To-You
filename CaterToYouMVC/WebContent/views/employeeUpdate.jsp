<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update "${employee.firstName}" "${employee.lastName}"</title>
</head>
<body>
<form action="updateEmployee.do" method="POST">
		First Name of Employee to Edit:
		<input type="text" name="firstName" value="${user.firstName}" readonly/><br/>
		Last Name:
		<input type="text" name="lastName" value="${user.lastName}"/><br/>
		
	</form>
</body>
</html>