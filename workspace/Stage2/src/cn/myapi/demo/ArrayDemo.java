package cn.myapi.demo;


public class ArrayDemo {
	/**
	* @param args
	*/
	public static void main(String[] args) {
	/*	
		int sum=add(4,5);
		int sum1=add(4,5,6);
	*/	
		int[] arr={37,17,21,87};
		int[] arr2={3,5};
		int sum=add(arr);
		int sum2=add(arr2);
		System.out.println(sum);
		System.out.println(sum2);
		
		int sum3=add(6,7,8);
		System.out.println(sum3);//调用可变参数
		
	}
/*
	public static int add(int i, int j) {
		return i+j;
	}
	*/
	
/*
	public static int add(int i, int j,int k) {
		return i+j+k;
	}
	*/
	
/*	
	//	简化版
	public static int add(int[] arr) {
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
*/	
	public static int add(int... arr) {
		//...代表可变参数，还是数组  弊端add(int... arr,int x)报错  add(int x,int... arr) 运行   可变参数要求一定是最后一个参数
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
}
