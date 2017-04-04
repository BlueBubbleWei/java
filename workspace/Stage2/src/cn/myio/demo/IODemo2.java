package cn.myio.demo;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class IODemo2 {
	/**
	* @param 
	* 获取一个想要的指定文件的集合 获取wokespace下（包含子目录）的所有的.java的文件对象，并存储到集合中
	* 思路：
	* 1、既然包含子集合，就需要递归
	* 2、在递归过程中需要过滤器
	* 3、满足条件，都添加到集合中
	* 
	* 
	*/
	
	/**
	 * 定义一个获取指定条件的文件的集合
	 * 
	 *多级目录下都要用到相同的集合和过滤器  那么不要在递归方法中定义，而是不断地进行传递
	 * @param dir 需要遍历的目录
	 * @param list 用于存储符合条件的File对象
	 * @param filter 接受制定的过滤条件
	 *
	 */
	public static void main(String[] args) {
		File dir=new File("D:\\java\\workspace");
		List<File> list=fileList(dir);
		for (File file : list) {
			System.out.println(file);
		}
	}
	 
	public static void getFileList(File dir,List<File> list,FileFilter filter) {
//		1、通过listFiles放啊，获取dir当前下的所有的文件和文件夹对象
		File[] files=dir.listFiles();
//		2、遍历该数组
		for (File file : files) {
//			3、判断是否是文件夹，如果是，递归。如果不是，那就是文件夹，就需要对文件进行过滤
			if(file.isDirectory()){
				getFileList(dir, list, filter);
			}else {
//				4、通过过滤器对文件进行过滤
				if(filter.accept(file)){
					list.add(file);
				}
			}
			
		}
	}
	public static List<File> fileList(File dir) {
//		1、定义集合
		List<File> list=new ArrayList<File>();
//		2、定义过滤器
		/*FileFilter fileFilter=new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname;
			}
		};*/
		
		FileFilter filter=new FilterBySuffix(".java");
		getFileList(dir, list, filter);
		return list;
	}
}
