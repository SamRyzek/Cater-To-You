<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Item</title>
</head>
<body>
	<c:if test="${not empty message}">
	<p>${message}</p>
	</c:if>
	<form action="MakeItem.do" method="POST">
	<input type="hidden" name="companyID" value="${company.id}" />

		Name*: <input type="text" name="name" value="" /><br />
		Calories: <input type="text" name="calories" value="" /><br />
		Description*: <input type="text" name="description"
			value="${item.description}" /><br /> Price ($XX.XX)*: <input
			type="text" name="price" value="" /><br /> Availability*
		(Quantity): <input type="number" name="availability"
			value="" /><br /> Image Url: <input type="text"
			name="imageURL" value="" /><br /> <br /> <input
			type="submit" value="Create Item" />
			
	</form>


</body>
</html>