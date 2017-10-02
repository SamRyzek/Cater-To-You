<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update "${item.name}"</title>
</head>
<body>
<form action="updateItem.do" method="POST">
			Name:
			<input type="text" name="name" value="${item.name}"/><br/>
			Calories:
			<input type="text" name="calories" value="${item.calories}"/><br/>
			Description:
			<input type="text" name="desc" value="${item.desc}"/><br/>
			Price ($XX.XX):
			<input type="text" name="price" value="${item.desc}"/><br/>
			Availability (Quantity):
			<input type="text" name="availability" value="${item.desc}"/><br/>
</form>

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