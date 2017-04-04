package cn.maplearn.demo;

import java.util.HashMap;
import java.util.Map;

public class PracticeDemo3 {
	/*	
	什么时候使用map集合呢？
	当需求中出现映射关系时，应最先想到的map集合
	
	根据用户的制定数据获取对应的星期
*/
	public static void main(String[] args) {
		String cnWeek=getCnWeek(3);
		System.out.println(cnWeek);
		String enWeek =getEnWeek(cnWeek);
		System.out.println(enWeek);
	}
	
	public static String getCnWeek(int num) {
		if(num<=0 || num>7){
			throw new NoWeekException(num+"没有对应的星期");
		}
		String[] cnWeeks={"","星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
		return cnWeeks[num];
	}
	
//	根据中文的星期获取对应的英文星期？
	public static String getEnWeek(String cnWeek) {
//		创建一个表
		Map<String, String> map=new HashMap<String,String>();
		map.put("星期一", "Monday");
		map.put("星期二", "Tuesday");
		map.put("星期三", "Wednesday");
		map.put("星期四", "Thursday");
		map.put("星期五", "Friday");
		map.put("星期六", "Saturday");
		map.put("星期天", "Sunday");
		
		return map.get(cnWeek);
	}
}
