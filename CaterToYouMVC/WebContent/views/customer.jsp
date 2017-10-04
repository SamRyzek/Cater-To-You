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
<title>Cater To You</title>
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
</head>
<body class="active">
	<div>
		<ul>
			<li><form action="Shop.do" method="GET">
					<a href="Shop.do">Shop</a>
				</form></li>

			<li><form action="UpdateCustomer.do?customerId=${user.customer.id}" method="GET">
					<a href="UpdateCustomer.do?customerId=${user.customer.id}">Update</a>
				</form></li>

			<li><form action="OrderHistory.do" method="GET">
					<a href="OrderHistory.do">Go To History</a>
				</form></li>

			<li><form action="showCart.do" method="GET">
					<a href="showCart.do">Go To Cart</a>
				</form></li>
			<!-- <li style="float: right"><form action="customer.do" method="GET">
					<a href="index.do">Return Home</a>
			</form></li> -->
		</ul>
	</div>
	<div>
		<p>${user.firstName}${user.lastName}</p>
		<p>Email: ${user.email}</p>
		<p>${address.street}${address.street2}</p>
		${address.city} ${address.state} ${address.zip}
		<img alt="picture" src="">
	</div>
	

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
