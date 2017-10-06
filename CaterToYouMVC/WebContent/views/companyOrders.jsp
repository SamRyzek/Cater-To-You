
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
<link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order History</title>
</head>
<body class="active">
	<div id="nav-bar">
		<ul class="One">
			<li style="float: right"><a href="index.do">Return Home</a></li>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
		</ul>
	</div>
	<div id="main-section">
	<table>
		<c:forEach items="${orders}" var="order">
			<tr>
			<td>${order.id} ${order.deliveryDateTime} ${order.address.street}
				${order.address.street2} ${order.address.city}
				${order.address.state} ${order.address.zip}</td>
			<td>
			<form action="OrderInformation.do" method="GET">
				<input type="hidden" name="orderID" value="${order.id}" /> <input
					type="hidden" name="companyID" value="${company.id}" /> <input
					type="submit" value="See Order Items" />
			</form></td>
			</tr>
		</c:forEach>
		
	</table>
	</div>	


	<!-- scripts below -->

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous">
		
	</script>

	<script>
		window.jQuery
				|| document.write('<script src="js/jquery.min.js"><\/script>')
	</script>

	<script src="js/holder.js"></script>

	<script src="js/bootstrap.min.js"></script>



</body>
</html>