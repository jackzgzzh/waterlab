package com.waterlab.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTools {
	
	public static void main(String[] args) {
		System.out.println(DateTools.dataToWeek(new Date()));
	}
	
	public static String dataToWeek(String datetime){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		Date date = null;
		
		try {
			date = f.parse(datetime);
			cal.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(w < 0){
			w = 0;
		}
		
		return weekDays[w];
	}
	
	public static String dataToWeek(Date date){
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(w < 0){
			w = 0;
		}
		
		return weekDays[w];
		
	}
	
}
