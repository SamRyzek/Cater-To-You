
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Admin Control</title>
</head>
<body>
	<div id="nav-bar">
		<ul>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
		</ul>
	</div>
	<div id="main-section">
	
	<c:if test="${not empty companies}">
		<form action="AdminUpdateCompany.do" method="GET">
			Company: <select name="companyID">
				<c:forEach items="${companies}" var="company">
					<option value="${company.id}">${company.name}</option>
				</c:forEach>
			</select> <input type="submit" value="Update" />
		</form>
	</c:if>
	<c:if test="${not empty users}">
		<form action="UpdateAccount.do" method="GET">
			User: <select name="userID">
				<c:forEach items="${users}" var="otherUser">
					<option value="${otherUser.id}">${otherUser.id}
						${otherUser.firstName} ${otherUser.lastName}</option>
				</c:forEach>
			</select> <input type="submit" value="Update" />
		</form>
	</c:if>

	<form action="CreateCompany.do" method="GET">
		<input type="submit" value="Create Company" />
	</form>
	<c:if test="${not empty companiesActive}">

		<form action="InactivateCompany.do" method="POST">
			Active Companies: <select name="companyID">
				<c:forEach items="${companiesActive}" var="company2">
					<option value="${company2.id}">${company2.name}</option>
				</c:forEach>
			</select> <input type="submit" value="Make Company Inactive" />
		</form>
	</c:if>
	<c:if test="${not empty companiesInactive}">
		<form action="ActivateCompany.do" method="POST">
			Inactive Companies: <select name="companyID">
				<c:forEach items="${companiesInactive}" var="company3">
					<option value="${company3.id}">${company3.name}</option>
				</c:forEach>
			</select> <input type="submit" value="Make Company Active" />
		</form>
	</c:if>
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