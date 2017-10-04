<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="MakeEmployee.do" method="POST">
		<input type="hidden" name="companyId" value="${company.id}" /> FirstName: <input
			type="text" name="fName" value="" /><br /> Last Name: <input
			type="text" name="lName" value="${address.street}" /><br /> User
		Name: <input type="text" name="username" value="" /><br /> Password:
		<input type="text" name="password" value="" /><br /> Email: <input
			type="text" name="email" value="" /><br /> <input type="submit"
			value="Create Employee" />
	</form>


</body>
</html>