package cn.myapi.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class CollectionDemo1 {
	/**
	* @param 集合框架的工具类
	* Collections:定义的都是操作Collections的静态方法
	* 1、对list排序
	* 	sort(list);
	* 
	* public static<T extends Comparable<? super T>> void sort(List<T> list) {//泛型方法
		
	}
	
	class Student implements Comparable<Student>{
		public static void sort(List<Student> list) {
			
		}
		@Override
		public int compareTo(Student o) {
			return 0;
		}
	}
	
	2、逆序：reverseOrder
	3、max min
	4、二分查找
	5、将非同步集合转成同步集合
	
	
	Arrays：用来操作数组的操作类
	*/
	public static void main(String[] args) {
		methodDemo1();
	}

	/**
	 * 
	 */
	private static void methodDemo1() {
		List<String> list=new ArrayList<String>();
		list.add("absdc");
		list.add("12x3");
		list.add("adefdc");
		
//		对List排序，自然排序。使用的是元素的compareTo()
		Collections.sort(list);
		
//		按长度排序
//		Collections.sort(list,new ComparatorByLength());//长度排序
		
		Collections.sort(list,Collections.reverseOrder(new ComparatorByLength()));//reverseOrder强行逆转比较器的功能
		System.out.println(list);
		
		
		System.out.println("----------------------------");
		Collection<String> collection=new ArrayList<String>();
		collection.add("fffff");
		collection.add("ggggg");
		collection.add("tttt");
		String max=getMax(collection);
		System.out.println(max);
		
		String max1=Collections.max(collection,new ComparatorByLength());
		System.out.println(max1+"\t"+"max1");
		
	/*	
		Collections中有一个可以将非同步集合转为同步集合的方法
		同步synchronize集合(非同步集合);
	*/	
	}
	
//	模拟一个获取集合最大值的功能
	public static<T extends Object &Comparable<? super T>> T getMax(Collection<? extends T> collection) {
		Iterator<? extends T> iterator=collection.iterator();
		T max=iterator.next();
		while(iterator.hasNext()){
			T temp=iterator.next();
			if(temp.compareTo(max)>0){
				max=temp;
			}
		}
		return max;
	}
	/*
	public static String getMax(Collection<String> collection) {
//		1、定义变量记录容器中其中一个
//		2、遍历容器所有的元素
//		3、在遍历过程中进行比较。只要比变量的中的值大。用变量记录下来，就行
		Iterator<String> iterator=collection.iterator();
		String max=iterator.next();
		while(iterator.hasNext()){
			String temp=iterator.next();
			if(temp.compareTo(max)>0){
				max=temp;
			}
		}
		return max;
	}
	*/
	
}


