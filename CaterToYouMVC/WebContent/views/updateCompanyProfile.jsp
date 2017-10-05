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
<link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update ${company.name}</title>
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
	border-right: 1px solid #bbb;
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
</style>
<body>
	<div>
		<ul>
			<li style="float: right"><form action="companyUpdate.do"
					method="GET">
					<a href="companyUpdate.do">Return Home</a>
				</form></li>
		</ul>
		<li style="float: right"><a href="loggOut.do">Log Out</a></li>
	</div>
	<div>
		<form action="editCompany.do" method="POST">
			Name of Customer: <input type="text" name="oldname"
				value="${user.firstName} ${user.lastName}" readonly /><br />
			Email: <input type="text" name="email" value="${user.email}" /><br />
			Billing Address: Street: <input type="text" name="street"
				value="${address.street}" /><br /> Street 2: <input type="text"
				name="street2" value="${address.street2}" /><br /> City: <input
				type="text" name="city" value="${address.city}" /><br /> State: <input
				type="text" name="state" value="${address.state}" /><br /> Zip: <input
				type="text" name="zip" value="${address.zip}" /><br /> <input
				type="submit" value="Update" />
		</form>
	</div>


</body>
</html>