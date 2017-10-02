
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order History</title>
</head>
<body>
<c:forEach items="${allOrders}" var="order">
				${order.id}
				${order.date}
				${deliveryAddress.street}
				${deliveryAddress.street2}
				${deliveryAddress.city}
				${deliveryAddress.state}
				${deliveryAddress.zip}
		 <form action="shop.do" method="POST">
		<input type="text" name="company" value="${company.id}"/><br/>
		<input type="submit" value="Shop Here" />
		 </form>
			</c:forEach>

</body>
</html>