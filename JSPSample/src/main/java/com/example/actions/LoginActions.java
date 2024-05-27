package com.example.actions;

import java.util.List;


import com.example.datalayer.EmailDatabase;
import com.example.model.Email;
import com.opensymphony.xwork2.ActionSupport;

public class LoginActions extends ActionSupport{
	
	private String email;
	private String password;
	private static List<Email> emailList;
	String currentMenu;
	
	public String getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(String currentMenu) {
		this.currentMenu = currentMenu;
	}

	public String execute() {
	    boolean result=EmailDatabase.validataeUser(email, password);
	    emailList=(EmailDatabase.getEmails(email, "Inbox"));
	    System.out.println(result);
	    if(result) {
	    	currentMenu="Inbox.jsp";
	    	System.out.println("login success");
	    	CurrentUser currentUser=new CurrentUser();
	    	currentUser.setEmail(email);
			return SUCCESS;
	    }
	    else {
	    	System.out.println("login fail");
	    	return ERROR;
	    }
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Email> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<Email> emailList) {
		this.emailList = emailList;
	}
}
