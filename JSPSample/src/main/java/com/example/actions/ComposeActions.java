package com.example.actions;

import java.time.LocalDate;

import com.example.datalayer.EmailDatabase;
import com.opensymphony.xwork2.ActionSupport;

public class ComposeActions extends ActionSupport{

	private String reciver_email;
	private String sender_email;
	private String subject;
	private String compose_email;
	String currentMenu;
	
	public String getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(String currentMenu) {
		this.currentMenu = currentMenu;
	}

	public String execute() {
	
		String send_date=LocalDate.now().toString();
		boolean result=EmailDatabase.composeEmail(reciver_email, sender_email, subject, compose_email, send_date);
		System.out.println(result);
		currentMenu="Inbox.jsp";
		if(result) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	public String getSender_email() {
		return sender_email;
	}

	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCompose_email() {
		return compose_email;
	}

	public void setCompose_email(String compose_email) {
		this.compose_email = compose_email;
	}

	public String getReciver_email() {
		return reciver_email;
	}

	public void setReciver_email(String reciver_email) {
		this.reciver_email = reciver_email;
	}
}
