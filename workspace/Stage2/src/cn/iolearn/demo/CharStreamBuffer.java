package cn.iolearn.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CharStreamBuffer {
	/**
	* @param args
	* 演示字符流的缓冲区
	* BufferReader
	* BufferWriter
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		writeTextByBuffered();
		readTextByBuffered();
//		读取键盘录入：Scanner =流+正则表达式。方法是按照某种规则在读数据
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		bufferedReader.readLine();
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	private static void readTextByBuffered() throws IOException {
		FileReader fileReader=new FileReader("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");
		BufferedReader bufferedReader=new BufferedReader(fileReader);
	/*	
		String line1=bufferedReader.readLine();
		System.out.println(line1);
		String line2=bufferedReader.readLine();
		System.out.println(line2);
	*/
//		另一种写法
		String line=null;
		while((line=bufferedReader.readLine())!=null){
			System.out.println(line);
		}
	}

	private static void writeTextByBuffered() throws IOException {
//		明确目的
		FileWriter fileWriter=new FileWriter("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");
		
//		创建缓冲区对象，明确要缓冲的流对象
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		
		
		/*bufferedWriter.write("哈哈哈哈");
		bufferedWriter.write("\r\n嘿嘿");
		bufferedWriter.close();*/
		
		for (int i = 0; i < 4; i++) {
			bufferedWriter.write("abc"+i);
			bufferedWriter.newLine();
			
		}
		bufferedWriter.close();
	}
}
