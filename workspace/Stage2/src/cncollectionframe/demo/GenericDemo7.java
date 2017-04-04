package cncollectionframe.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GenericDemo7 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("sdsd");
		list.add("sdsddd");
		list.add("123");
//		printCollection(list);
		
		Set<String> set=new HashSet<String>();
		set.add("sdsd");
		set.add("sdsddd");
		set.add("123");
//		printCollection(set);
		
		List<Student> list2=new ArrayList<Student>();
		list2.add(new Student("sdsd",24));
		list2.add(new Student("sdsddd",12));
		list2.add(new Student("123",56));
		printCollection(list2);
		
		
		Set<Worker> set2=new HashSet<Worker>();
		set2.add(new Worker("sdsd",24));
		set2.add(new Worker("sdsddd",12));
		set2.add(new Worker("123",56));
		printCollection(set2);
	}

	/**
	 * @param 用于 list 和 set
	 */
	/*private static void printCollection(Collection<String> collection) {
		for (Iterator<String> iterator = collection.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
			
		}
	}*/
	
	/**
	 * @param 用于 list 和 set 和list2
	 */
	/*private static void printCollection(Collection<?> collection) {//在不明确类型的情况下，可以用通配符表示
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext();) {
			Object object = iterator.next();
			System.out.println(object);
			
		}
	}*/
	
	/**
	 * @param 用于 list2 和set2
	 * 泛型的限定
	 * 	? extends E:接受E类型或者E的子类型   ？extends Person:泛型上限
	 * ? super E :接受E类型或者是E的父类型    ？super Student：泛型的下限（下面被限制住）
	 */
	private static void printCollection(Collection<? extends Person> collection) {
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext();) {
			Object object = iterator.next();
			System.out.println(object);
			
		}
	}
}
