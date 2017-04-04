package com.example.helloworld;

import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;

import android.content.Loader.ForceLoadContentObserver;
import android.view.FocusFinder;

/*用户名：BubbleFamily
address:Blue_Bubbles@163.com
pw:BubbleFamily123456*/
public class UsrInput {
	public static void main(String[] args){
//		需求：获取1-100之间的6的倍数的个数
		int a=1,sum=0;
		while(a<100){
			if(a%6==0){
				sum++;
				System.out.println("a="+a);
			}
			a++;
		}
		System.out.println("sum="+sum);
	
		for(a=1;a<5;a++){
			for(int j=0;j<4;j++){
				System.out.print('*');
			}
			System.out.println();
		}
//		方法1
		int z=5;
		for(int i=0;i<5;i++){
			for(int j=0;j<z;j++){
					System.out.print('*');
			}
			System.out.println();
			z--;
		}
//		方法2
		for(int i=0;i<5;i++){
			for(int j=i;j<5;j++){
					System.out.print('*');
			}
			System.out.println();
		}
		
		
		
		for(int x=1;x<3;x++){
			if(x==1)
				break;
			System.out.print("end");//不会输出			
		}
		for(int x=1;x<4;x++){
			if(x==2)
				continue;//结束本次循环，继续下次循环
			System.out.print("输出");//会输出			
		}
		
/*//		需求：根据用户给定的月份数据，显示该月份在哪个季节
		步骤：1、定义变量
		2定义if语句*/
		int x=3;
		switch(x){
		case 1:
		case 2:
		case 3:
			System.out.println("春天");
			break;
		case 4:
		case 5:
		case 6:
			System.out.println("夏天");
			break;
		default:
			System.out.println("冬天");
			break;
		}
//		需求：对给定的整数26，进行16进制的获取
//		1、16进制是数据的一种表现形式，，好处在于可以使表现形式更短
//		原理：将二进制中的4位为一个十六进制位
//		2、获取每4位，就是获取4位中的1，可以通过&位运算的方式完成的
//		3、想要获取下4四位，可以通过对元数据进行无符号右移的方式
		
//		步骤：
//		1、定义变量记录该整数
//		2、对该变量进行&运算，既然是获取四位，就&四个1，二进制四个1就是十进制的15
//		3、对元数据进行无符号右移四位
		int num=26;
		int n1=num & 15;
		System.out.println("n1="+n1);
//		对num进行右移
		num=num>>>4;
//		再进行 &  15
		int n2=num & 15;
		System.out.println("n=2"+n2);
		
		for(int i=0;i<8;i++){
			int n=num & 15;
			if(n>9){
				System.out.println((char)(n-10+'A'));
			}else{
				System.out.println(n);
			}
			num=num>>>4;
		}
	}
}
