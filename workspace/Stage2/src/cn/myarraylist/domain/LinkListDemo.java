package cn.myarraylist.domain;

import java.util.LinkedList;

/**
 * @author 韦玉梅
 *
 */
public class LinkListDemo {
	/**
	* @param args
	*/
	public static void main(String[] args) {
//		创建一个链表对象
		LinkedList list=new LinkedList();
		
//		添加方法
		list.addFirst("123");
		list.addFirst("abc");
		list.add("dufrdhf");
		list.addFirst("sdf");
		
		
//		获取元素
		System.out.println(list.getFirst());
		System.out.println(list.getFirst());
		
//		删除元素
		System.out.println(list.removeFirst());
		
//		取出list中的所有元素
		while (!list.isEmpty()) {
			System.out.println(list.removeLast());
			
		}
	}	 
}
