package com.jd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jd.dao.UserDao;
import com.jd.entity.Users;
import com.jd.helper.Page;


public class UserDaoImpl extends BaseDao implements UserDao{

	
	// 增加管理员--------------------------
	@Override
	public int insertUsers(Connection conn, Users user) throws SQLException {
		String sql = "insert into users (user_tel,user_name,user_password,user_email,user_date) "+
				" values(? , ? , ?, ?, now())";
		Object[] objs = {user.getUser_tel(),user.getUser_name(),user.getUser_password(),user.getUser_email()};
		return UpdateDate(conn, sql, objs);
	}
	
	// 通过id删除管理员--------------------------
	@Override
	public int deleteUsersById(Connection conn, int id) throws SQLException {
		String sql = "delete from users where userID = ?";
		Object[] objs = {id};
		return UpdateDate(conn, sql, objs);
	}

	// 通过id修改管理员--------------------------
	@Override
	public int updateUsersById(Connection conn, Users user) throws SQLException {
		String sql = "update users set user_tel=? , user_name=?, user_password, user_email where userID = ?";
		Object[] objs = {user.getUser_tel(),user.getUser_name(),user.getUser_password(),user.getUser_email(),user.getUserID()};
		return UpdateDate(conn, sql, objs);
	}

	// 通过id查找管理员--------------------------
	@Override
	public ResultSet selectUsersById(Connection conn, int id) throws SQLException{		// TODO Auto-generated method stub
		String sql = "select * from users where userID = ? ";
		Object[] objs = {id};
		return SelectDate(conn, sql, objs);
	}

	// 通过名字查找管理员--------------------------
	@Override
	public ResultSet selectUsersByName(Connection conn, String name, String op) throws SQLException {
		String sql = "select * from users ";
		if("tel".equals(op)){
			sql += " where user_tel = ?";
		}else if("name".equals(op)){
			sql += " where user_name = ?";
		}else if("email".equals(op)){
			sql += " where user_email = ?";
		}
		Object[] objs = {name};
		return SelectDate(conn, sql, objs);
	}

	// 查找所有管理员--------------------------
	@Override
	public ResultSet selectAllUsers(Connection conn) throws SQLException {
		String sql = "select * from users order by userID ";
		return SelectDate(conn, sql, null);
	}

	// 登录管理员--------------------------
	@Override
	public ResultSet selectUsersByLogin(Connection conn, Users user,String op) throws SQLException {
		String sql = "select * from users where user_password = ? ";
		System.out.println(op);
		if("tel".equals(op)){
			sql += " and user_tel = ?";
		}else if("name".equals(op)){
			sql += " and user_name = ?";
		}else if("email".equals(op)){
			sql += " and user_email = ?";
		}
		Object[] objs = {user.getUser_password(),user.getLogin_name()};
		return SelectDate(conn, sql, objs);
	}

	// 查找所有管理员分页显示--------------------------
	@Override
	public ResultSet selectAllUsersByPage(Connection conn, Page<Users> page) throws SQLException {
		String sql = "select * from users order by userID limit ?,? ";
		Object[] objs = {page.getPageSize()*page.getCurrentPage(),((page.getCurrentPage()-1)*page.getPageSize())};
		return SelectDate(conn, sql, objs);
	}

	@Override
	public ResultSet getAllRecord(Connection conn) throws SQLException {
		String sql = "select count(userID) from users ";
		return SelectDate(conn, sql, null);
	}

	
	
	
}
