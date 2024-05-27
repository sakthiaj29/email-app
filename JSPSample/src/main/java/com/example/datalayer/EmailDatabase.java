package com.example.datalayer;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Email;

public class EmailDatabase {

	private static final String URL="jdbc:mysql://localhost:3306/jspsample?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="root";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
	}
	
	public static boolean composeEmail(String reciver_email, String sender_email, String email_subject, String compose_email, String send_date) {
		String sql="INSERT INTO emails(reciver_email, sender_email, email_subject, compose_email, send_date) values (?, ?, ?, ?, ?)";
		try {
			Connection connection=getConnection();
			PreparedStatement preStmt=connection.prepareStatement(sql);
			preStmt.setString(1, reciver_email);
			preStmt.setString(2, sender_email);
			preStmt.setString(3, email_subject);
			preStmt.setString(4, compose_email);
			preStmt.setString(5, send_date);
			int rowsAffected=preStmt.executeUpdate();
			return rowsAffected>0;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Email getEmail(int id) {
		String sql="SELECT * FROM emails WHERE id=?";
		Email email=null;
		try {
			Connection connection=getConnection();
			PreparedStatement preStmt=connection.prepareStatement(sql);
			ResultSet result=preStmt.executeQuery();
			email=new Email(
					result.getInt("id"),
					result.getString("reciver_email"),
					result.getString("sender_email"),
					result.getString("email_subject"),
					result.getString("compose_email"),
					result.getString("send_date")
					);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}
	
	public static List<Email> getEmails(String currentUserEmail, String type){
		System.out.println("getEmail");
		List<Email> emailsList=new ArrayList<>();
		String sql="";
		if(type.equals("Inbox")) {
			sql="SELECT * FROM emails WHERE sender_email=? order by send_date DESC";
		}
		else if(type.equals("Send")) {
			sql="SELECT * FROM emails WHERE reciver_email=? order by send_date DESC";
		}
		
		try {
			Connection connection=getConnection();
			PreparedStatement preStmt=connection.prepareStatement(sql);
			preStmt.setString(1, currentUserEmail);
			ResultSet result=preStmt.executeQuery();
			while(result.next()) {
				Email email=new Email(
						result.getInt("id"),
						result.getString("reciver_email"),
						result.getString("sender_email"),
						result.getString("email_subject"),
						result.getString("compose_email"),
						result.getString("send_date")
						);
					emailsList.add(email);	
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 	emailsList;
	}
	public static boolean validataeUser(String email, String password) {
		String sql="SELECT email, password FROM users WHERE email=? AND password=?";
		try {
			Connection connection=getConnection();
			PreparedStatement preStmt=connection.prepareStatement(sql);
			preStmt.setString(1, email);
			preStmt.setString(2, password);
			ResultSet result=preStmt.executeQuery();
			return result.next();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean addUser(String name, String mobile, String city, String email, String password) {
		if(userExist(email)) {
			System.out.println("user exits, cannot added");
			return false;
		}
		String sql="INSERT INTO users(name, mobile, city, email, password) values (?, ?, ?, ?, ?)";
		try {
			Connection connection=getConnection(); 
			PreparedStatement preStmt=connection.prepareStatement(sql);
			preStmt.setString(1, name);
			preStmt.setString(2, mobile);
			preStmt.setString(3, city);
			preStmt.setString(4, email);
			preStmt.setString(5, password);
			int rowsAffected=preStmt.executeUpdate();
			return rowsAffected>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static boolean userExist(String email) {
		String sql="SELECT COUNT(*) FROM users WHERE email=?";
		try {
			Connection connection=getConnection(); 
			PreparedStatement preStmt=connection.prepareStatement(sql);
			preStmt.setString(1, email);
			ResultSet result=preStmt.executeQuery();
			int count=result.getInt(1);
			return count>0;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
