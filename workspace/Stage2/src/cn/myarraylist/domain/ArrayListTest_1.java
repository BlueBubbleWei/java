package cn.myarraylist.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 韦玉梅
 *
 */
public class ArrayListTest_1 {
	/**
	* @param 定义功能，请除去ArraList集合中的重复元素
	*/
	public static void main(String[] args) {
		List list= new ArrayList();
		list.add("htfgvc");
		list.add("abc");
		list.add("123");
		list.add("abc");
		System.out.println(list);
		
		System.out.println("----------------");
		SingleElement(list);
		
		System.out.println("----------------");
		SinglElement2(list);
		
		
	}

	

	/**
	 * @param 删除重复元素
	 */
	private static void SingleElement(List list) {
		for(int x=0;x<list.size()-1;x++){
			Object object= list.get(x);
			for(int y=x+1;y<list.size();y++){
				if(object.equals(list.get(y)))
					list.remove(y);
			}
		}
		System.out.println(list);
	}
	/*
	去除重复元素方式二
	思路：
	1、最后唯一性的元素很多，可以先定义一个容器用于存储这些唯一性的元素
	2、对原有容器进行元素的获取，并到临时容器中去判断是否存在，容器本身就有这个功能，判断元素是否存在
	3、存在就不存储，不存在就存储
	4.遍历完原容器，临时容器中存储的就是唯一元素了
	*/
	/**
	 * @param 删除元素2
	 * @return
	 */
	private static void SinglElement2(List list) {
		//定义一个 临时容器
		List temp =new ArrayList();
		//遍历原容器
		for(Iterator iterator=list.iterator();iterator.hasNext();){
			Object object=(Object)iterator.next();
			//在临时容器中判断遍历元素是否存在
			if(!temp.contains(object))
//				如果不存在，就存储到临时容器中
				temp.add(object);
		}
		System.out.println(temp);
	}
	/*
	public boolean equals(Object object) {
//		判断是否相同
		if(this==object)
			return true;
		System.out.println(this+"........."+object);
		if(!(object instanceof Person)){
			throw new ClassCastException("类型错误");
		}
		Person person =(Person)object;
		return this.name.equals(person.name) && this.age==person.age;
	} */
	
}
