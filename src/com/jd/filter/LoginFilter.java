package com.jd.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)req;
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		PrintWriter out = resp.getWriter();
		
		
//		System.out.println("=====开始======");
		if(uri.indexOf("login") == -1 && uri.indexOf("index") == -1 && uri.indexOf("css") == -1 && uri.indexOf("javascript") == -1){
			
			String loginName = (String)session.getAttribute("userName");
	    	if(loginName == null){
	    		
	    		out.write("<script>alert('请先登录'); location.href='"+"index.jsp';</script>");
	    	}else{
	    		chain.doFilter(request, resp);
	    		
	    	}
	    	
		}else{
			chain.doFilter(request, resp);
			
		}
//		System.out.println("=====结束======");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
