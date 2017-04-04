package cn.bubble.demo;

import java.util.Arrays;

public class HelloDemo {
	/*
	 * @params 
	 * */
	public static void main(String[] args) {
	/*
	 * 查阅apu发现类构造函数可以将字节数组，或者字符数组构造成字符串对象
	字符串
	字符串是一个特殊的对象
	字符串一旦被初始化就不可以被改变
	字符串是一个常量，一旦初始化就不会被改变
	string也可以new
	string str= new String("abc");
	*/
		String string="abcd";
		String str= new String("abcd");
		System.out.println(string);
		System.out.println(str);
		System.out.println(str==string);
		System.out.println(str.equals(string));//字符串的equals覆盖了Object类比较的是字符串的内容是否相同
	/*
		问str和string的区别
		string在内存中只有一个对象
		str在内存中有两个对象
	*/
		System.out.println("-----------------");
		
		
		String str1= new String("abc");
		String str2= new String("abc");		
		System.out.println(str1==str2);		
		
		char ch=str1.charAt(2);//查找字符串第二个字符
		System.out.println(ch);
		
		int index=str1.indexOf('a');//查找元素第一次出现的位置
		System.out.println(index+"\t"+"=index");
		
		/*字符串可以比较大小吗？谁大谁小都是通过方法完成的
		对象比较相同：Object equals(Object obj):子类一般情况下都会复写，建立自己判断相同的依据*/
		int num ="abc".compareTo("bcd");
		System.out.println(num+"=num");
		
		String[] arr={"aa","bb","gthgt","sfdfgrdg"};
		printArry(arr);
		//对字符串数组排序
		sort(arr);
		printArry(arr);
		
		/*需求3：子串在整串中出现的次数，"gbuorlgtojrhg'prefreoj hgres"
		 思路： 需要一个计数器    寻找n次*/
		System.out.println("--------------------");
		String str3="gbuorlgtojrhg'prefreoj hgres";
		int count=0;
		count=getKeyCount(str3,"g");
		System.out.println("count="+count);
		
		/*
		需求4：两个字符串的最大相同子串
		"fgrgh;ggkghtlrgnlgkdgrthytjytgk"
		"gk"
		思路：以短的字符串为主     
		到长的字符串中去判断是否存在，如果存在，已找到
		如果没有找到，将短的
		*/
		System.out.println("--------------------");
		String string2="fgrgh;ggkghtlrgnlgkdgrthytjytgk";
		String string3="gk";
		String maxSub=getMaxSubString(string2, string3);
		System.out.println("maxSub="+maxSub);
		
		/*
		字符串排序
		*/
		System.out.println("--------------------");
		String string4="dsfdnvfdolvn";
		String sortString=sortChar(string4);
		System.out.println("sortString"+"\t"+sortString);
	}

	/**
	 * 
	 */
	public static String sortChar(String string) {
//		将字符串转成数组
		char[] chs=stringToArry(string);
		//对数组排序
		sortArray(chs);
		//将数组转成字符串
		return toString(chs);
	}

	/**
	 * @param chs
	 * @return
	 */
	private static String toString(char[] chs) {
		return new String(chs);
	}

	/**
	 * @param chs
	 */
	private static void sortArray(char[] chs) {
		Arrays.sort(chs);
	}

	/**
	 * @param string
	 * @return
	 */
	private static char[] stringToArry(String string) {
		return string.toCharArray();
	}

	/**
	 * 查找指定字符出现的次数
	 */
	public static String getMaxSubString(String s1,String s2) {
		//确定哪个是长的哪个是短的
		String longStr,shortStr;
		longStr=s1.length()>s2.length()?s1:s2;
		shortStr=s1.length()>s2.length()?s2:s1;
		for(int x=0,end=shortStr.length();x<end;x++){
			for(int y=0,flag=end-x;flag<end;y++,flag++){
				String temp=shortStr.substring(y,flag);
				if(longStr.contains(temp)){
					return temp;
				}
			}
		}
		return null;
		
	}

	/**
	 * 查找指定字符出现的次数
	 */
	public static int getKeyCount(String str,String key) {
		int index=0;//定义变量，记录每次找到的角标
		int count=0;//定义计数变量
		//条件是indexOf查找的方法返回的结果不是-1，而且要明确下次查找的位置
		while((index = str.indexOf(key,index))!=-1){
			count++;
			index+=key.length();
		}
		return count;
	}

	/**
	 * @param 排序
	 */
	private static void sort(String[] arr) {
		for(int i=0,end=arr.length;i<end;i++){
			for(int j=i+1,end2=arr.length;j<end2;j++){
				if(arr[i].compareTo(arr[j])>0){
					swap(arr, i, j);
				}
			}
		}
	}

	/**
	 * @param 交换变量
	 */
	private static void swap(String[] arr, int i, int j) {
		String temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	/**
	 * @param 打印数组
	 */
	private static void printArry(String[] arr) {
		for(int i=0,end=arr.length;i<end;i++){
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
}
