package cn.myio.demo;

import java.io.File;
import java.io.FileFilter;

public class FileFilterDemo {
	/**
	* @param 文件过滤器	FileFilter
	*/
	public static void main(String[] args) {
		File dir=new File("C:\\");
//		传递过滤器
		FileFilter filter=new FilerByFile();
		File[] files=dir.listFiles(filter);
		for (File file : files) {
			System.out.println(file);
		}
	}
}
