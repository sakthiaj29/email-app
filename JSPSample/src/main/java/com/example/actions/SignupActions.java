package com.example.actions;

import com.example.datalayer.EmailDatabase;
import com.opensymphony.xwork2.ActionSupport;

public class SignupActions extends ActionSupport{

	private String name;
	private String mobile;
	private String city;
	private String email;
	private String password;
	
	public String execute() {
		
		boolean result=EmailDatabase.addUser(name, mobile, city, email, password);
		if(result) {
			System.out.println("signup succsess");
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
}
