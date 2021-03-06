package cn.iolearn.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SubTransStreamDemo2 {
	/**
	* @param args
	* 复制一个文本文件
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		copyText();
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void copyText() throws IOException {
		//明确数据源。定义字符读取流和数据源关联
		FileReader fileReader= new FileReader("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");
//		明确数据的目的文件  定义字符输出流，创建存储数据的目的地
		FileWriter fileWriter=new FileWriter("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\CN.txt");
//		3、创建缓冲区
		char[] buf=new char[1024];
		int len=0;
		while((len=fileReader.read(buf))!=-1){
			fileWriter.write(buf,0,len);
		}
		fileWriter.close();
	}
}
