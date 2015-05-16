// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DateUtil.java

package com.neusoft.platform.syscontext.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Referenced classes of package com.goldcow.platform.syscontext.util:
//			StringUtil

public class DateUtil
{

	public static final SimpleDateFormat DATE_TIME_F = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat DATE_TIME_HM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat DATE_F = new SimpleDateFormat("yyyy-MM-dd");
	private static final int DATE_OFFSET = 10;

	private DateUtil()
	{
	}

	public static Date utilDate2SqlDate(java.util.Date date)
	{
		return new Date(date.getTime());
	}

	public static java.util.Date sqlDate2UtilDate(Date date)
	{
		return new java.util.Date(date.getTime());
	}

	public static String date2String(java.util.Date currentDate, String formate)
	{
		String result = null;
		SimpleDateFormat formatdater = new SimpleDateFormat(formate);
		result = formatdater.format(currentDate);
		return result;
	}

	public static java.util.Date string2Date(String currentDate, String formate)
		throws ParseException
	{
		java.util.Date result = null;
		SimpleDateFormat formatdater = new SimpleDateFormat(formate);
		result = formatdater.parse(currentDate);
		return result;
	}

	public static java.util.Date changeDay(java.util.Date date, int offset)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(6, calendar.get(6) + offset);
		return calendar.getTime();
	}

	public static String changeDay(java.util.Date date, int offset, String formate)
	{
		SimpleDateFormat formatdater = new SimpleDateFormat(formate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(6, calendar.get(6) + offset);
		return formatdater.format(calendar.getTime());
	}

	public static String changeDay(String date, int offset, String formate)
		throws ParseException
	{
		SimpleDateFormat formatdater = new SimpleDateFormat(formate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(formatdater.parse(date));
		calendar.set(6, calendar.get(6) + offset);
		return formatdater.format(calendar.getTime());
	}

	public static java.util.Date changeHour(java.util.Date datetime, int offset)
		throws ParseException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datetime);
		calendar.add(10, offset);
		return calendar.getTime();
	}

	public static String changeHour(String datetime, int offset)
		throws ParseException
	{
		SimpleDateFormat formatdater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(formatdater.parse(datetime));
		calendar.add(10, offset);
		return formatdater.format(calendar.getTime());
	}

	public static String changeMinute(String datetime, int offset)
		throws ParseException
	{
		SimpleDateFormat formatdater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(formatdater.parse(datetime));
		calendar.add(12, offset);
		return formatdater.format(calendar.getTime());
	}

	public static java.util.Date changeMinute(java.util.Date datetime, int offset)
		throws ParseException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datetime);
		calendar.add(12, offset);
		return calendar.getTime();
	}

	public static String changeSecond(String datetime, int offset)
		throws ParseException
	{
		SimpleDateFormat formatdater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(formatdater.parse(datetime));
		calendar.add(13, offset);
		return formatdater.format(calendar.getTime());
	}

	public static java.util.Date changeSecond(java.util.Date datetime, int offset)
		throws ParseException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datetime);
		calendar.add(13, offset);
		return calendar.getTime();
	}

	public static String getBeginDate(String beginDate)
		throws ParseException
	{
		String result = null;
		if (!StringUtil.isBlank(beginDate))
			result = (new StringBuilder(String.valueOf(beginDate))).append(" 00:00:00").toString();
		return result;
	}

	public static String getEndDate(String endDate)
		throws ParseException
	{
		String result = null;
		if (!StringUtil.isBlank(endDate))
			result = (new StringBuilder(String.valueOf(endDate))).append(" 23:59:59").toString();
		return result;
	}

	public static String dateString2NormalDateString(String datetime)
		throws ParseException
	{
		String result = null;
		if (!StringUtil.isBlank(datetime))
			result = datetime.substring(0, 10);
		return result;
	}

	public static String dateTime2NormalDateString(java.util.Date date)
		throws ParseException
	{
		String result = null;
		String datetime = date2String(date, "yyyy-MM-dd");
		if (!StringUtil.isBlank(datetime))
			result = datetime.substring(0, 10);
		return result;
	}

	public static String dateTime2DefaultStr(java.util.Date date)
	{
		String str = "";
		if (date != null)
			str = date2String(date, "yyyy-MM-dd HH:mm:ss");
		return str;
	}

	public static String getWeekdayChineseStrByDate(java.util.Date date)
	{
		if (date == null)
			return null;
		else
			return (new SimpleDateFormat("E")).format(date);
	}

	private static boolean isLeapyear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	public static int getLastdayByMonth(int year, int month)
	{
		int day = 31;
		if (month == 4 || month == 6 || month == 9 || month == 11)
			day = 30;
		if (month == 2)
		{
			day = 28;
			if (isLeapyear(year))
				day = 29;
		}
		return day;
	}

	public static int getLastdayByMonth(java.util.Date date)
	{
		int year = Integer.valueOf(date2String(date, "yyyy")).intValue();
		int month = Integer.valueOf(date2String(date, "MM")).intValue();
		int day = 31;
		if (month == 4 || month == 6 || month == 9 || month == 11)
			day = 30;
		if (month == 2)
		{
			day = 28;
			if (isLeapyear(year))
				day = 29;
		}
		return day;
	}

}
