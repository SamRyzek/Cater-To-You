<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Control</title>
</head>
<body>
<form action="updateCompany.do" method="GET">
		Company: <select name="company">
			<c:forEach items="${companies}" var="company">
				<option value="${company.id}">${company.name}</option>
			</c:forEach>
		</select> <input type="submit" value="Update" />
	</form>
<form action="updateCustomer.do" method="GET">
		Company: <select name="customer">
			<c:forEach items="${customers}" var="customer">
				<option value="${customer.id}">${customer.id} ${customer.name}</option>
			</c:forEach>
		</select> <input type="submit" value="Update" />
	</form>

</body>
</html>