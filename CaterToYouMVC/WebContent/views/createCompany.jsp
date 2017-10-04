<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="makeCompany.do" method="POST">

	Name: <input
			type="text" name="name" value="" /><br /> New
		Street: <input type="text" name="street" value="" /><br />
		Street2: <input type="text" name="street2"
			value="" /><br /> City: <input type="text"
			name="city" value="" /><br /> State: <input
			type="text" name="state" value="" /><br /> Zip:
		<input type="text" name="zip" value="" /><br /> Image
		URL: <input type="text" name="url" value="" /><br />
		<input type="submit" value="Edit Company Profile" />
	</form>
</body>
</html>