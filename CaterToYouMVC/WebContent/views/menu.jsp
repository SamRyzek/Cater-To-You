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
<title>Cater To You - ${company.name}</title>
</head>
<body>
	${company.name} ${address.street} ${address.street2} ${address.city}
	${address.state} ${address.zip}

	<c:forEach items="${menu}" var="item">
				${item.name}
				${item.description}
				${item.price}
				
		 <form action="addToCart.do" method="POST">
		 	<input type="hidden" name="itemId" value="${item.id}">
		 	<input type="hidden" name="company" value="${company.id}">
			Quantity <input type="number" name="quantity" value="${count}" /><br />
			<input type="submit" value="Add to Cart" />
		</form>
	</c:forEach>
	
	<form action="showCart.do" method="GET">
		<input type="submit" value="Show Cart">
	</form>
	
	<form action="index.do" method="GET">
		<input type="submit" value="Return Home"/>
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