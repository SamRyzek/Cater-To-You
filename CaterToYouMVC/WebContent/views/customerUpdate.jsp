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
<title>Insert title here</title>
</head>
<body>
 <form action="editCustomer.do" method="POST">
		Name of Customer:
		<input type="text" name="oldname" value="${user.firstName} ${user.lastName}"readonly/><br/>
		Email:
		<input type="text" name="email" value="${user.email}"/><br/>
		Billing Address:
		Street:
		<input type="text" name="street" value="${address.street}"/><br/>
		Street 2: 
		<input type="text" name="street2" value="${address.street2}"/><br/>
		City: 
		<input type="text" name="city" value="${address.city}"/><br/>
		State:
		<input type="text" name="state" value="${address.state}" /><br/>
		Zip: 
		<input type="text" name="zip" value="${address.zip}"/><br/>
		<input type="submit" value="Edit Profile" />
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