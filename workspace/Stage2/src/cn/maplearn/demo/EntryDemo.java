package cn.maplearn.demo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EntryDemo {
	/*
	练习：学生对象（姓名，年龄）都有对应的归属地
	
	key=Student value=String 
	*/
	public static void main(String[] args) {
//		将学生和归属存储到HashMap集合中并取出，同姓名同年龄视为同一个学生
//		Map<Employee, String> map=new HashMap<Employee, String> ();
//		自定义比较器
		Comparator<Employee> comparator=new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				int temp=o1.getName().compareTo(o2.getName());				
				return temp==0?o1.getAge()-o2.getAge():temp;
			}
			
		};
//		Map<Employee, String> map=new TreeMap<Employee, String> (comparator);//不传比较器就是按年龄排序
		Map<Employee, String> map=new LinkedHashMap<Employee, String> ();//如果改成LinkedHashMap可以实现有序
		map.put(new Employee("张三  ",25), "中国");
		map.put(new Employee("王五 ",5457), "北京");
		map.put(new Employee("李四  ",13), "乌克兰");//键不能保证唯一性了，需要修改hasCode()和equals()
		map.put(new Employee("李四  ",13), "上海");
		map.put(new Employee("赵六",13), "上海");
		
		Set<Map.Entry<Employee, String>> entrySet=map.entrySet(); 
		for (Map.Entry<Employee, String> employee : entrySet) {
			Employee keEmployee=employee.getKey();
			String value=employee.getValue();
			System.out.println(keEmployee.getName()+":"+keEmployee.getAge()+"....."+value);
		}
			
	}
}
