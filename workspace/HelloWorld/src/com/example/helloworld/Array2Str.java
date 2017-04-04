package com.example.helloworld;

import android.R.string;

import java.lang.reflect.Array;
import java.util.Arrays;;

public class Array2Str {
	 public static void main(String[] args){
		 int [] arr={1,2,3,4};
		 String str=Int2Str(arr);
		 System.out.println("str="+str);
		 
		 int num=3;
		 String str2=getWeek(num);
		 System.out.println(num);
		 System.out.println(str2);
		 int [] arr3={45,1,90,34,78,34,77};
		 Arrays.sort(arr3);
		 System.out.println(arr3);
		 int[][] arr4 =new int [3][2];
//		 自带的二分查找法
		 int c=Arrays.binarySearch(arr3, 90);
		 System.out.println("find out"+c);
	 }
 
 
	 public static String Int2Str(int[] arr){
		String str="[";
		for(int i=0;i<arr.length;i++){
			if(i!=arr[arr.length-1]){
				str+=arr[i]+',';
			}		
		}
		str+="]";
		return str;	 
	 }
	 
	 
	 public static String getWeek(int num){
		 String[]  week={"星期一","星期二","星期三","星期四","星期五"};
		 
		 return week[num-1];
	 }
	// 选择排序
	 public static int[] choiceSort(int[] arr){
		 for(int i=0;i<arr.length-1;i++){
			 for(int j=i+1;j<arr.length;j++){
				 if (arr[i]>arr[j]){
					 int temp;
					 temp=arr[i];
					 arr[i]=arr[j];
					 arr[j]=temp;				 
				 }
			 }
		 }
		 return arr;
	 }
	 
	 
	//冒泡排序
	public static int[] bubbleSort(int[] arr){
		 for(int i=0;i<arr.length-1;i++){
			 for(int j=0;j<arr.length-i-1;j++){
				 if (arr[j]>arr[j+1]){
					 int temp;
					 temp=arr[j];
					 arr[j]=arr[j+1];
					 arr[j+1]=temp;				 
				 }
			 }
		 }
		 return arr;
	}
	//发现排序方法，位置代码重复，进行抽取
	public static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
//	查找
//	需求：查找一个元素在数组中国第一次出现的位置
	public static int searchKey(int[] arr,int key){
//		遍历查找
		for(int i=0;i<arr.length;i++){
			if(arr[i]==key){
				System.out.print(i);
				return i;
			}
		}
		return -1;//-1代表的是不存在的情况
	}
//	 二分查找:前提数组必须是有序的
	/*思路：
	 通过角标先获取中间角标上的元素
	 让该元素和要找的数据比较
	 如果要找的数打了，缩小范围，要找的范围应该是 ：中间的角标+1-----尾角标*/	 
	public static int binarySearch(int[] arr,int key){
		int max,min,mid;
		min=0;
		max=arr.length-1;
		mid=(max+min)>>1;
		while(arr[mid]!=key){
			if(key>arr[mid]){
				min=mid+1;
			}else if (key <arr[mid])
				max=mid-1;
			if(max<min)
				return -1;
		}
		return mid;
	}
	
//	二分查找的另一种方法
	public static int binarySearch_1(int[] arr,int key){
		int min,mid,max;
		min=0;
		max=arr.length-1;
		while(min<=max){
			mid=(min+max)>>1;
			if(key>arr[mid])
				min=mid+1;
			else if(key<arr[mid])
				max=mid-1;
			else 
				return mid;
		}
		return -1;
	}
}
