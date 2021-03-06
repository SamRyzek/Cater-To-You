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
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check Out</title>
</head>
<body class="active">
	<div id="nav-bar">	
		<ul class="One">
			<li>	<a href="showCart.do">Go To Cart</a></li>
			<li style="float: right"><a href="customer.do">Return Home</a></li>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
		</ul>
	</div>
	<div id="main-section">
		<div class="row">
		<div class="col-6">
			<h4>Your Cart</h4>
			<ul class="Two">
				<c:forEach items="${itemList}" var="item">
					<li>${item.count} ${item.item.name}
					<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${item.item.price * item.count}"/>$</li>
				</c:forEach>
			</ul>
				<p>Sub Total: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${subTotal}"/>$</p>
				<p>Tax: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${tax}"/>$</p>
				<p>Fee: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${fee}"/>$</p>
				<p>Total: <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${total}"/>$</p>
			</div>
		<div class="col-6">
		<form action="createOrder.do" method="POST">
			<p>Delivery Date: <input type="text" name="date" id="datepicker"></p>
	 		<p>Delivery Time: <input type="text" name="time" class="timepicker"></p>
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
		 							${address.zip}
		 						</option>
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
			<input type="hidden" name="cartId" value="${cart.id}" />
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
			</div>
			<p>
				<input type="submit" value="Checkout" />
			</p>
		</form>
		
		</div>
	</div>
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
					if (elem !== null) {
						elem.addEventListener("change",
								function(eve) {
									var elementId = eve.target
											.getAttribute("data-sec");
									if (elementId == "section-1") {
										$("#section-1").removeClass(
												"closed-section").addClass(
												"open-section");
										$("#section-2").removeClass(
												"open-section").addClass(
												"closed-section");
									} else {
										$("#section-2").removeClass(
												"closed-section").addClass(
												"open-section");
										$("#section-1").removeClass(
												"open-section").addClass(
												"closed-section");
									}
								});
					}

				});
	</script>
</body>
</html>
