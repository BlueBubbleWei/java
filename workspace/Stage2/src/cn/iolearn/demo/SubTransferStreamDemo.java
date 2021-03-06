package cn.iolearn.demo;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SubTransferStreamDemo {
	/**
	* @param args
	* 使用不同的编码表演示转换流
	* 什么时候使用转换流呢？
	 * @throws IOException 
	* 
	*/
	public static void main(String[] args) throws IOException {
//		转换流的子类
//		专门用于操作文件的流对象
		writeText();
		readText();
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void readText() throws IOException {
		FileReader fileReader= new FileReader("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt") ;
//		等效于
/*		
		FileInputStream fileInputStream=new FileInputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");
		InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
*/		
		int ch=0;
		while((ch=fileReader.read())!=1){
			System.out.println((char)ch);
		}
		fileReader.close();
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void writeText() throws IOException {
		
//		创建一个用于操作文件的字符输出流对象
		FileWriter fileWriter= new FileWriter("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");//内部使用默认的码表，而且只能操作文件
//		等效于
/*		
//		创建字节流对象
		FileOutputStream fileOutputStream =new FileOutputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");
//		字符通向字节的桥梁
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);//使用默认编码表GBK
*/	
		fileWriter.write("累赘");
		fileWriter.close();
		
	}
}
