package cncollectionframe.demo;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StringDemo_1 {
	/**
	* @param对多个字符串（不重复）按照长度排序（由长到短）
	*/
	public static void main(String[] args) {
//		sortStringByLength();
		sortStringByLength2();
	}
	public static void sortStringByLength() {
		Set set= new TreeSet(new ComparatorByLength());//自妇产按长度排序的方式
		set.add("sdsu");
		set.add("abcd");
		set.add("DFFFFFF");
		set.add("ADEF");
		for(Object object:set){
			System.out.println(object);
		}
	}
	
//	对多个字符串（重复），按照长度排序
	public static void sortStringByLength2() {
		String[] strings={"sdfsdf","sdfdfsf","acsddsd"};
		/*
		自然排序可以使用String类中的compareTp方法
		但是现在要的是长度排序，这就需要比较器
		*/
		Comparator comparator= new ComparatorByLength();

//		排序需要嵌套循环。位置置换
		for(int x=0,end=strings.length;x<end;x++){
			for(int y=x+1;y<strings.length;y++){
				if (comparator.compare(strings[x],strings[y])>0) {//按照长度排序
					swap(strings,x,y);
				}	
			}
		}
		/*
//		排序需要嵌套循环。位置置换
		for(int x=0,end=strings.length;x<end;x++){
			for(int y=x+1;y<strings.length;y++){
				if (strings[x].compareTo(strings[y])>0) {//按照字典排序
					swap(strings,x,y);
				}	
			}
		}
		*/
		for(String s:strings){
			System.out.println(s);			
		}
				
	}
	/**
	 * @param strings
	 * @param x
	 * @param y
	 */
	private static void swap(String[] strings, int x, int y) {
		String temp=strings[x];
		strings[x]=strings[y];
		strings[y]=temp;
	}
}


