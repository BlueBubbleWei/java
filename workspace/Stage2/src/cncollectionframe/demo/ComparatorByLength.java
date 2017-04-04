package cncollectionframe.demo;

import java.util.Comparator;

public class ComparatorByLength implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
//		对字符串按照长度比较
		String string1=(String)o1;
		String string2=(String)o2;
//		比较长度
		int temp = string1.length()-string2.length();
//		长度相同，再按字典排序
		return temp==0?string1.compareTo(string2):temp;
	}
	
}
