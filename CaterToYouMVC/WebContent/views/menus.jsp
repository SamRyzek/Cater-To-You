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
<title>Company Selections</title>
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
		<li><form action="showCart.do" method="GET">
				<a href="showCart.do">Go To Cart</a>
			</form></li>
		<li style="float: right"><form action="customer.do" method="GET">
				<a href="customer.do">Return Home</a>
			</form></li>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
	</ul>

	<c:forEach items="${allCompanies}" var="company">
				${company.name}
				${company.address.street}
				${company.address.street2}
				${copmany.address.city}
				${company.address.state}
				${company.address.zip}
		 <form action="ShopHere.do" method="GET">
			<input type="hidden" name="companyId" value="${company.id}" /><br />
			<input type="submit" value="Shop Here" />
		</form>
	</c:forEach>


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