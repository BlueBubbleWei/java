package cn.iolearn.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo{
	/**
	 * @param string
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		File dir=new File("tempfile");
		if(!dir.exists()){
			dir.mkdir();
		}
	/**	
		1、创建字节输出流对象。用于操作文件，在对象初始化时，必须明确数据存储的目的地
		输出流所关联的目的地，如果不存在，会自动创建。如果存在，则覆盖
	*/
		FileOutputStream fOutputStream=new FileOutputStream("tempfile\\fos.txt");
//		2、调用输出流的功能
		String string="123456";
		byte[] buf=string.getBytes();
		fOutputStream.write(string.getBytes());
		
//		3、释放资源
		fOutputStream.close();
		
	}
}
