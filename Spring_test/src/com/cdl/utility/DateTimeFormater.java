package com.cdl.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeFormater {
	public static String getCurrentDatetime(){
		Calendar c = Calendar.getInstance();
		DateFormat f = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String date = f.format(c.getTime());
		return date;
	}
	
	public static String getCurrentYear(){
		Calendar now = Calendar.getInstance();
		String year=String.valueOf(now.get(Calendar.YEAR));
		return year;
	}
}
