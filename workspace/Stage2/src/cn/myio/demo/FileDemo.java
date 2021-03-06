package cn.myio.demo;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	/**
	* @param args
	* Flie类 常见方法
	* 1、名字  获取名称
	* String getName();
	* 2、大小  获取大小
	* long length();
	* 3、获取类型
	* 没有
	* 4、获取所在目录
	* String space();
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		
		File file=new File("D:\\1.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		
		String file_name=file.getName();//获取名称
		System.out.println(file_name);
		
		long len=file.length();//获取大小
		System.out.println(len);
		
		String space=file.getPath();
		System.out.println(space);
	}
}
