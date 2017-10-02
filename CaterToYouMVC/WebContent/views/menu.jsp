<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cater To You - ${company.name}</title>
</head>
<body>
	
	<c:forEach items="${menu}" var="item">
				${item.name}
				${item.description}
				${item.price}
		 <form action="addToCart.do" method="POST">
				Quantity
		<input type="number" name="quantity" value="${count}"/><br/>
		<input type="submit" value="Add to Cart" />
		 </form>
			</c:forEach>
</body>
</html>