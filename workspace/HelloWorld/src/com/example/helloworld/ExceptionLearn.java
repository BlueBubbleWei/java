package com.example.helloworld;

import java.security.PublicKey;

public class ExceptionLearn {
	/*异常的体系
	 * java程序在运行时期发生的不正常情况
	 * java就按照面向对象的思想对不正常情况进行描述和对象的封装
	 * 问题分两种： Exception  and  Error
	 * Throwable：定义了对于问题分析的功能
	 * Error:由系统底层发生的,告诉jvm，jvm告诉使用者，不做针对性处理，必须修改代码
	 * Exception:jvm发生，病告诉使用者，可以进行针对性的处理
	 * */
	public static void main(String[] args) {
		int [] arr=new int[10];
//		arr=null;		
		System.out.println(arr[1]);
/*输出语句发声问题是，jvm就将这个已知的问题封装成对象
		throw new ArrayIndexOutOfBoundsException(1):将问题抛出给调用者main函数
		main没有针对性的处理方式，main就继续抛给调用者jvm,jvm就使用了默认的处理方式
		将问题的名称+信息+位置在控制台上显示出来，告诉调用者，让调用者看到并结束程序
		
		异常的处理
		 *两种：
		 *遇到问题不进行具体处理，而是继续抛给调用者
		 * 
		 * 2、针对性的处理方式：捕获
		 * try{
		 * 	//有可能发生异常的代码
		 * }catch(异常类 变量){
		 * 	
		 * }finally{
		 * 	//一定处理的代码
		 * }
		 * 
		 * finally作用是：无论是否偶异常发生，都要对资源进行释放
		 * 资源释放的动作就定义在finally代码块中
		 * 
		 * thorw和throws有什么区别呢？
		 * 1、位置不同。
		 * throws用在函数上，后面跟的是异常类，可以跟多个
		 * throw用在函数内，后面跟的是异常对象
		 * 2、功能不同
		 * throws用来声明异常，让调用者只知道该功能有可能出现的问题，并又调用者可以给出预先的处理方式
		 * throw抛出具体问题对象，执行到throw功能就已经结束了，跳转到调用者，并将具体的问题对象也抛给调用者
		 * 也就是说throw语句独立存在时，下面不要定义其他语句，因为执行不到		
		 * 
		 * 异常体系的特殊情况
		 * Exception
		 * 	|--Error
		 * 	|--Exception
		 * 异常体系的最大特点就是体系中的类以及类产生的对象，都具备可抛性，可抛性的意思是可以被throws和throw所操作
		 * 
		 * 异常的原则：
		 * 1、功能内部有异常throw抛出，功能上一定要throws声明
		 * 内部抛什么，功能上就声明什么
		 * 声明的目的就是为了让调用者处理，如果调用者不处理，编译失败
		 * 
		 * 2、特殊情况
		 * 当函数内通过throw抛出了RuntimeException及其子类的异常对象时，函数上可以不用throws声明
		 * 不声明的目的就是不让调用者处理，让调用者的程序停止。要对代码进行更改
		 * 
		 * Exception分两种
		 * 1、编译时会被检测的异常
		 * 2.运行时异常（编译时不检测）RuntimeException
		 * 
		 * 在自定义的程序中，如果有了问题，也可以像java中的异常一样，对问题进行描述
		 * 举例：
		 * 定义一个功能可以实现除法运算，但是除数不可以为负数
		 * 
		 * 小结：
		 * 异常：其实就是将问题封装成对象，并抛给调用者
		 * 如果声明了。就需要调用者处理（继续声明或捕获）
		 * 什么时候声明，什么时候捕获？
		 * 功能内部可以解决就捕获，不能解决或者解决了还必须告诉调用者问题，这时就应该声明
		 * 
		 *1、有资源需要释放，仅仅是处理异常 
		 * try{
		 * }catch{
		 * }finally{
		 * }
		 * 
		 * 2、一个try多个catch，一般对应的是被调用的函数，抛出多个异常的情况，分别处理
		 * try{
		 * }catch{
		 * }catch{
		 * }finally{
		 * }
		 * 注意：在多catch语法上特殊的地方，如果catch中的异常类存在子父类，父类的catch一定要放在子类的下面，否则编译失败
		 * *3、不一定要处理异常，但是有资源需要释放
		 * try{
		 * }finally{
		 * }
		 * 
		 * 覆盖时：
		 * 子类方法覆盖父类方法只能抛出父类方法异常或者该异常类
		 * 如果父类方法抛出多个异常，子类只能抛出父类异常的子集
		 * 原则：就是子类的异常必须要在父类的异常处理控制中
		 * 
		 * 注意：有一种情况，只能try不能throws
		 * 该覆盖的方法没有抛出异常
		 * 那么子类在覆盖时，子类方法中发生了异常，就只能try无法throws声明 
*/
		DemoEXcption demo= new DemoEXcption();
		try{
			int num= demo.div(4, 0);
			System.out.println("num="+num);
		}catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.toString());
			e.printStackTrace();//名字+信息+位置，jvm
			System.exit(0);//退出jvm。只有这种情况，finally也不执行
		}finally {
			System.out.println("Finally");
		}	
		
		//定义数组
		int [] arr1=new int[3];
		System.out.println("element"+getElement(arr1, 4));
	}
	//定义一个功能，返回一个整型数组中指定位置的元素
	public static int getElement(int[] arr,int index){
		if(arr==null){
			throw new NullPointerException("数组实体不存在！");
		}
		if(index < 0){
			throw new ArrayIndexOutOfBoundsException(index+"不存在");
		}
		if(index>arr.length){
			throw new ExceedException("数组越界");
		}
		int element=arr[index];
		return element;
	}
}

class DemoEXcption{
	/*在编写功能时，编写者知道该功能有可能发生问题，而这个问题很容易来自于调用者传递的参数而导致程序无法运行
	这时发生的问题就应该让调用者知道。并最好让调用者有预先处理的方式
	所以在定义功能时，需要在功能上对有可能发生的问题进行声明
	声明问题需要使用关键字。thorw异常类。
	声明的目的：就是让调用者可以进行处理*/
	int div(int a,int b)throws Exception{//声明异常
		if(b==0){
			throw new ArithmeticException("不能除0！");//抛出异常
		}
		return a/b;
	}

}
class ExceedException extends RuntimeException{
	ExceedException(String message){
		super(message);
	}
}
