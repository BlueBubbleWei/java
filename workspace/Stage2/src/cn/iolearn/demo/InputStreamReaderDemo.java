package cn.iolearn.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class InputStreamReaderDemo {
	/**
	* @param args
	* 通过字符流读取中文数据
	 * @throws FileNotFoundException 
	*/
	public static void main(String[] args) throws IOException {
//		字符通向字节的桥梁
		writeCNText();
		//字节通向字符的桥梁
				readCNText();
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void writeCNText() throws IOException {
//		创建字节流对象
		FileOutputStream fileOutputStream =new FileOutputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");
//		字符通向字节的桥梁
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);//使用默认编码表GBK
		outputStreamWriter=new OutputStreamWriter(fileOutputStream,"UTF-8");
		
		
//		使用outputStreamWriter的write方法直接写中文字符串
//		写入数据时，都会存储到缓冲区，因为要查表
		outputStreamWriter.write("你好");
//		需要刷新缓冲区，将数据写入到目的文件中去
		outputStreamWriter.flush();
//		关闭资源
		outputStreamWriter.close();
	}

	private static void readCNText() throws IOException {
//		操作字节流对象的字符流对象，必须先有字节流
		FileInputStream fileInputStream=new FileInputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");
//		建立字节向字符的桥梁
		InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
//		转为中文字符打印
		int ch=inputStreamReader.read();
		System.out.println((char)ch);
		int ch1=inputStreamReader.read();
		System.out.println((char)ch1);
		int ch2=inputStreamReader.read();
		System.out.println((char)ch2);
		int ch3=inputStreamReader.read();
		System.out.println((char)ch3);
		
	}
}
