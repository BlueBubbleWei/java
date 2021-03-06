package cn.iolearn.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicByDemo {
	/**
	* @param args
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		copyPicByBuffer();
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void copyPicByBuffer() throws IOException {
//		演示缓冲区
//		创建具体的流对象
		FileInputStream fileInputStream=new FileInputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\1.jpg");
		FileOutputStream fileOutputStream=new FileOutputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\copy.jpg");
		
//		创建缓冲流
		BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
		
		
	/*	
	    int  by=0;
		while((by=bufferedInputStream.read())!=-1){
			System.out.println(by);//读数据
		}
	*/	
//		对copy.jpg写数据
		byte[] buf=new byte[1024];
		int len=0;
		while((len=bufferedInputStream.read(buf))!=-1){
			bufferedOutputStream.write(buf,0,len);
			bufferedOutputStream.flush();//刷新输出流
		}
		
		bufferedInputStream.close();
		bufferedOutputStream.close();
		
	}
}
