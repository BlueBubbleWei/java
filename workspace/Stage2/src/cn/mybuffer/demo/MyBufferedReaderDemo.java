package cn.mybuffer.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderDemo {
	/**
	* @param args
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		FileReader fileReader=new FileReader("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\fos.txt");
	/*	
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		String line=null;
		while((line=bufferedReader.readLine())!=null){
			System.out.println(line);
		}
	*/
//		调用重写的myReadLine方法
		MyBufferedReader bufferedReader=new MyBufferedReader(fileReader);
//		调用重写的获取行号的方法
		MyLineNumberReader myLineNumberReader=new MyLineNumberReader(fileReader);
		String line=null;
		while((line=bufferedReader.myReadLine())!=null){
			System.out.println(myLineNumberReader.getLineNumber()+":"+line);//为什么行号没有自增？
		}
		
		
		
	}
}
