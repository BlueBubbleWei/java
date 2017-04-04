package mythreads;
/*
进程：就是应用程序在内存中分配空间（正在运行中的程序 ）
线程：是进程红负责程序执行的执行单元，也成为执行路径
一个进程中至少有一个线程在负责该进程的运行
如果一个进程中出现了多个线程，就称该程序为多线程程序
举例：运动场---鸟巢，水立方
多线程技术：解决多部分代码同时执行的需求，合理的使用CPU的资源

多线程的运行根据cpu的切换完成的，怎么切换cpu说了算，
所以多线程运行有一个随机性（cpu的快速切换造成的）

jvm中的多线程
至少有两个线程：一个是负责自定义代码运行的,这个从main方法
			一个是负责垃圾回收的
通过实验，会发现每次结果不一定相同，因为随机性造成的
而且每一个线程都有运行的代码内容，这个称之为线程的任务
之所以创建一个线程就是为了去运行制定的任务代码
而线程的任务都封装在 特定的区域中
比如：
主线程运行的任务都定义在main方法中
垃圾回收线程在收垃圾时都会运行finalize方法 
*/
	
public class MoreThreads {
	public static void main(String[] args) {
		new Demo().color="Blue";//匿名对象，运行完成以后会进行垃圾回收机制
		new Demo().finalize();
		System.gc();//启动垃圾回收机
		System.out.println("结束");//这两个打印顺序的不确定是由CPU的不确定性造成的
	};
}

class Demo{
	String color;
	//定义垃圾回收方法
	protected void finalize()  {
		System.out.println("清除垃圾");
	}
}
