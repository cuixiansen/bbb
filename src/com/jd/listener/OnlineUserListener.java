package com.jd.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
		ServletContext application = event.getSession().getServletContext();
		
		Object obj = application.getAttribute("onlineNum");
		if(obj == null){
			application.setAttribute("onlineNum", 1);
		}else{
			int num = Integer.valueOf(application.getAttribute("onlineNum").toString());
			application.setAttribute("onlineNum", num+1);
			
		}
		System.out.println("上线---------------");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
ServletContext application = event.getSession().getServletContext();
		
		Object obj = application.getAttribute("onlineNum");
		if(obj == null){
			application.setAttribute("onlineNum", 0);
		}else{
			int num = Integer.parseInt(application.getAttribute("onlineNum").toString());
			if(num > 0){
				application.setAttribute("onlineNum", num-1);
			}else{
				application.setAttribute("onlineNum", 0);
			}
			
		}
		System.out.println("上线---------------");
	}
		

	
	
}
