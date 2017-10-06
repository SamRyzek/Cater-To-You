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
<link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Customer Profile</title>
</head>
<body class="active">
	<div id="nav-bar">
		<ul>
			<li style="float: right"><a href="customer.do">Return Home</a></li>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
		</ul>
	</div>
	<div id="main-section">
		<div class="row">
			<div class="col-4">
				<form action="editCustomer.do" method="POST">
					<input type="hidden" name="id" value="${user.customer.id}">
					<table>
						<tr>
							<td>Customer Name:</td>
							<td>
								<input type="text" name="oldname" value="${user.firstName} ${user.lastName}" readonly />
							</td>
						</tr>
						<tr>
							<td>Email:</td>
							<td>
								<input type="text" name="email" value="${user.email}" />
							</td>
						</tr>
						<tr>
							<td>Street:</td>
							<td>
								<input type="text" name="street" value="${address.street}" />
						</tr>
						<tr>
							<td>Street2:</td>
							<td>
								<input type="text" name="street2" value="${address.street2}" />
							</td>
						</tr>
						<tr>
							<td>City:</td>
							<td>
								<input type="text" name="city" value="${address.city}" />
							</td>
						</tr>
						<tr>
							<td>State:</td>
							<td>
								<input type="text" name="state" value="${address.state}" />
							</td>
						</tr>
						<tr>
							<td>Zip:</td>
							<td>
					 			<input type="text" name="zip" value="${address.zip}" />
							</td>
						</tr>
					</table>
					<input type="submit" value="Update" />
				</form>
			</div>
			<div class="col-4">
				<form action="udateUserPass.do" method="POST">
					<label class="stuff">Username: </label> <input type="hidden"
						name="id" value="${user.id}"> <input type="text"
						name="newUserName" value="${user.username }"><br> <label
						class="stuff">Password</label> <input type="text"
						name="newPassword" value="${user.password}"><br> <input
						type="submit" value="Update">
				</form>
			</div>
			<div class="col-4">
				<form action="editCustomerImage.do" method="POST">
				<input type="hidden" name="customerId" value="${user.customer.id}">
				<label class="stuff">Image URL:</label> <input type="text"
					name="imageUrl" value="${user.customer.image.imageUrl}" /><br>
				<!-- delete this if issues -->
				<input type="submit" value="Update" />
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
</body>
</html>