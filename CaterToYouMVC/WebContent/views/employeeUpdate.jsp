//Not complete


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update "${employee.firstName}" "${employee.lastName}"</title>
</head>
<body>
<form action="updateItem.do" method="POST">
			Name:
			<input type="text" name="name" value="${item.name}"/><br/>
			Calories:
			<input type="text" name="calories" value="${item.calories}"/><br/>
			Description:
			<input type="text" name="desc" value="${item.desc}"/><br/>
			Price ($XX.XX):
			<input type="text" name="price" value="${item.desc}"/><br/>
			Availability (Quantity):
			<input type="text" name="availability" value="${item.desc}"/><br/>
</form>
</body>
</html>