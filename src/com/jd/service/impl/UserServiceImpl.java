package com.jd.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jd.dao.impl.UserDaoImpl;
import com.jd.entity.Users;
import com.jd.helper.DBconnection;
import com.jd.helper.Page;
import com.jd.service.UserService;


public class UserServiceImpl implements UserService{

	private UserDaoImpl us;
	
	public UserServiceImpl(){
		us = new UserDaoImpl();
	}
	
	@Override
	public int addUsers(Users user) {
		Connection conn = DBconnection.getconnection();
		int temp = 0;
		try {
			
				conn.setAutoCommit(false);
				temp = us.insertUsers(conn, user);
				conn.commit();
				conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			us.closeAll();
		}
		return temp;
	}

	@Override
	public int delUsersById(int id) {
		Connection conn = DBconnection.getconnection();
		int temp = 0;
		try {			
			conn.setAutoCommit(false);
			temp = us.deleteUsersById(conn, id);
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			us.closeAll();
		}
		return temp;
	}

	@Override
	public int updUsersById(Users user) {
		Connection conn = DBconnection.getconnection();
		int temp = 0;
		try {
			
			conn.setAutoCommit(false);
			temp = us.updateUsersById(conn, user);
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			us.closeAll();
		}
		return temp;
	}

	@Override
	public Users findUsersById(int id) {
		Connection conn = DBconnection.getconnection();
		try {
			conn.setAutoCommit(false);
			ResultSet rs = us.selectUsersById(conn, id);
			conn.commit();
			conn.setAutoCommit(true);
			if(rs.next()){
				int userID = rs.getInt("userID");
				String user_tel = rs.getString("user_tel");
				String user_name = rs.getString("user_name");
				String user_password = rs.getString("user_password");
				String user_email = rs.getString("user_email");
				return new Users(userID,user_tel,user_name,user_password,user_email);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			us.closeAll();
		}
		return null;
	}

	@Override
	public Users findUsersByName(String name, String op) {
		Connection conn = DBconnection.getconnection();
		try {
			conn.setAutoCommit(false);
			ResultSet rs = us.selectUsersByName(conn, name, op);
			conn.commit();
			conn.setAutoCommit(true);
			if(rs.next()){
				int userID = rs.getInt("userID");
				String user_tel = rs.getString("user_tel");
				String user_name = rs.getString("user_name");
				String user_password = rs.getString("user_password");
				String user_email = rs.getString("user_email");
				return new Users(userID,user_tel,user_name,user_password,user_email);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			us.closeAll();
		}
		return null;
	}

	@Override
	public List<Users> findAllUsers() {
		Connection conn = DBconnection.getconnection();
		ArrayList<Users> list = new ArrayList<Users>();
		try {
			conn.setAutoCommit(false);
			ResultSet rs = us.selectAllUsers(conn);
			conn.commit();
			conn.setAutoCommit(true);
			while(rs.next()){
				int userID = rs.getInt("userID");
				String user_tel = rs.getString("user_tel");
				String user_name = rs.getString("user_name");
				String user_password = rs.getString("user_password");
				String user_email = rs.getString("user_email");
				list.add(new Users(userID,user_tel,user_name,user_password,user_email));
			}
			return list;
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			us.closeAll();
		}
		return null;
	}

	@Override
	public Users findUsersByLogin(Users user, String op) {
		Connection conn = DBconnection.getconnection();
		try {
			conn.setAutoCommit(false);
			ResultSet rs = us.selectUsersByLogin(conn, user, op);
			conn.commit();
			conn.setAutoCommit(true);
			if(rs.next()){
				int userID = rs.getInt("userID");
				String user_tel = rs.getString("user_tel");
				String user_name = rs.getString("user_name");
				String user_password = rs.getString("user_password");
				String user_email = rs.getString("user_email");
				return new Users(userID,user_tel,user_name,user_password,user_email);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			us.closeAll();
		}
		return null;
	}

	@Override
	public Page<Users> findAllUsersByPage(Page<Users> page) {
		Connection conn = DBconnection.getconnection();
		ArrayList<Users> list = new ArrayList<Users>();
		int totalRecord = 0;
		try {
			totalRecord = getAllRecords();
			conn.setAutoCommit(false);
			ResultSet rs = us.selectAllUsersByPage(conn, page);
			conn.commit();
			conn.setAutoCommit(true);
			while(rs.next()){
				int userID = rs.getInt("userID");
				String user_tel = rs.getString("user_tel");
				String user_name = rs.getString("user_name");
				String user_password = rs.getString("user_password");
				String user_email = rs.getString("user_email");
				list.add(new Users(userID,user_tel,user_name,user_password,user_email));
			}
			page.setList(list);
			page.setTotleRecord(totalRecord);
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			us.closeAll();
		}
		return page;
	}

	@Override
	public int getAllRecords() {
		Connection conn = DBconnection.getconnection();
		try {
			conn.setAutoCommit(false);
			ResultSet rs = us.getAllRecord(conn);
			conn.commit();
			conn.setAutoCommit(true);
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			us.closeAll();
		}
		return 0;
	}

}
