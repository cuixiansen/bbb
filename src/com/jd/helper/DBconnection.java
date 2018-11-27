package com.jd.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class DBconnection {

	private static String url;
	private static String user;
	private static String password;
	private static String Driver;
	
	static {
//		List<Element> list = new ParseDB().getList();
//		url = list.get(0).getText();
//		user = list.get(1).getText();
//		password = list.get(2).getText();
		ResourceBundle rb = ResourceBundle.getBundle("db");
		url = rb.getString("url");
		user = rb.getString("user");
		password = rb.getString("password");
		Driver = rb.getString("Driver");
		
		
		try {
			Class.forName(Driver);
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}
	
	public static Connection getconnection(){
		try {
			System.out.println("创立链接成功");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("创立链接失败");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
}
