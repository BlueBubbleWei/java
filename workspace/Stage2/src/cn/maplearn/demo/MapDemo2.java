package cn.maplearn.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.metal.MetalSplitPaneUI;

public class MapDemo2 {
	/*
	 * 取出map 中所有元素 map 存储姓名-----归属地
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("df", "张三");
		map.put("as", "李四");
		map.put("gas", "李四");
		System.out.println(map.get("df"));

		// keySet,取出所有的键，并存储到set集合中.map集合没有迭代器，但是可以将map集合转成set集合，再使用迭代器就解决了
		Set<String> keySet = map.keySet();
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String key = iterator.next();
			String value=map.get(key);
			System.out.println(key+":"+value);
		}
/*		
//		演示entrySet  Map.Entry其实就是一个Map接口中内部接口
		Set<Map.Entry<String,String>> entrySet=map.entrySet();
		for (Iterator<Map.Entry<String,String>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Map.Entry<String, String> entry = iterator.next();
			String key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+":"+value);			
		}
*/		
//		演示values()所有的值
		Collection<String> values=map.values();
		for (Iterator<String> iterator = values.iterator(); iterator.hasNext();) {
			String value = iterator.next();
			System.out.println(value);
			
		}
	}
}

interface MyMap{
//	entry就是,map接口中的内部接口
	public static interface MyEntry{
		
	}
}

class MyDemo implements MyMap.MyEntry{
	
}
