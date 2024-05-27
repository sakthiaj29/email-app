package com.example.actions;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class EmailDetailsAction extends ActionSupport {
   
	private int emailId;
    private String emailDetailsJson;


    public String getEmailDetails() {
        
    	Gson gson=new Gson();
    	emailDetailsJson=gson.toJson(getEmailDetails());
        return SUCCESS;
    }

    public int getEmailId() {
		return emailId;
	}


	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}


	public String getEmailDetailsJson() {
		return emailDetailsJson;
	}


	public void setEmailDetailsJson(String emailDetailsJson) {
		this.emailDetailsJson = emailDetailsJson;
	}

}
