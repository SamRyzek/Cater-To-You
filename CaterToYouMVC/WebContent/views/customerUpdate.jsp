<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Update Customer Profile</title>
</head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
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

	min-width: 200px

}

</style>
<body class="active">

	<ul>
		<li style="float: right"><form action="customer.do" method="GET">
				<a href="customer.do">Return Home</a>
			</form></li>
	</ul>

	<form action="editCustomer.do" method="POST">
		<label class ="stuff">Name of Customer:</label> <input type="text" name="oldname" value="${user.firstName} ${user.lastName}" readonly /><br> 
		<input type="hidden" name="id" value="${user.customer.id}">
		<label class ="stuff">Email:</label> <input type="text" name="email" value="${user.email}" /><br>
		Billing Address: <br> <label class="stuff">Street:</label> <input type="text" name="street" value="${address.street}" /><br> 
		<label  class ="stuff">Street 2:</label> <input type="text" name="street2" value="${address.street2}" /><br>
		<label class ="stuff">City:</label> <input type="text" name="city" value="${address.city}" /><br> 
		<label class ="stuff">State:</label> <input type="text" name="state" value="${address.state}" /> <br>
		<label class ="stuff">Zip:</label> <input type="text" name="zip" value="${address.zip}" /> <br>
		<input type="submit" value="Update" /><br>
	</form>
	
	<div>
		<form action="udateUserPass.do" method="POST">
		<label class ="stuff">Username: </label>
			<input type="hidden" name="id" value="${user.id}">
			<input type="text" name="newUserName" value="${user.username }"><br>
		<label class ="stuff">Password</label>
			<input type="text" name="newPassword" value="${user.password}"><br>
			<input type="submit" value="Update">
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