<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./logo/mail_logo.png">
<link href="Login.css" rel="stylesheet">
<title>Login Page</title>
</head>
<body class="login-body">
	<div class="login-signup-container">
		<h3>Login</h3>
			<form class="login-container" action="login" method="post">
				<input type="text" name="email" id="email" placeholder="Email">
				<input type="password" name="password" placeholder="Password">
				<input type="submit" value="Login" id="submitButton" class="btn btn-success">
			</form>
		<div class="signuplogin-container">
			<p><b>Don't have an account?</b></p>
			<form action="signup.jsp" method="post">
				<input type="submit" value="Register" class="btn btn-primary">
			</form>
		</div>
	</div>
	<script>
		document.getElementById("submitButton").addEventListener("click", function() {
    		var email = document.getElementById("email").value;
    		localStorage.setItem("email", email.toString());
		});
	</script>
</body>
</html>