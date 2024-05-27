<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="ComposeEmail.css" rel="stylesheet">
<title>Compose Email</title>
</head>
<body>
	<div class="compose_email-container">
		<h1>Compose Email</h1>
		<form class="compose-email" action="compose" method="post">
			<input id="reciver_email" name="reciver_email" style="display: none;">
			<input class="input" type="text" name="sender_email" placeholder="To" required>
			<input class="input" type="text" name="subject" placeholder="Subject" >
			<textarea class="textarea input" name="compose_email" placeholder="Compose Email" required></textarea>
			<input id="sendButton" class="btn btn-primary" type="submit" value="Send">
		</form>
	</div>
	<script>
		document.getElementById("sendButton").addEventListener("click", function() {
    		var email = localStorage.getItem("email");
    		document.getElementById("reciver_email").value = email;
		});
</script>
</body>
</html>