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
<title>Company Selections</title>
<style type="text/css">
  .comp-img {
  	width: 70px;
  	height: auto;
  }
 	td {
 	padding:5px;
 	}
</style>
</head>
<body class="active">
	<div id="nav-bar">
		<ul>
			<li style="float: right"><a href="index.do">Return Home</a></li>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
		</ul>
	</div>
	<div id="main-section">
	<table>
	<c:forEach items="${allCompanies}" var="company">
		<tr>
			<td>
				${company.name}<br>
				${company.address.street}
				${company.address.street2}
				${copmany.address.city}
				${company.address.state}
				${company.address.zip}
			<td>
			<td>
				<img alt="company pic" class="comp-img" src="${company.image.imageUrl}">
			</td>
			<td>
				 <form action="ShopHere.do" method="GET">
					<input type="hidden" name="companyId" value="${company.id}" /><br />
					<input type="submit" value="Shop Here" />
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>
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