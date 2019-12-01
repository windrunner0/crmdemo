package com.zp.crm.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

	public boolean a(String str) throws ParseException{
		Calendar c = Calendar.getInstance();
		long now = c.getTimeInMillis();
//		SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");//设置日期格式
		java.util.Date d = sdf.parse(str);//注意这里转换的是java.util.Date mysql，数据库也提供了一个自身的date模式，千万不能混淆
		long lastly = d.getTime();
		return (now - lastly) >= 600000;
	}
	
}
