package cn.myapi.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarDemo2 {
	/**
	* @param 演示日历  Calendar 2016.5.22-2017.2.19
	* 1、只有毫秒可以相减
	* 2、获取毫秒值，字符串-->日起对象-->毫秒值
	 * @throws ParseException 
	*/
	public static void main(String[] args) throws ParseException{
		getDays();
	}
	
	public static void getDays() throws ParseException {
		String string_date1="2016/5/22";
		String string_date2="2017/2/19";
		
//		如何将日期格式字符串解析成日期对象呢？
//		DateFormat parse
//		自定义yyyy/MM/dd风格对象
		DateFormat dateFormat1=new SimpleDateFormat("yyyy/MM/dd");
		
//		2、定义一个默认的风格
		DateFormat dateFormat2=DateFormat.getDateInstance(DateFormat.MEDIUM);
		/*Date date=new Date();
		String str_date=dateFormat1.format(date);
		System.out.println(str_date);*/
		
//		对日期格式字符串进行解析
		Date date1=dateFormat1.parse(string_date1);	
		Date date2=dateFormat1.parse(string_date2);
		
//		通过日期对象获取毫秒值
		long time1=date1.getTime();
		long time2=date2.getTime();
		
//		相减
		long time=Math.abs(time1-time2);
		System.out.println(time);
		int day=transDay(time);
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(day);
	}

	
	private static int transDay(long time) {
		
		return (int)(time/1000/60/60/24);
	}
}
