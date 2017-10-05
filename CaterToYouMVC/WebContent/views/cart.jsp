<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Cart</title>
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
</style>
<body class="active">
	<ul>
		<li><a href="checkout.do">Check Out</a></li>
		<li style="float: right"><a href="customer.do">Return Home</a></li>
		<li style="float: right"><a href="loggOut.do">Log Out</a></li>

	</ul>
	<c:choose>
		<c:when test="${empty cart}">
			<h3>Your cart is empty</h3>
		</c:when>
		<c:otherwise>
			<table>
				<thead>
					<tr>
						<th>Item Number</th>
						<th>Item</th>
						<th>Count</th>
						<th>Unit Price</th>
						<th>Item Total</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${itemList}" var="item" varStatus="loop">
						<tr>
							<td>${loop.index}</td>
							<td>${item.item.name}</td>
							<td>
								<form action="changeQuantity.do" method="POST"> <!-- needs to remove item if q is 0 -->
									<input type="hidden" name="itemId" value="${item.id}">
									<input type="text" name="count" value="${item.count}">
									<input type="submit" value="update">
								</form>
							</td>
							<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${item.item.price}"/>$</td>
							<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${item.item.price * item.count}"/>$</td>
							<td>
								<form action="removeItem.do" method="POST">
									<input type="hidden" name="itemId" value="${item.id}">
									<input type="submit" value="Delete">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<p>Sub Total: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${subTotal}"/>$</p>
		<p>Tax: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${tax}"/>$</p>
		<p>Fee: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${fee}"/>$</p>
		<p>Total: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${tax}"/>$</p>
		</c:otherwise>
	</c:choose>


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