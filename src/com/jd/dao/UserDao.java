package com.jd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jd.entity.Users;
import com.jd.helper.Page;


public interface UserDao {

	// 添加管理员------------------------------
	public int insertUsers(Connection conn,Users user) throws SQLException;

	// 通过id删除管理员------------------------------
	public int deleteUsersById(Connection conn,int id) throws SQLException;

	// 通过id修改管理员------------------------------
	public int updateUsersById(Connection conn,Users user) throws SQLException;
	
	// 通过id查找管理员--------------------------
	public ResultSet selectUsersById(Connection conn,int id) throws SQLException;
	
	// 通过名字查找管理员--------------------------
	public ResultSet selectUsersByName(Connection conn,String name,String op) throws SQLException;
	
	// 查找所有管理员--------------------------
	public ResultSet selectAllUsers(Connection conn) throws SQLException;
	
	// 登录管理员--------------------------
	public ResultSet selectUsersByLogin(Connection conn,Users user,String op) throws SQLException;
	
	// 查找所有管理员并分页--------------------------
	public ResultSet selectAllUsersByPage(Connection conn,Page<Users> page) throws SQLException;
	
	// 得到管理员所有记录
	public ResultSet getAllRecord(Connection conn) throws SQLException;
	
}
