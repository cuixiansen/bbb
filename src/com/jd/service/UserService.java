package com.jd.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jd.entity.Users;
import com.jd.helper.Page;


public interface UserService {

		// 添加管理员------------------------------
		public int addUsers(Users user);

		// 通过id删除管理员------------------------------
		public int delUsersById(int id);

		// 通过id修改管理员------------------------------
		public int updUsersById(Users user);
		
		// 通过id查找管理员--------------------------
		public Users findUsersById(int id);
		
		// 通过名字查找管理员--------------------------
		public Users findUsersByName(String name, String op);
		
		// 查找所有管理员--------------------------
		public List<Users> findAllUsers();
		
		// 登录管理员--------------------------
		public Users findUsersByLogin(Users user, String op);
		
		// 查找所有管理员并分页--------------------------
		public Page<Users> findAllUsersByPage(Page<Users> page);
		
		public int getAllRecords();
	
}
