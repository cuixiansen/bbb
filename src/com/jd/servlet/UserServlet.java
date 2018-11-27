package com.jd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.entity.Users;
import com.jd.service.impl.UserServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/Users/userServlet")
public class UserServlet extends HttpServlet{
	
	private UserServiceImpl us;
	
	public UserServlet(){
		us = new UserServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");*/
		
		String op = request.getParameter("op");
		System.out.println(op);
		if("doAddUsers".equals(op)){
			doAddUsers(request,response);
			
		}else if("doDelUsers".equals(op)){
			doDelUsers(request, response);
			
		}else if("doEditUsers".equals(op)){
			doEditUsers(request, response);
			
		}else if("doShowUsers".equals(op)){
			doShowUsers(request, response);
			
		}else if("readyEditUsers".equals(op)){
			readyEditUsers(request, response);
			
		}else if("doCheck".equals(op)){
			doCheck(request, response);
			
		}
	
	}

	protected void doAddUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user_tel = request.getParameter("user_tel");
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		String user_email = request.getParameter("user_email");
		ArrayList list = new ArrayList();
		String op = null;
		
		int f = us.addUsers(new Users(user_tel,user_name,user_password,user_email));
		PrintWriter out = response.getWriter();
		if(f > 0){
			list.add("1");
		}else{
			list.add("0");
		}
		JSONArray json = JSONArray.fromObject(list);
		out.print(json);
	}

	protected void doDelUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	int id = Integer.parseInt(request.getParameter("id"));
		
		PrintWriter out = response.getWriter();
		int f = adi.delAdminById(id);
		if(f > 0){
			out.write("<script>alert('删除成功');location.href='adminServlet?currentPage=1&Pagesize=5&op=doShowAdmin'</script>'</script>");
		}else{
			out.write("<script>alert('删除失败');history.back();</script>");
		}*/
		
	}
	
	protected void doEditUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userID = Integer.parseInt(request.getParameter("userID"));
		String user_tel = request.getParameter("user_tel");
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		String user_email = request.getParameter("user_email");
		ArrayList list = new ArrayList();

		PrintWriter out = response.getWriter();
		int f = us.updUsersById(new Users(userID,user_tel,user_name,user_password,user_email));
		if(f>0){
			list.add("1");
			
		}else{
			list.add("0");
			
		}
		JSONArray json = JSONArray.fromObject(list);
		out.print(json);
	}
	
	protected void doShowUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*int currentpage = Integer.parseInt(request.getParameter("currentPage"));	
		int pagesize = Integer.parseInt(request.getParameter("Pagesize"));	
		
		Page<Admin> adPage = adi.findAllAdminByPage(new Page<Admin>(currentpage,pagesize));
		
		
		request.setAttribute("adPage", adPage);
		request.getRequestDispatcher("showAdmin.jsp").forward(request, response);*/

	}
	
	protected void readyEditUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userID = Integer.parseInt(request.getParameter("userID"));
		Users user = us.findUsersById(userID);
		JSONObject json = JSONObject.fromObject(user);
		response.getWriter().print(json);
		
	}
	
	protected void doCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String attr = request.getParameter("attr");
		String attr_name = request.getParameter("attr_name");
		Users user = new Users();
		String f = "0";
		user = us.findUsersByName(attr_name, attr);
		ArrayList list = new ArrayList();
			
		if(user == null){
			f = "-1";
		}else {
			f = "1"; 
		}
		list.add(f);
		JSONObject json = JSONObject.fromObject(f);
		response.getWriter().print(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
