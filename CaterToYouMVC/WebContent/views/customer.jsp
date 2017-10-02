<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cater To You</title>
</head>
<body>
	First Name: ${customer.firstName} Last Name: ${customer.lastName}

	<form action="shop.do" method="POST">
		<input type="submit" value="Shop" />
	</form>

	Billing Address Street: ${address.street} Street 2: ${address.street2}
	City: ${address.city} State: ${address.state} Zip: ${address.zip}
	<form action="updateAddress.do" method="POST">
		<input type="submit" value="Update" />
	</form>
	
	<form action="orderHistory.do" method="POST">
		<input type="submit" value="Order History" />
	</form>
	<form action="showCart.do" method="POST">
		<input type="submit" value="Show Cart"/>
	</form>
	
	
</body>
</html>