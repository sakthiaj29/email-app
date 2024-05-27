package com.example.model;

public class Email {

	private int id;
	private String reciver_email;
	private String sender_email;
	private String email_subject;
	private String compose_email;
	private String send_date;
	
	public Email(int id, String reciver_email, String sender_email,String email_subject,String compose_email, String send_date) {
		this.setId(id);
		this.reciver_email=reciver_email;
		this.sender_email=sender_email;
		this.email_subject=email_subject;
		this.compose_email=compose_email;
		this.send_date=send_date;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getReciver_email() {
		return reciver_email;
	}
	
	public void setReciver_email(String reciver_email) {
		this.reciver_email = reciver_email;
	}
	
	public String getSender_email() {
		return sender_email;
	}
	
	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}
	public String getEmail_subject() {
		return email_subject;
	}
	
	public void setEmail_subject(String email_subject) {
		this.email_subject = email_subject;
	}
	
	public String getCompose_email() {
		return compose_email;
	}
	
	public void setCompose_email(String compose_email) {
		this.compose_email = compose_email;
	}
	
	public String getSend_date() {
		return send_date;
	}
	
	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}
}
