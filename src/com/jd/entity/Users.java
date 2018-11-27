package com.jd.entity;

public class Users {

	private int userID;
	private String user_tel;
	private String user_name;
	private String user_password;
	private String user_email;
	private String user_date;
	private String login_name;		//  在登录的时候使用的帮助存储属性 可存 user_name/user_tel/user_email


	public Users() {
		
	}

	public Users(int userID) {
		this.userID = userID;
	}

	public Users(String login_name) {
		this.login_name = login_name;
	}

	public Users(String login_name, String user_password) {
		this.login_name = login_name;
		this.user_password = user_password;
	}
	
	public Users(int userID, String user_tel, String user_name, String user_password) {
		this.userID = userID;
		this.user_tel = user_tel;
		this.user_name = user_name;
		this.user_password = user_password;
	}

	public Users(String user_tel, String user_name, String user_password, String user_email) {
		this.user_tel = user_tel;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
	}

	public Users(int userID, String user_tel, String user_name, String user_password, String user_email) {
		this.userID = userID;
		this.user_tel = user_tel;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
	}

	public Users(int userID, String user_tel, String user_name, String user_password, String user_email,
			String user_date) {
		this.userID = userID;
		this.user_tel = user_tel;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
		this.user_date = user_date;
	}

	//          ----  get set  -----
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_date() {
		return user_date;
	}

	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}
	
	public String getLogin_name() {
		return login_name;
	}
	
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", user_tel=" + user_tel + ", user_name=" + user_name + ", user_password="
				+ user_password + ", user_email=" + user_email + ", user_date=" + user_date + ", login_name="
				+ login_name + "]";
	}

	
}