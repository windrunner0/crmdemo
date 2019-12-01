package com.zp.crm.ssm.util;

import java.util.Calendar;

public class Util {

	public boolean a(String str){
		Calendar c = Calendar.getInstance();
		long now = c.getTimeInMillis();
//		c.setTime(rs.getDate(2));
		long lastly = c.getTimeInMillis();
		return (now - lastly) >= 600000;}
}
