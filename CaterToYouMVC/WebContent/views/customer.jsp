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
<link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cater To You</title>
<<<<<<< HEAD
<style type="text/css">
	.picture-profile {
		width:300px;
		height:auto;
	}
</style>
</head>
<body class="active">
	<div id="nav-bar">
		<ul>
			<li><a href="Shop.do">Shop</a></li>
			<li><a href="UpdateCustomer.do?customerId=${user.customer.id}">Update</a></li>
			<li><a href="OrderHistory.do">Go To History</a></li>
			<li><a href="showCart.do">Go To Cart</a></li>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
		</ul>
	</div>
	<div id="main-section">
		<div class="row">
			<div class="col-4">
				<p>${user.firstName}${user.lastName}</p>
				<p>Email: ${user.email}</p>
				<p>${address.street}${address.street2}</p>
				${address.city} ${address.state} ${address.zip}
			</div>
			<div class="col-4">
				<p>
					<img alt="picture" class="picture-profile" src="${user.customer.image.imageUrl}">
				</p>
			</div>
		</div>


=======

</head>
<body class="main-section">
	<div>
		<ul>
			<li><form action="Shop.do" method="GET">
					<a href="Shop.do">Shop</a>
				</form></li>
			<li><form
					action="UpdateCustomer.do?customerId=${user.customer.id}"
					method="GET">
					<a href="UpdateCustomer.do?customerId=${user.customer.id}">Update</a>
				</form></li>
			<li><form action="OrderHistory.do" method="GET">
					<a href="OrderHistory.do">Go To History</a>
				</form></li>
			<li><form action="showCart.do" method="GET">
					<a href="showCart.do">Go To Cart</a>
				</form></li>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
		</ul>
	</div>
	<div>
		<p>${user.firstName}${user.lastName}</p>
		<p>Email: ${user.email}</p>
		<p>${address.street}${address.street2}</p>
		${address.city} ${address.state} ${address.zip}
		<p class = "Image-container">
			<img alt="picture" src="${user.customer.image.imageUrl}">
		</p>
>>>>>>> b169288a851ede9fd9725c2714c974f9d9b592e4

	</div>

</body>
</html>
