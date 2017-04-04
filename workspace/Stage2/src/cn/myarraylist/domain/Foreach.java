package cn.myarraylist.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author john5
 *
 *JJDK1.5特性
 *增强for循环，作用：用于遍历collection集合或 数组
 *格式：for(元素类型 变量:Collection容器or数组)
 *{
 *}
 *传统for循环和增强for循环有什么区别？
 *增强for必须有被遍历的目标，该目标只能是Collection数组
 */
public class Foreach {
	/**
	* @param args
	*/
	public static void main(String[] args) {
		Collection collection =new ArrayList();
		collection.add("abc1");
		collection.add("abc2");
		collection.add("abc3");
		collection.add("abc4");
		/*
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		*/
//		使用foreach的简洁写法
		for(Object object :collection){
			System.out.println(object);
		}
		
//		对于数组的遍历，如果不操作其角标，可以使用增强for;如果要操作角标，使用传统for
		int[] arr={23,15,32,78};
		for(int x:arr){
			System.out.println("x="+x);
		}
				
	}
}
