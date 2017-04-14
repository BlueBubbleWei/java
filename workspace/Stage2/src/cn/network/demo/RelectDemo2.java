package cn.network.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RelectDemo2 {
	/**
	* @param args
	* 演示如何根据给定名称取到指定的class对象后建立该类的对象呢？
	 * @throws Exception 
	*/
	public static void main(String[] args) throws Exception {
//		getObjectDemo1();
		getObjectDemo2();
	}

	/**
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	private static void getObjectDemo2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/*
		万一给定类中没有空参数呢？
		可以先获取指定的构造函数，再通过该构造函数进行实例化
		
		通过Class获取指定 构造函数，比如带两个参数
		*/
		String className="cn.network.demo.Person";
		Class class1=Class.forName(className);
		Constructor constructor=class1.getConstructor(String.class,int.class);//参数传递的是类型对象
		System.out.println(constructor);
		Object object=constructor.newInstance("李四",46);
	}

	/**
	 * @throws ClassNotFoundException 
	 * @throws ReflectiveOperationException 
	 * @throws InstantiationException 
	 * @throws Exception 
	 * @throws NoSuchMethodException 
	 * 
	 */
	private static void getObjectDemo1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, Exception {
		String className="cn.network.demo.Person";
		Class class1=Class.forName(className);
		Object object=class1.newInstance();//创建一个Person对象默认的调用该类的空参数构造函数
		//记住了，一般被反射的类通常都有空参数的构造函数
		
		
	}
}
