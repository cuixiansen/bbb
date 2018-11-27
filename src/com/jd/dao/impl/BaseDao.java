package com.jd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 增删改----------------------------------
	public int UpdateDate(Connection conn,  String sql, Object[] objs) throws SQLException{
		this.conn =  conn;
			ps = conn.prepareStatement(sql);
			if(objs != null){
				for(int i=0; i<objs.length; i++){
					ps.setObject(i+1, objs[i]);
				}
			}
		return ps.executeUpdate();
	}
	
	// 查找----------------------------------
	public ResultSet SelectDate(Connection conn,  String sql, Object[] objs) throws SQLException{
			this.conn =  conn;
				ps = conn.prepareStatement(sql);
				if(objs != null){
					for(int i=0; i<objs.length; i++){
						ps.setObject(i+1, objs[i]);
					}
				}
			return ps.executeQuery();
		}


	public void closeAll(){
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs = null;
		ps = null;
		conn = null;
		
	}
	
}
