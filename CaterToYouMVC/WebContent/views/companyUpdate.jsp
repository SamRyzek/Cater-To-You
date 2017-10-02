<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Company Info</title>
</head>
<body>
 <form action="updateCompany.do" method="POST">
		Name of Company to Edit:
		<input type="text" name="oldname" value="${company.name}" readonly/><br/>
		New Name:
		<input type="text" name="name" value="${company.name}"/><br/>
		New Street:
		<input type="text" name="street" value="${adress.street}"/><br/>
		New Street2:
		<input type="text" name="street2" value="${adress.street2}"/><br/>
		New City:
		<input type="text" name="city" value="${adress.city}"/><br/>
		New State:
		<input type="text" name="state" value="${adress.state}"/><br/>
		New Zip:
		<input type="text" name="zip" value="${adress.zip}"/><br/>
		Image URL: 
		<input type="text" name="url" value="${image.imageUrl}"/><br/>
		<input type="submit" value="Edit Maze" />
	</form>
	Update Menu Item: <select name="menuItems">
			<c:forEach items="${menu}" var="item">
				<option value="${item.id}">${item.name}</option>
			</c:forEach>
		</select> <input type="submit" value="Update" />
	Update Staff: <select name="staff">
			<c:forEach items="${staff}" var="employee">
				<option value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</select> <input type="submit" value="Update" />
</body>
</html>


