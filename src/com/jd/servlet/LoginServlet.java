package com.jd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jd.entity.Users;
import com.jd.service.impl.UserServiceImpl;

import net.sf.json.JSONArray;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");*/

		String login_name = request.getParameter("login_name");
		String password = request.getParameter("password");
		Users user = new Users(login_name,password);
		System.out.println(user);
		String attr = null;
		ArrayList list = new ArrayList();
		if(login_name.indexOf('@') > 0){
			attr = "email";
			
		}else if((login_name.charAt(0) <= 'Z' && login_name.charAt(0) >= 'A')
				|| (login_name.charAt(0) <= 'z' && login_name.charAt(0) >= 'a')){
			attr = "name";
		}else{
			attr = "tel";
		}
		
		UserServiceImpl us = new UserServiceImpl();
		Users f_login = us.findUsersByLogin(user, attr);
		System.out.println(f_login);
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int f = 0;
		if(f_login != null){
			f = 1;
			session.setAttribute("login_name", login_name);
		
		}else{
			f = 0;

		}
		list.add(f);
		JSONArray json = JSONArray.fromObject(list);
		out.print(json);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
