package cn.myarraylist.domain;

import java.util.Comparator;

public class ComparatorByName implements Comparator {
	/**
	* @param 自定义一个比较器，用来对学生对象按照姓名进行排序
	*/
	public int compare(Object o1,Object o2) {
		Student s1=(Student)o1;
		Student s2=(Student)o2;
		
		int temp=s1.getName().compareTo(s2.getName());
		return temp==0?s1.getAge()-s2.getAge():temp;
	}
}
