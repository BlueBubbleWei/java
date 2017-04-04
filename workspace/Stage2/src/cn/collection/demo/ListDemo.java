/**
 * 
 */
package cn.collection.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 韦玉梅
 */
public class ListDemo {
	/**
	* @param List支持增删改查
	* list集合的具体子类。子类之所以区分是因为内部的数据结构（存储数据的方式不同）
	* 	|--Vector:数据结构是数组，数组是可变长度的（不断new新数组并将元素复制到新数组当中。线程同步的，增删和查询都很慢
	* 	|--ArrayList：也是数组结构，也是长度可变的。线程不同步的，替代了Vector，增删速度不快。查询速度很快
	* 	|--LinkedList：链表结构，线程不同步的。增删速度很快查询速度较慢
	*/
	public static void main(String[] args) {
		List list=new ArrayList();
		methodDemo(list);
	}

	/**
	 * 
	 */
	private static void methodDemo(List list) {
//		1、常规添加元素
		list.add("123");		
		list.add("abcd");
//		2、插入元素
		list.add(1,"xyz");
		System.out.println(list);
//		删除
		list.remove(2);
		System.out.println(list);
//		获取
		System.out.println(list.get(1));
//		获取
		System.out.println(list.indexOf("123"));
//		修改
		list.set(1, "Bubble");
		System.out.println(list);
//		取出集合中的所有元素
		for(Iterator iterator=list.iterator();iterator.hasNext();){
			System.out.println("iterator:"+iterator.next());
		}
//		list集合特有的取出方式
		for(int i=0;i<list.size();i++){
			System.out.println("get:"+list.get(i));
		}
		
//		在遍历的过程中，如果遍历到一个123，添加一个元素Blue
		/*for(Iterator iterator=list.iterator();iterator.hasNext();){
			Object object=iterator.next();			
//			 java.util.ConcurrentModificationException:
//				 迭代过程中使用了集合对象同时对元素进行操作。导致了迭代的不确定性，引发了该异常。
//				 解决思想：在迭代过程中，想要执行一些操作，使用迭代器的方法就可以了				 
			if(object.equals("123"))
				list.add("Blue");
			System.out.println("list:"+list);
		}*/
		for(ListIterator iterator=list.listIterator();iterator.hasNext();){
			Object object=iterator.next();						 
			if(object.equals("123")) 
				list.add("Blue");
		}
		System.out.println("list:"+list);
	}
}
