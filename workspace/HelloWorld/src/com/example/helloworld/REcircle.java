package com.example.helloworld;

import android.R.drawable;
import android.R.integer;
import android.provider.Telephony.Mms.Inbox;

public class REcircle {
	public static void main(String[] args){
//		public static 静态方法加了，后面的它调用的方法都要加	
//		主方法不要把代码写主函数里面，它只能调用方法		
	/*	draw(4,5);
//		需求：需要一个方法，定义两个数的加法运算，并求和*/
		int sum;
		sum=add(3,6);
		sum=add(4,5,6);
		System.out.println(sum);
		
//		定义数组
//		数组的定义方式：
//		元素类型[] 数组名 = new 元素类型[元素个数或数组长度]；
//		好处：数组可以存储多个数据，而且可以对数据进行编号，从0开始，操作元素可以通过编号完成
		int[] arr =new int[3];//通过new关键字创建了一个长度为3，元素类型是Int的数组实体，int指的是元素的类型
//		数组定义格式2：
		int [] arr2={22,24,25};
		
		int [] arr3={2,7,19,0,1,5};
		int max=compare(arr3);
		System.out.println("max="+max);
		
	}
	public static int add(int x,int y,int z){
		return x+y+z;
	}
	
	public static int add(int x,int y){		
		return x+y;
	}
	
	public static double add(double x,double y){
		return x+y;
	}
	
//	获取多个数的和的功能
//	明确1. 结果？和int
//	明确2.参数？多个参数，定义多个参数合适吗？既然是一组数，数组
	public static int add(int[] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		return sum;
	}
	
	
	public static void draw(int row,int col){
		if(row<7){
			return;
//			System.out.println("不会执行！");
		}					
		System.out.println("执行！");
		for(int x=0;x<row;x++){
			for(int y=0;y<col;y++){
				System.out.print('*');
			}
			System.out.println();
		}		
	}
	
//	需求 ：获取多个整数中的最大值
//	思路：
//	1、数据多了，为了便于操作，先存储起来，需要容器，用数组
//	2、多个数据需要进行比较，每次都有较大大的数，需要记录下来和下一个数比较
//	3、将数组中的数都比较一遍，就有了最大值
//	1.需要数组
//	定义一个变量记住较大值
//	遍历整个数组，和记录最大最大值的那个变量进行比较
//	如果元素大于较大的数，用变量记录该元素
//	便利完成以后，变量中记录的就是最大的值
	
	public static int compare(int[] arr){
		int max=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
	
}
