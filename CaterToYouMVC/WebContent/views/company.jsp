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
<title>${company.name}</title>
</head>
<body class="active">
	<div id="nav-bar">
		<ul>
			<li><a href="updateCompanyProfile.do">Update Company Profile</a></li>
			<li style="float: right"><a href="loggOut.do">Log Out</a></li>
		</ul>
	</div>
	<div id="main-section">
		<div class="row">
			<div class="col-6">
				<h3>${company.name}</h3>
				Street: ${address.street} <br> Street 2: ${address.street2} <br>
				City: ${address.city} <br> State: ${address.state} <br>
				Zip: ${address.zip} <br>
				<form action="Orders.do" method="GET">
					<input type="hidden" name="companyID" value="${company.id}" /> <input
						type="submit" value="Orders" />
				</form>
			</div>
			<div class="col-6">
				<ul>
					<c:forEach items="${menu}" var="item">
						<li>
						${item.name}
						${item.description}
						${item.price}
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		
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





