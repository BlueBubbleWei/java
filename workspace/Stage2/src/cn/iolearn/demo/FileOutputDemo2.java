package cn.iolearn.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileOutputDemo2 {
	/**
	* @param 输出已有文件的内容
	* 既然是读，使用InputStream
	* 而且是要操作文件 FileInputStream
	* 创建文件字节读出流对象时，必须必须明确与之关联的数据源
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
//		为了确保文件一定在读之前是存在的，将字符串路径封装成File对象
		File file= new File("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\fos.txt");
		if(!file.exists()){
			throw new RuntimeException("要读取的文件不存在");
		}
//		创建文件字节读出流对象时，必须必须明确与之关联的数据源
		FileInputStream fileInputStream=new FileInputStream(file);
//		调用读取文件流对象读取方法. read()
	/*	int by1 =fileInputStream.read();
		System.out.println("by2="+by1);
		int by2 =fileInputStream.read();
		System.out.println("by3="+by2);*/
		
		int by=0;
		//如果不到文件末尾就一直读   -1代表文件尾部
		while((fileInputStream.read())!=-1){
			System.out.println(fileInputStream.read());
		}
		
		
//		关闭资源
		fileInputStream.close();
	}
}
;