package cn.maplearn.demo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class practiceDemo4 {
	/**
	* @param 作业：“dfifdkgkdfkgk”
	* 获取字符串中第一个字母出现的次数，要求结果格式:a(2)b(1)d(3)
	* 思路：
	* 1、获取到字母
	* 2、如何获取到字母次数？比较
	* 发现字母和次数有对应关系，而且对应关系的一方具备唯一性
	* 就想到了Map集合。Map集合就是一张表
	* 
	* 3、使用查表法就可以了。
	* 	先查第一个字母在表中出现的次数，如果次数不存在，说明是第一次出现，将该字母和1存储到表中
	* 	以此类推，当要查的次数存在，将次数取出并自增后，再和对应的字母存储到表中，mam表的特点是相同键，值覆盖
	* 4、查完每一个字符后，表中存储的就是每一个字幕出现的次数
	*/
	public static void main(String[] args) {
		String string="dfifdkgk--dfk++gk";
		String count=getCharCount(string);
		 System.out.println(count);
	}

	/**
	 * @param string
	 * @return
	 */
	private static String getCharCount(String string) {
//		将字符串转换成字符数组
		char[] chs=string.toCharArray();
//		定义map集合表
		Map<Character, Integer> map=new TreeMap<Character,Integer>();
//		遍历字符数组，获取每一个字母
		for (int i = 0; i < chs.length; i++) {
//			只对字母操作
			if(!(chs[i]>='a' && chs[i]<='z' || chs[i]>='A'&& chs[i]<='Z'))
				continue;
//			将遍历到的字母作为键去查表，获取值
			Integer value=map.get(chs[i]);
			
			/*if(value==null){
				map.put(chs[i], 1);
			}else {
				value++;
				map.put(chs[i], value);
			}*/
			
//			方式二
			int count=0;//用于记录次数
//			如果次数存在，就用count记录该次数，如果次数不存在，就不记录，只对count自增变成1
			if(value!=null){
				count=value;
			}
			count++;
			map.put(chs[i], 1);			
		}
//		System.out.println(map);
		return toString(map);
	}
	
//	将map集合中的元素转成指定格式的字符串 a(2) b(1) d(3)
	private static String toString(Map<Character, Integer> map) {
//		1、数据多，无论类型是什么，最终都要变成字符串，所以可以使用StringBuilder
		StringBuilder stringBuilder=new StringBuilder();
//		遍历集合map  keySet
		Set<Character> keySet=map.keySet();
		for (Iterator <Character> iterator = keySet.iterator(); iterator.hasNext();) {
			Character key = iterator.next();
			Integer value=map.get(key);
			stringBuilder.append(key+"("+value+")");
		}
		return stringBuilder.toString();
	}
}
