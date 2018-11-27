package com.jd.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timerhelp {

	public static String getTime(){
		double random = Math.random();
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmssms");
		return s.format(date);
	}
	
}
