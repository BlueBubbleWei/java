package cn.myio.demo;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo3 {
	/**
	* @param args
	*/
	public static void main(String[] args) {
		
//		获取指定文件夹中的所有文件和文件夹的名称。能不能只获取.java文件呢？
		File file=new File("C:\\");
		String[] names=file.list();//列出当前目录下的所有文件和文件夹名称，包含隐藏文件
									//只能获取名称，不能获取大小
		/*for(String name:names){
			System.out.println(name);
		}*/
		/*
		 //同上面一种写法
		if(names!=null){
			for(String name:names){
				System.out.println(name);
			}
		}
		*/
		
		File[] files=file.listFiles();
		/*for(File f:files){
			System.out.println(f);
		}*/
		
		//获取指定目录下.java文件
		File file2=new File("D:\\java\\workspace\\Stage2\\src\\cn\\myio\\demo");
		
//		传入一个过滤器
//		String[] name_filter=file2.list(new FileBySuffix(".class"));//过滤后缀名的过滤器
		FilenameFilter filter=new FileBySuffix(".java");//过滤后缀名的过滤器
		filter=new FilerByContain("Demo");
		
		String[] names2=file2.list(filter);
		for(String name:names2){
//			if(name.endsWith(".java"))//相当于过滤
				System.out.println(name);
			
		}
	}
}
