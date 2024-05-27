<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.example.actions.LoginActions"%>
<%@ page import="com.example.model.Email"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="Inbox.css" rel="stylesheet">
<title>Inbox Page</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%
	LoginActions loginActions = new LoginActions();
	List<Email> emailList = loginActions.getEmailList();
	%>
	<%
	if (emailList != null) {
	%>
	
		<%
		for (Email emails : emailList) {
		%>
		<div class="email-container">
			<div class="menu-sender-subject-container">
				<div class="inner-email-container three-dot-menu">
					<i class="fa-solid fa-ellipsis-vertical"></i>
				</div>
				<div class="inner-email-container three-dot-menu">
					<p><%=emails.getReciver_email()%></p>
				</div>
				<div class="inner-email-container subject">
					<p><%=emails.getEmail_subject()%></p>
				</div>
			</div>
			<div class="inner-email-container send-date">
				<i class="fa-regular fa-calendar"></i>
				<h6><%=emails.getSend_date()%></h6>
			</div>

		</div>
		<%
		}
		%>
	</div>
	<%
	}
	%>
</body>
</html>