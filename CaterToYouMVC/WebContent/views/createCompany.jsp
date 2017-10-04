<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="editCompany.do" method="POST">

		<input type="hidden" name="id" value="${company.id}" /> <input
			type="hidden" name="addId" value="${address.id}" /> Name: <input
			type="text" name="name" value="${company.name}" /><br /> New
		Street: <input type="text" name="street" value="${address.street}" /><br />
		New Street2: <input type="text" name="street2"
			value="${address.street2}" /><br /> New City: <input type="text"
			name="city" value="${address.city}" /><br /> New State: <input
			type="text" name="state" value="${address.state}" /><br /> New Zip:
		<input type="text" name="zip" value="${address.zip}" /><br /> Image
		URL: <input type="text" name="url" value="${image.imageUrl}" /><br />
		<input type="submit" value="Edit Company Profile" />
	</form>
</body>
</html>