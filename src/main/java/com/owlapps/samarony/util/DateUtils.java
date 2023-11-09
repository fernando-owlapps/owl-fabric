package com.owlapps.samarony.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
	
//	private static String FORMAT_DD_MM_YYYY_HH_MM_SS_A = "dd-MM-yyyy hh:mm:ss a";
	private static String FORMAT_DD_MM_YYYY_K_MM_SS = "dd-MM-yyyy k:mm:ss";
	private static String FORMAT_DD_MM = "dd-MM-yyyy";
	
	
	public static Date strToDate(String dateStr) {
		
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_DD_MM);
		format.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		
		Date date = null;
		
		try {
			
			date = format.parse(dateStr);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static String dateToStr(Date date) {
		
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_DD_MM);
		format.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		String dateStr = "";
		
		dateStr = format.format(date);
		
		return dateStr;
	}
	
	public static String dateToStrLastAccess(Date date) {
		
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_DD_MM_YYYY_K_MM_SS);
		format.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		String dateStr = "";
		
		dateStr = format.format(date);
		
		return dateStr;
	}
	
	public static Date millisToDate(Long millis) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		
		Date date = calendar.getTime();
		
		return date;
	}
	
	public static String millisToDateStr(Long millis) {
		
		return dateToStr(millisToDate(millis));
	}
	
	public static int dateToHour(Date date) {
		
		return date.getHours();
	}
	
	public static Date setHourToDate(int hour) {
		
		Date date = new Date();
		date.setHours(hour);
		
		return date;
	}
	
	public static String dateTOdayName(Date date){
//        Date date = null;
//        String format = "YYYY-MM-DD";
//        
//        try {
//            date = new SimpleDateFormat(format).parse(inputDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
    }

}
