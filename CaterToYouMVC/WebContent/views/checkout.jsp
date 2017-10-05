
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

.open-section {
	display: block;
}

.closed-section {
	display: none;
}

ul.Two {
	
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
	background-color: blue;
}

body {
	background-color: darkblue;
	border: 2px solid white;
	color: white;
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
			<li>${item.count}${item.item.name}$${item.item.price*
				item.count}</li>
		</c:forEach>
	</ul>
	<br></br>
	<form action="createOrder.do" method="POST">


		<input type="hidden" name="cartId" value="${cart.id}" />
		<p>
			Delivery Date: <input type="text" name="date" id="datepicker">
		</p>
		<p>
			Delivery Time: <input type="text" name="time" class="timepicker">
		</p>
		<c:choose>
			<c:when test="${not empty addressList}">
				<div id="radio-section">
				<p>
					New Address<input type="radio" name="addressType" checked data-sec="section-1" value="0"> 
					Previous Address<input type="radio" name="addressType" data-sec="section-2" value="1">
				</p>
			</div>
			<div class="closed-section" id="section-2">
				<select name="addressId">
					<c:forEach items="${addressList}" var="address">
						<option value="${address.id}">${address.street}
							${address.street2} ${address.city}, ${address.state}
							${address.zip}</option>
					</c:forEach>
				</select>
			</div>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="addressType" value="0">
				<input type="hidden" name="addressId" value="0">
			</c:otherwise>
		</c:choose>
		<div class="open-section" id="section-1">
			<p>
				street: <input type="text" name="street" value=" ">
			</p>
			<p>
				street2: <input type="text" name="street2" value=" ">
			</p>
			<p>
				city: <input type="text" name="city" value=" "> state: <input
					type="text" name="state" value=" "> zip code: <input type="text"
					name="zip" value=" ">
			</p>
		</div>
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
		$(document).ready(
				function() {
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
					var elem = document.getElementById("radio-section");
					if(elem !== null){
						elem.addEventListener(
								"change",
								function(eve) {
									var elementId = eve.target
											.getAttribute("data-sec");
									if (elementId == "section-1") {
										$("#section-1").removeClass(
												"closed-section").addClass(
												"open-section");
										$("#section-2").removeClass("open-section")
												.addClass("closed-section");
									} else {
										$("#section-2").removeClass(
												"closed-section").addClass(
												"open-section");
										$("#section-1").removeClass("open-section")
												.addClass("closed-section");
									}
								});
					}
					
				});
	</script>
</body>
</html>