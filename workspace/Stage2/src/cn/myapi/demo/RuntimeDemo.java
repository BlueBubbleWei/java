package cn.myapi.demo;

import java.util.Random;

public class RuntimeDemo {
	public static void main(String[] args) throws Exception{
//		单例模式对象Runtime
		Runtime runtime=Runtime.getRuntime();
//		runtime.exec("notepad.exe");
//		Math 数学类，都是静态成员
		double d1=Math.ceil(12.43);
		double d2=Math.floor(12.43);
		double d3=Math.round(12.43);
/*		
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);
		System.out.println(Math.pow(10, 3));
	*/	
		for (int i = 0; i < 10; i++) {
			double d=Math.ceil(Math.random()*10);
			System.out.println(d);
		}
		
		Random random= new Random();
		for (int i = 0; i < 10; i++) {
			int d=random.nextInt(6)+1;
			System.out.println("random"+d);
		}
	}
}
