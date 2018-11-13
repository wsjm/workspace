package com.keduo.controller;
import java.util.Calendar;

public class a {
	// 获取当前是星期几
	public static String getDayOfWeek() {
		Calendar cl = Calendar.getInstance();
		int num = cl.get(Calendar.DAY_OF_WEEK);
		if (num == 1)
			return "星期天";
		if (num == 2)
			return "星期一";
		if (num == 3)
			return "星期二";
		if (num == 4)
			return "星期三";
		if (num == 5)
			return "星期四";
		if (num == 6)
			return "星期五";
		if (num == 7)
			return "星期六";
		return null;
	}

	// 获取xxxx年xx月xx日
	public static String getDate() {
		Calendar cl = Calendar.getInstance();
		int year = cl.get(Calendar.YEAR);
		int month = cl.get(Calendar.MONTH);
		int day = cl.get(Calendar.DAY_OF_MONTH);
		
		return year + "年" + month + "月" + day + "日";
	}
	//获取XX时XX分XX秒
	public static String getTime() {
		Calendar cl = Calendar.getInstance();
		int hour = cl.get(Calendar.HOUR_OF_DAY);
		int minute = cl.get(Calendar.MINUTE);
		int second = cl.get(Calendar.SECOND);
		return hour + ":" + minute + ":" + second;
	}
}