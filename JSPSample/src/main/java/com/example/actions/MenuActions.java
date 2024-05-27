package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;

public class MenuActions extends ActionSupport{
	
	String currentMenu;

	public String getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(String currentMenu) {
		this.currentMenu = currentMenu;
	}
	
	public String execute() {
		return SUCCESS;
	}
	
}
