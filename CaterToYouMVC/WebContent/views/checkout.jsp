
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
<title>Check Oout</title>
</head>
<body>
	<h4>Your Cart</h4>
	<ul>
		<c:forEach items="${itemList}" var="item">
			<li>${item.count} ${item.item.name} ${item.item.price * item.count}</li>
		</c:forEach>
	</ul>
	
	<form action="createOrder.do" method="POST">
		<input type="hidden" name="cartId" value="" />
		<input type="submit" value="Update" />
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