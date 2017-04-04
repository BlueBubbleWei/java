package cn.myio.demo;

import java.io.File;

public class IoDemo {
	/**
	* @param args
	*  
	*  /**
	* @param 
	* 流按操作数据分为两种：字节流与字符流
	* 流按流向分为：输入流（读）输出流（写）
	* 字节流的抽象基类：InputSream	OutputStream
	* 字符流的抽象基类
	* 
	*
	* IO流用来处理设备之间的数据传输
		Java对数据的操作是通过 流（系统资源） 的方式的
		Java用于操作流的对象都在java.io包中
		
		Io：用于处理设备上的数据的技术。设备：内存，硬盘。光盘
		流：系统资源，windows系统本身就可任意操作设备，各种语言只是使用系统平台的这个资源
		并对外提供了各种语言自己的操作功能，这些功能最终调用的是系统资源
		使用完资源一定要记住：释放
		设备上数据最常见的存储表现形式文件file
		
		先学习一下文件的基本操作
		描述文件或者文件夹的类是file
	*/
	private static final String FILE_SAPARATOR=System.getProperty("file.separator");
	
	public static void main(String[] args) {
//		将具体的路径封装成了File对象。可以封装存在的文件或目录，也可以封装不存在的文件或目录
		
		File file=new File("C:\\1.txt");
		
		//File(String parent,String child)
		File file1=new File("C:\\","1.txt");
		File dir=new File("c:\\");
		File file2=new File(dir,"1.txt");
		File file3=new File("c:"+FILE_SAPARATOR+"abc"+FILE_SAPARATOR+"1.txt");		
		File file4=new File("C:\\abc\\1.txt");
		System.out.println(file3);
	}
}
