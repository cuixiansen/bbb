package com.jd.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class LoginUserListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		ServletContext application = event.getSession().getServletContext();
		Object obj = application.getAttribute("loginNum");
		if(obj == null){
			application.setAttribute("loginNum", 1);
			
		}else{
			application.setAttribute("loginNum", (Integer.valueOf(obj.toString())+1));
			
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
		ServletContext application = event.getSession().getServletContext();
		Object obj = application.getAttribute("loginNum");
		int num = Integer.parseInt(obj.toString());
		if(num > 0){
			application.setAttribute("loginNum", (num-1) );
			
		}else{
			application.setAttribute("loginNum", 0);
			
		}
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

}
