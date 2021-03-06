package cn.inprint.demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class printDemo {
	/**
	* @param printStream
	* IO包中的其他功能流对象
	* 功能流对象
	* 特点：解决的问题,特有的方法
	* 打印流--输出流
	* PrintStream(字节流)  PrintWriterStrean(字符流)
	* 特点：打印  不抛异常
	* 打印的目的：File对象，字符串路径，字节输出流
	* 解决问题：
	* 	方便地打印
	* 	它的打印方法可以保证数值的形式不变，写的是什么。目的就是什么
	* 
	* 
	* 
	* printWriter:一样具备打印功能
	* 	目的：File对象，字符串路径，字节输出流，字符输出流
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
	/*	
		PrintStream pStream=System.out;
		pStream.println("HI");
//		等同于
		System.out.println("HI");
	*/	
		
		printStreamDemo();
	}


	private static void printStreamDemo() throws IOException {
//		演示PrintStream的特有方法
//			创建PrintStrwm对象。目的就定为文件
		File dir=new File("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\demo.txt");
		if(!dir.exists()){
			dir.createNewFile();
		}
		PrintStream printStream=new PrintStream(dir);
//		将数据打印到文件中
		printStream.write(3);//对字节流的write方法一次只写出一个字节 读出为e 保证数值的表现形式  其实原理就是讲数值转成字符串
		printStream.write("3".getBytes());//对字节流的write方法一次只写出一个字节 读出为byte
		printStream.print("我是大灰狼");//输入什么就写什么   保证数值的表现形式。其实原理就是将数值转成字符串
		printStream.close();
	}
}
