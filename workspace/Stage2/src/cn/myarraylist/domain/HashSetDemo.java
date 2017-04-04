package cn.myarraylist.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 韦玉梅
 *
 */
public class HashSetDemo {
	/**
	* @param
	* 
	*  
	*  技巧：
		jdk1.2以后出现的集合框架中的常用的子类对象，存在的规律
		前缀名是数据结构名，后缀名是所属体系名
		ArrayList:数组结构，看到数组，就知道查询快，看到list，就知道可以重复，可以增删改查
		LinkList:链表结构，增删块   xxxFirst   XXXLast  XXX：add getremove
		HashSet:哈希表，就要想到元素必须要覆盖hasCode()和equals() ,查询速度块，不保证有序，看到Set，就知道不可以重复
		LinkedListHashSet:链表+哈希表 可以实现有序，因为有链表
		TreeSet:二叉树，可以排序。就有两种比a较方式：一种是自然排序Comparable  一种是比较器Comparator
		
		
		
	*set集合：不允许重复的元素，和Collection的方法相同。Set集合取出方法只有一个：迭代器
	*	|--HashSet：哈希（散列）表结构，不保证顺序
	*	如何保证唯一性
	*	元素必须覆盖hashCode和equals方法
	*	覆盖hasCode方法是为了根据元素自身的特点确定哈希值
	*	覆盖equals方法，是为了解决哈希值的冲突
	*	|--TreeSet可以对元素进行排序
	*/
	public static void main(String[] args) {
//		创建一个set容器对象
		Set set=new HashSet();
		//添加元素
		set.add("abc1");
		set.add("abc2");
		set.add("abc3");
		set.add("abc4");
//		只能用迭代器取出
		for(Iterator iterator=set.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
		}
	}
}
