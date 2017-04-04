package cn.myarraylist.domain;

import java.util.LinkedList;

/**
 * @author 韦玉梅
 */
public class LinkListDemo2 {
	/**
	* @param 练习
	* 请通过LinkList实现一个堆栈，或者队列数据结构
	* 堆栈：先进先出
	* 队列：先进后出
	*/
	public static void main(String[] args) {
//		 创建自定义的队列对象
		MyQueue queue =new MyQueue();
//		添加元素
		queue.myAdd("abc1");
		queue.myAdd("abc2");
		queue.myAdd("abc3");
		queue.myAdd("abc4");
		
//		获取所有元素，先进先出	
		while (!queue.isNull()) {
			System.out.println(queue.myGet());
			
		}
	}
}
class MyQueue{
	private LinkedList linkedList;

	public MyQueue() {
		linkedList=new LinkedList();
	}

	public void myAdd(Object object) {
//		内部使用的是linkList的方法
		linkedList.addFirst(object);
	}
	
	public Object myGet() {
		return linkedList.removeFirst();
	}
	
//	集合中是否有元素的方法
	public boolean isNull() {
		return linkedList.isEmpty();
	}
	
	
}
