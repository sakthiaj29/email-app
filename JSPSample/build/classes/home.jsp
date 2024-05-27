<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./logo/mail_logo.png">
<link href="Home.css" rel="stylesheet">

<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#ComposePage").click(function(){
                $.ajax({
                    url: "ComposeEmail.jsp",
                    type: "GET",
                    success: function(response){
                    	currentMenu="ComposeEmail.jsp";
                        $("#contantpage").html(response);
                    }
                });
            });
        });
        $(document).ready(function(){
            $("#InboxPage").click(function(){
                $.ajax({
                    url: "Inbox.jsp",
                    type: "GET",
                    success: function(response){
                    	currentMenu="Inbox.jsp";
                        $("#contantpage").html(response);
                    }
                });
            });
        });
        $(document).ready(function(){
            $("#SendPage").click(function(){
                $.ajax({
                    url: "Send.jsp",
                    type: "GET",
                    success: function(response){
                    	currentMenu="Send.jsp";
                        $("#contantpage").html(response);
                    }
                });
            });
        });
    </script>
</head>
<body>
	<div class="body-container">
		<div class="header">
			<div class="logo-container">
				<img src="./logo/mail_logo.png" alt="Email" class="mail-logo">
			</div>
			<div class="proile-info-container">
				<div class="proile-info">S</div>
			</div>
		</div>
		<div class="menu-contant">
			<div class="menu-list">
				<form class="menu-folders" action="chooseMenu" method="post">
					<input type="submit" name="currentMenu" value="ComposeEmail.jsp">
					<input type="submit" name="currentMenu" value="Inbox.jsp">
					<input type="submit" name="currentMenu" value="Send.jsp">
				</form>
				<button id="ComposePage">Compose</button>
				<button id="InboxPage">Inbox</button>
				<button id="SendPage">Send</button>
			</div>
			<div id="contantpage" class="contant">
				<s:include value="%{currentMenu}" />
			</div>
		</div>
	</div>
</body>
</html>