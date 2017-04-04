package cn.myio.demo;

import java.io.File;

public class GetAllFile {
	/**
	* @param args
	*/
	public static void main(String[] args) {
	/*	
		遍历指定目录下的内容（包含子目录中内容）
		递归：函数自身调用自身，函数内部又使用到了该函数的功能
		*/
		File dir=new File("D:\\java\\workspace");
		getAllfiles(dir);
	}
	public static void  getAllfiles(File dir) {
		//获取该目录的文件对象数组
		File[] files=dir.listFiles();
		
//		对数组进行遍历
		for (File file : files) {
			if(file.isDirectory()){
				getAllfiles(file);
			}else {
				System.out.println(file);
			}
			System.out.println(file);
		}
	}
}
