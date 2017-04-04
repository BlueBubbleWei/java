package cn.myio.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStramDemo {
	/**
	* @param 将数据包写到文件当中
	* 使用字节输出流
	* FileOutputStream
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		File file=new File("D:\\java\\workspace\\Stage2\\src\\cn\\myio\\demo\\tempfile");
	/*	
		1、创建字节输出流对象，用于从奥做文件，在对象初始化时，必须明确数据存储的目的地
		输出流所关联的目的地，如果不存在，会自动创建
	*/	
		FileOutputStream fileOutputStream=new FileOutputStream("D:\\java\\workspace\\Stage2\\src\\cn\\myio\\demo3.txt");
		
//		调用输出流的写功能
		String string="3sdsfsf";
		byte[] buf=string.getBytes();
		fileOutputStream.write(buf);
		fileOutputStream.write("我是大灰狼".getBytes());
		
//		3、释放资源
		fileOutputStream.close();
	}
}
