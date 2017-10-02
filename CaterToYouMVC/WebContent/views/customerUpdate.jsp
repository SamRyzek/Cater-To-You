<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="editCustomer.do" method="POST">
		Name of Customer:
		<input type="text" name="oldname" value="${customer.name}" readonly/><br/>
		Email:
		<input type="text" name="name" value="${customer.name}"/><br/>
		Billing Address:
		Street:
		<input type="text" name="street" value="${address.street}"/><br/>
		Street 2: 
		<input type="text" name="street2" value="${address.street2}"/><br/>
		City: 
		<input type="text" name="city" value="${address.city}"/><br/>
		Zip: 
		<input type="text" name="zip" value="${address.zip}"/><br/>
		<input type="submit" value="Edit Profile" />
	</form>

</body>
</html>