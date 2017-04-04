package cn.myapi.demo;

import java.util.Arrays;
import java.util.List;

import javax.swing.SpringLayout.Constraints;

public class ArraysDemo {
	/**
	* @param args
	*/
	public static void main(String[] args) {
		int[] arr={32,67,1,79,97};
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
		
		String[] string={"add","sds","aadd"};
		boolean ans=myContains(string, "add");
		System.out.println(ans);
		
		/*
		发现集合中本身就有这个方法。contains()
		将数组转成集合，就行了
		用aslist就不用自己写myContains()
		*/
		List<String> list=Arrays.asList(string);		
//		list.add("ss");//java.lang.UnsupportedOperationException	注意：不能使用集合的增删方法。不能改变长度
		System.out.println(list.contains("add"));
		
	/*	
		如果数组中都是引用数据类型，转成集合是，数组元素直接作为集合元素
		如果数组中都是基本数据类型，会将数组对象作为集合中的元素
	*/	
		int[] arrs={37,56,23,17};
		List list2=Arrays.asList(arrs);
		System.out.println(list2.get(0));
	}

	
	public static boolean myContains(String[] arr,String key) {
		for (int i = 0; i < arr.length; i++) {
			String string=arr[i];
			if(string.equals(key))
				return true;
		}
		return false;
	}
	
	public static <T> void swap(T[] arr, int i, int j) {
		T temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
