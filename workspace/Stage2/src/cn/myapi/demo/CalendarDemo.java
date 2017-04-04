package cn.myapi.demo;

import java.util.Calendar;

public class CalendarDemo {
	/**
	* @param 演示日历 Calendar
	*/
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		System.out.println(calendar);
		System.out.println("------------------------------");
		calendar.set(Calendar.YEAR, 2016);
		calendar.set(2016, 5, 22);
		
//		日期的偏移
		calendar.add(Calendar.YEAR, -4);
		calendar.add(Calendar.MONTH, 5);
		
//		任意一年而又有多少天，三月一日的前一天就是
		int year=2012;
		calendar.set(year,3,1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		showDate(calendar);
	}
	
	private static void showDate(Calendar calendar) {		
//		获取其中所需日期
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH);
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		
		String week=getWeek(calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println(week);
		
		System.out.println(year+"年"+month+"月"+day+"日"+week);
	}
	
	private static String getWeek(int i) {
		String[] week={"","星期一","星期二","星期三","星期四","星期五","星期六","星期天",};
		if(i>7 || i<=0){
			throw new NotWeekException("没有对应的星期1-7");//此异常必须继承RunableException
		}
		return week[i];
	}
}
