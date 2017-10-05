
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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check Out</title>
</head>
<style>
ul.One {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

ul.Two{


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
.stuff{

	min-width: 150px

}

</style>
<body class="active">
	<ul class="One">
		<li><form action="showCart.do" method="GET">
				<a href="showCart.do">Go To Cart</a>
			</form></li>
		<li style="float: right"><form action="customer.do" method="GET">
				<a href="customer.do">Return Home</a>
			</form></li>
	</ul>
	<h4>Your Cart</h4>
	<ul class="Two">
		<c:forEach items="${itemList}" var="item">
			<li>${item.count} ${item.item.name} $${item.item.price * item.count}</li><br>
		</c:forEach>
	</ul>
	<br></br>
	<form action="createOrder.do" method="POST">
		<input type="hidden" name="cartId" value="${cart.id}" />
		<label class = "stuff">
			Delivery Date: </label> <input type="text" name="date" id="datepicker"><br>
		
		<label class = "stuff">
			Delivery Time: </label><input type="text" name="time" class="timepicker"><br>
		
		<label class = "stuff">
			street: </label> <input type="text" name="street"><br>
		
		<label class = "stuff">
			street2: </label><input type="text" name="street2"><br>
			
		<label class = "stuff">
			city:</label><input type="text" name="city"> <br>
			
		<label class ="stuff">
			state:</label><input type="text" name="state"> <br>
		
		<label class ="stuff">
			zip code:</label> <input type="text" name="zip"><br>
		
		<p>
			<input type="submit" value="Checkout" />
		</p>
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
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker();
		});
	</script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.timepicker').timepicker({
				timeFormat : 'h:mm p',
				interval : 15,
				minTime : '8',
				maxTime : '6:00pm',
				defaultTime : '11',
				startTime : '10:00',
				dynamic : false,
				dropdown : true,
				scrollbar : true
			});
		});
	</script>
</body>
</html>