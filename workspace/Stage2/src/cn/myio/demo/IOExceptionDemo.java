package cn.myio.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExceptionDemo {
	/**
	* @param args
	*/
	static final String Line_SEPARATOR=System.getProperty("line.separator");
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fileOutputStream=null;
		try {
//	传入true  续写
			 fileOutputStream=new FileOutputStream("D:\\java\\workspace\\Stage2\\src\\cn\\myio\\demo3.txt",true);			
			fileOutputStream.write("\r\n我是大灰狼".getBytes());
			fileOutputStream.write(Line_SEPARATOR.getBytes());
			
		} catch (IOException e) {
			
		}finally {
			if(fileOutputStream!=null){//关闭资源前必须判断
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败"+e);
				}
			}
			
		}
	}
}
