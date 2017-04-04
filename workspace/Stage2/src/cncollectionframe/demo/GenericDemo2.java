package cncollectionframe.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericDemo2 {
	
	public static void main(String[] args) {
//		创建一个list集合  存储一个整数 List ArrayList
		List<String> list=new ArrayList<String>();
		List<Integer> list1=new ArrayList<Integer>();
		list.add("fff");
		System.out.println(list);
		list1.add(555);
		System.out.println(list1);
		for (Iterator<Integer> iterator = list1.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
	}
}
