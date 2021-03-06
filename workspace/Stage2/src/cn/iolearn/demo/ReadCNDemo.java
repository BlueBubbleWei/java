package cn.iolearn.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadCNDemo {
	/**
	* @param args
	* 字符流操作中文数据
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		writeCNText();
		readCNText();
	}
	
	private static void readCNText() throws IOException {
		FileInputStream fileInputStream=new FileInputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");
	
		/*	
		读取中文，按照字节的形式，但是一个中文GBK码表中是两个字节
		而且字节流的read方法一次读取一个字节，如何可以获取到一个中文呢？
		别读一个就操作，多存一些起来再操作。存到字节数组中，将字节数组转成字符串就可以了
	*/	
		/*int by=fileInputStream.read();
		System.out.println(by);
		fileInputStream.close();*/
		
		byte[] buf=new byte[1024];
		int len=fileInputStream.read(buf);
		String s=new String(buf, 0, len);
		System.out.println(s);
	}
	
	private static void writeCNText() throws IOException {
		FileOutputStream fileInputStream=new FileOutputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");
		fileInputStream.write("大黑".getBytes());
		fileInputStream.close();
	}
}
