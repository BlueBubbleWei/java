package cn.maplearn.demo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	/*
	Map:双列集合，一次存一对，键值对。要保证键的唯一性
	共性的功能：
		1、添加
		
		v put(key,value);
		putAll(Map<k,v> map);
		
		2、删除
		
		void clear();
		v remove(key);
		
		3、判断
		
		boolean containsKey(object);
		boolean containsValue(object);
		boolean isEmpty();
		
		4、获取
		
		v get(key);
		int size();
		
		Map
			|--Hashtable:哈希表，是同步的。不允许null键，null值
			|--HashMap:哈希表，是不同步的，不允许null键，null值
			|--TreeMap：二叉树，不同步的。可以对map集合中的键进行排序
		
		*/
	public static void main(String[] args) {
		Map <Integer,String> map=new HashMap<Integer,String>();
		methodDemo(map);
//		需求：map 集合中存储学号和姓名
	}
	
	public static void methodDemo(Map<Integer,String> map) {
//		存储键值对。如果键相同，会出现值覆盖
		System.out.println(map.put(1, "张三"));
		System.out.println(map.put(1, "二虎"));
		map.put(3, "张三");
		map.put(4, "李四");
		System.out.println(map);
		System.out.println(map.remove(1));
		System.out.println(map);
	}
}
