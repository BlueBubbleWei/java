package com.example.helloworld;

public class MyJava {
	public static void main(String[] args){
	/*	int a=3;
		System.out.println(a<<1);
		//最有效率运算2乘以8，通过位运算
		System.out.println(2<<3);
//	通过第三方变量交换两个数据
		int x=7,y=10,temp;
		temp=x;
		x=y;
		y=x;
//		对连个整数变量的值进行变换(不需要第三方变量)，通过和的形式
//		有个弊端，两个数据较大，可能会超出int范围
		int c=3,d=4;
		c=c+d;//c=3+4
		d=c-d;//d=7-4=3
		c=c-d;//c=7-3=4
//		对连个整数变量的值进行变换(不需要第三方变量)，通过异或形式
		c=c^d;//a=3^4
		d=c^d;//b=3^4^4;
		c=c^d;//c=3^4^3
*/
	
		/*//三元运算符，格式：(条件表达式)？表达式1：表达式2
		int x=1,y;
		y=(x>3)?100:200;
		System.out.println("y="+y);*/
//	if格式1
		int x=3;
		if(x>3){
			System.out.println(x);
		}else{
			System.out.println("wrong");
		}
		System.out.print(123);
//	if格式2
		/*if(条件表达式){
			执行语句
		}else{
			执行语句
		}*/
		int a=3;
		if(a>1){
			System.out.println("yes");
		}else{
			System.out.println(false);
		}
	}
//	if格式3
		/*if(条件表达式){
			执行语句
		}else if{
			执行语句
		
		}else{
			这行语句
		}*/
//	if格式4
		/*if(条件表达式)
			执行语句  只执行离if最近的一行
		*/

}
