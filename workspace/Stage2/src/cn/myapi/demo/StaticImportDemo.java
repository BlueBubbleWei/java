package cn.myapi.demo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.*;
import java.util.*;
import static java.lang.System.*;

public class StaticImportDemo {
	
	public static void main(String[] args) {
	/*	
		List list=new ArrayList();
		Collections.sort(list);
		Collections.max(list);
		System.out.println(Collections.max(list));
	*/
		List<String> list=new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("123");
		sort(list);
		
		System.out.println(max(list));
		out.println("Hello");
	}

	/**
	 * @param list
	 * @return
	 *//*
	private static char[] max(List<String> list) {
		return null;
	}

	*//**
	 * @param list
	 *//*
	private static void sort(List<String> list) {
	}*/
}
