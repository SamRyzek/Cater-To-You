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
<link rel="stylesheet" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cater To You</title>
</head>
<style>

html {

	background-image: url("css/food2.jpg");
	background-repeat: no-repeat;
	background-origin: inheret;
	background-size: 100%;
	background-color: blue;

}

body {
	
	background-color: darkblue;
	border: 2px solid white;
	color: white;
} 
 
</style>
<body>
	<div class="modal-dialog">
		<div class="loginmodal-container">
			<h1>Cater To You</h1>
			<br>
			<form action="checkLogin.do" method="POST">
				${loginErr}
				<input type="text" name="username"></input>
				<p>Username:</p>
				<input type="text" name="password"></input> <input type="submit"
					name="submit" value="Login"></input>
				<p>Password:</p>
			</form>
			<a href="newUser.do">Create new Customer Account</a>

		</div>
	</div>
</body>
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

