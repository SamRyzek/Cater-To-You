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
</head>
<body>
	First Name: ${user.firstName} Last Name: ${user.lastName}

	<form action="Shop.do" method="GET">
		<input type="submit" value="Shop" />
	</form>

	Email: ${user.email}
	Billing Address Street: ${address.street} Street 2: ${address.street2}
	City: ${address.city} State: ${address.state} Zip: ${address.zip}
	<form action="UpdateCustomer.do" method="POST">
		<input type="submit" value="Edit Profile" />
	</form>
	
	<form action="OrderHistory.do" method="GET">
		<input type="submit" value="Order History" />
	</form>
	<form action="showCart.do" method="GET">
		<input type="submit" value="Show Cart"/>
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