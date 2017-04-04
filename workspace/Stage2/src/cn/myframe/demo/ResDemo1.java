package cn.myframe.demo;


public class ResDemo1 {
	/**
	* @param args
	* 正则表达式：正确的规则
	* 规则是由符号组成的
	* 
	* 专门用于对字符串的操作
	* 	1、匹配
	* 		String 类中提供了匹配 boolean matches(Res)的方法
	* 	2、切割
	* 	3、替换
	* 	4、获取
	*/
	public static void main(String[] args) {
		String QQ="02275455";
	/*	
		boolean b=checkQQ(QQ);
		if(b){
			System.out.println(QQ+"\tOK");
		}else {
			System.out.println(QQ+"\ttry again");
		}
	*/	
		boolean b=QQ.matches("[1-9][0-9]{4,14}");//第一个数字的范围是1-9，后面的4-14位是0-9
//		System.out.println(QQ+":"+b);
		
		
		String temp="aaaaaa1";
		boolean res=temp.matches("a\\d{3,}");// \d匹配一次或者一次也没有 \d?匹配多次  \d{5}出现5次a  \d{5,}至少5次  \d{5，7}  5-7次
		System.out.println(temp+"\t"+res);
	}
	
	public static boolean checkQQ(String QQ) {
		boolean b=false;
		int len=QQ.length();//获取长度
		if(len>=5 && len<=15){
			//判断是否以0开头
			if(!QQ.startsWith("0")){
				try {
					long qq_num=Long.parseLong(QQ);
					System.out.println("QQ"+QQ);
					b=true;
				} catch (Exception e) {
					System.out.println("非法");
				}
				
			}
		}else {
			System.out.println("长度错误！");
		}
		return b;
	}
}
