/**
 * 
 */
package cn.collection.demo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 韦玉梅  2017/3/14
 */
public class CollectionDemo {
	/**
	* @param 
	* 集合类
	* 为什么出现集合类？
	* 面向对象语言体现的都是以对象的形式，所以为了方便对多个对象的操作，就对对象进行存储，集合就是存储对象最常用的一种方式
	* 数组和集合类同是容器，有何不同？
	* 1、数组虽然也可以存储对象，但长度是固定的，集合长度是可变的。
	* 2、数组可以存储基本数据类型，集合只能存储对象
	* 集合类的特点？
	* 集合只用于存储对象，集合长度是可变的，集合可以存储不同类型的对象
	* 
	* 因为容器中数据结构不同，容器有很多种，不断地共性功能抽取，形成了集合体系--->集合框架顶层就成为Cellection接口
	* 
	* collection接口中的共性功能
	* 1、添加
	*   boolean add(Object o)
	* 	boolean addAll(Collection c):将制定容器中的所有元素添加
	* 2、删除
	* 	void clear();
	* 	boolean remove(object o)
	* 	boolean removeAll(Collection c);
	* 3、获取长度
	* int size()
	* 4、判断
	* 	boolean isEmpty();
	* 	boolean contains(Object o)
	* 	boolean containsAll(Collection c)
	* 5、将集合转数组
	* 	toArray();
	* 	toArray([]);
	* 6、取出集合元素
	* Interrator iterator
	* 获取集合中元素上迭代功能的迭代器对象
	* 迭代：取出元素的一种方式
	* 迭代器：具备着迭代功能的对象
	* 而迭代对象不需要new  直接通过iterator方法获得
	* 迭代器是取出Collection集合中 元素的公共方法
	* 
	* Collection
	* 			|--list(存入的人顺序和取出的顺序一致，)有索引，允许重复元素
	* 			|--set(不允许重复元素)
	* 重点讲list接口中的特有方法：他的特有方法都是围绕索引定义的
	* 支持增删改查
	* 増：add(index,element)
	* 删：remove(index);
	* 改：set(index,new_element);
	* 查：indexOf(element);
	* element get(index);
	*/
	public static void main(String[] args) {
//		演示collection中的基本功能
//		ArrayList<String> collection =new ArrayList<String>();
		Collection collection  =new ArrayList();
		methodDemo(collection);
	}

	/**
	 * 
	 */
	public static void methodDemo(Collection collection) {
		collection.add("123");
		collection.add("abd");
		collection.add("12sdd");
		System.out.println(collection+"\t"+collection.size());
		collection.remove("12sdd");
		System.out.println(collection+"\t"+collection.size());
		collection.clear();
		System.out.println(collection+"\t"+collection.size());
	}
}
