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
<link rel="stylesheet" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cater To You</title>
</head>
<body>
	${user.firstName} ${user.lastName}
	<p>Email: ${user.email}</p> 
	<p>Billing Address: ${address.street} 
	${address.street2} </p>
	${address.city} ${address.state} ${address.zip}
	
	<form action="Shop.do" method="GET">
		<input type="submit" value="Shop" />
	</form>

	<form action="UpdateCustomer.do" method="POST">
		<input type="submit" value="Edit Profile" />
	</form>

	<form action="OrderHistory.do" method="GET">
		<input type="submit" value="Order History" />
	</form>
	
	<form action="showCart.do" method="GET">
		<input type="submit" value="Show Cart" />
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

 
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
	position: fixed;
	width: 100%;
	color: white;
	bottom: 0;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: bottom;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: white;
}


html {
	background-image: url("3D-Solar-System-Wallpaper.jpg");
	background-color: black;
	background-size: cover;
	background-repeat: no-repeat;
}
.list{
	vertical-align:text-bottom;
	vertical-align: -50px;
}

</style>
</head>
<body>
	<div class="navbar">
		<ul>

			<li><a href="newPlanet.html">Add Planet</a></li>

			<li><a href="removePlanet.html">Remove Planet</a></li>

			<li><a href="updatePlanet.html">Update Planet</a></li>
		</ul>
	</div>