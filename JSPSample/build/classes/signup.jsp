<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="Signup.css" rel="stylesheet">
<title>SignUp Page</title>
</head>
<body>
	<div class="signup-container">
			<form action="signup" class="signup">
				<input type="text" name="name" placeholder="Name" required>
				<input type="text" name="mobile" placeholder="Mobile" required>
				<input type="text" name="city" placeholder="City" required>
				<input type="text" name="email" placeholder="Email" required>
				<input type="password" name="password" placeholder="Password"
					required>
				 <input type="submit" value="Register">
			</form>
	</div>

</body>
</html>