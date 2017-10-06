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
<title>Create Item</title>
</head>
<body>
	<div id="nav-bar">
		<ul>
			<li style="float: right"><a href="index.do">Return Home</a></li>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
		</ul>
	</div>
	<div id="main-section">
	<c:if test="${not empty message}">
		<p>${message}</p>
	</c:if>
	<form action="MakeItem.do" method="POST">
		<input type="hidden" name="companyID" value="${company.id}" /> <label
			class="stuff">Name*: </label><input type="text" name="name" value="" /><br />
		<label class="stuff">Calories:</label> <input type="text"
			name="calories" value="" /><br /> <label class="stuff">Description*:</label>
		<input type="text" name="description" value="${item.description}" /><br />
		<label class="stuff">Price ($XX.XX)*:</label> <input type="text"
			name="price" value="" /><br /> <label class="stuff">Availability*
			(Quantity): </label><input type="number" name="availability" value="" /><br />
		<label class="stuff">Image Url: </label><input type="text"
			name="imageURL" value="" /><br /> <br /> <input type="submit"
			value="Create Item" />

	</form>
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

</body>
</html>
