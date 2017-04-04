package cn.myio.demo;

import java.io.File;

public class DeleteDirDemo {
	/**
	* @param 删除一个带内容的文件夹，必须从里往外删
	*/
	public static void main(String[] args) {
		File dir = new File("D:\\java\\workspace\\Stage2\\src\\cn\\myio\\demo\\abc");
		System.out.println(dir.delete());
		delDir(dir);
	}

	/**
	 * @param dir
	 */
	private static void delDir(File dir) {
//		1、列出当前目录下的文件以及文件夹
		File[] files=dir.listFiles();
		
//		2、对该数组进行遍历
		for (File file : files) {
			if(file.isDirectory()){
				delDir(file);
			}else {
				System.out.println(file+"已删除"+file.delete());
			}
		}
		System.out.println(dir+"已删除"+dir.delete());
	}
}
