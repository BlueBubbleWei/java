package cn.iolearn.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo4 {
	/**
	* @param args
	* 复制一个文件
	* 思路：
	* 读取元数据，将数据写到目的文件中
	* 用到了流，操作设备上的设备
	* 读用到输入流 写用的输出流
	* 而且操作的还是文件。需要用到字节流中操作文件的流对象
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		copyText();
	}
	
	public static void copyText() throws IOException {
//		创建一个输入流和源数据相关联
		FileInputStream fileInputStream=new FileInputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\fos.txt");
//		创建一个输出流，并通过输出流创建一个目的流
		FileOutputStream fileOutputStream=new FileOutputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\copy.txt");
//		读一个写一个字节
		int by=0;
		while((by=fileInputStream.read())!=-1){
			fileOutputStream.write(by);
		}
//		关闭文件
		fileInputStream.close();
	}
}
