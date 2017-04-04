package cn.maplearn.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PracticeDemo {
	/*
	练习：学生对象（姓名，年龄）都有对应的归属地
	key=Student value=String 
	*/
	public static void main(String[] args) {
//		将学生和归属存储到HashMap集合中并取出，同姓名同年龄视为同一个学生
		Map<Employee, String> map=new HashMap<Employee, String> ();
		map.put(new Employee("张三  ",25), "中国");
//		map.put(new Employee("李四  ",13), "乌克兰");
		map.put(new Employee("王五 ",5457), "北京");
		map.put(new Employee("李四  ",13), "乌克兰");//键不能保证唯一性了，需要修改hasCode()和equals()
		map.put(new Employee("李四  ",13), "上海");
//		map.put(new Employee("李四  ",13), "广州");
		map.put(new Employee("赵六",13), "上海");
		
		Set<Employee> keySet=map.keySet(); 
		for (Employee employee : keySet) {
			String value=map.get(employee);
			System.out.println(employee.getName()+":"+employee.getAge()+"....."+value);
		}
		
		
				
		/*
		for (Employee employee : map.keySet()) {
			
		}
		*/	
}
}
