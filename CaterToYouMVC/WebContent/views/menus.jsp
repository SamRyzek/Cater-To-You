<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${allCompanies}" var="company">
				${company.name}
				${address.street}
				${address.street2}
				${address.city}
				${address.state}
				${address.zip}
		 <form action="shopHere.do" method="POST">
		<input type="text" name="companyId" value="${company.id}"/><br/>
		<input type="submit" value="Shop Here" />
		 </form>
			</c:forEach>
</body>
</html>