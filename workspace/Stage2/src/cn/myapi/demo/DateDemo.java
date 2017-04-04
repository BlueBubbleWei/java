package cn.myapi.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateDemo {
	/**
	* @param args
	*/
	public static void main(String[] args)throws ParseException {
//		演示Date对象
		Date date=new Date();
//		System.out.println(date);
		
//		想要把日期按照我们的习惯格式化一下，找到了DateFormat
		DateFormat dateFormat =DateFormat.getDateInstance();
		
//		加入风格
		dateFormat=DateFormat.getDateInstance(DateFormat.FULL);// 由 2017-3-22 转为  2017年3月22日 星期三
		dateFormat=DateFormat.getDateInstance(DateFormat.LONG);// 由 2017-3-22 转为  2017年3月22日
		dateFormat=DateFormat.getDateInstance(DateFormat.MEDIUM);// 由 2017-3-22 转为 2017-3-22
		dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);// 由 2017-3-22 转为 17-3-22		
		dateFormat=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);// 由 2017-3-22 转为 2017年3月22日 星期三 上午11时45分41秒 CST
		
//		使用DateFormat的format方法对日期进行格式化,将日期对象转成日期格式的字符串
		String string=dateFormat.format(date);
		
//		System.out.println(string);
		
//		日期格式的字符串：2017-03-33
		String str_date="2017-03-22";
		DateFormat dateFormat2=DateFormat.getDateInstance();
		Date date2=dateFormat2.parse(str_date);
		System.out.println(date2);
		
		long time=System.currentTimeMillis();
		System.out.println(time);//1490155236256
		
		Date date3=new Date(time);
		System.out.println(date3);
		
		DateFormat dateFormat3=DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println(dateFormat3);
		
		String date_format=dateFormat3.format(date3);
		System.out.println(date_format);
		
//		日期对象转成毫秒值，Date的对象getTime()
		long time3=date.getTime();
		System.out.println(time3);
		
	}
}
