package cn.iolearn.demo;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputOutStreamDemo {
	/**
	* @param args
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\fos.txt");
		System.out.println(fis.available());//获取与之关联的文件的字节数
		byte[] buf=new byte[fis.available()];//开辟与文件大小相同的内存
		fis.read(buf);
		String string=new String(buf);
		System.out.println(string);
	}
}
