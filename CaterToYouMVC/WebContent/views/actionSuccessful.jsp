<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>Insert title here</title>
</head> 
<body>
	<div id="nav-bar">
	<ul>
		<li style="float: right"><a href="customer.do">Return Home</a></li>
		<li style="float: right"><a href="loggOut.do">Log Out</a></li>
	</ul>
	</div>
	<div id= "main-section">

	<!-- depending on what action was taken, display that on the screen  -->
	<h1>Action Successful</h1>
	<h2>${message}</h2>
	</div>
	

</body>
</html>