package cn.myio.demo;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;

public class FileDemo1 {
	/**
	* @param args
	* File	方法
	* 1、获取文件的绝对路径
	* 	String getAbsolutePath();
	* 2、获取文件的路径
	* 	String getPath();
	* 3、获取文件的最后一次修改时间，要求是X年X月X日。时间
	* 	String lastModified();
	* 4、文件是否是隐藏的
	* 	boolean isHidden();
	* 5、发现File对象封装的文件或者 文件夹是可以存在的也可以是不存在的
	* 那么不存在的可否用file的功能创建按呢？	
	* 	创建功能
	* 		boolean createNewFile();
	* 	删除功能
	* 		boolean delete();
	* 6、一个File对象封装的文件或者文件夹到底是否存在内容？
	* 是否存在
		boolean exists();
	*7、getFreeSpace()方法是什么意思？用Demo验证。getTotalSpace()  getUsableSpace()
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		
		File file=new File("D:\\java\\workspace\\Stage2\\src\\cn\\myio\\demo\\2.txt");
		
//		methodDemo1(file);
		
//		methodDemo2(file);
		
		File file2=new File("D:\\java\\workspace\\Stage2\\src\\cn\\myio\\demo\\abc");
		methodDemo3(file2);
		
		methodDemo4();
		
	}

	/**
	 * 
	 */
	private static void methodDemo4() {
		File file =new File("C:\\");
		System.out.println(file.getFreeSpace());//可用空间的大小
	}

	/**
	 * @param file2
	 */
	private static void methodDemo3(File file) {
		
//		创建文件夹
		boolean dir=file.mkdir();
		System.out.println(dir);
		
		
		boolean exist=file.exists();
		System.out.println(exist);
		
		boolean del=file.delete();//删除文件夹时，必须保证该文件夹没有内容。有内容必须先把内容删除，才可以删除当前文件
		System.out.println(del);
		
//		3、创建多级目录
		boolean dirs=file.mkdirs();
		System.out.println(dirs);
		
//		4、判断是不是文件、是不是文件夹
		System.out.println("file:"+file.isFile());
		System.out.println("dir:"+file.isDirectory());
		
	}

	/**
	 * @param file
	 * @throws IOException 
	 */
	private static void methodDemo2(File file) throws IOException {
//		1、创建文件夹
		boolean b=file.createNewFile();//创建文件  如果文件存在。则不创建返回false  不存在就创建 返回true
		System.out.println(b);
		
//		2、删除
		boolean d=file.delete();
		System.out.println("delete:"+d);
	}

	/**
	 * @param file
	 */
	private static void methodDemo1(File file) {
		String path=file.getAbsolutePath();//获取文件的绝对路径，即使封装的是相对的，获取的也是绝对的
		System.out.println(path);//获取的是file对象的封装路径，封装的是什么，获取的的就是什么
		
		
		String path1=file.getPath();
		System.out.println(path1);
		
		long time=file.lastModified();//现在的Unix时间戳(Unix timestamp)
		Date date=new Date(time);//日期转换
		String str_date=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(date);
		System.out.println(str_date);
		
		boolean b=file.isHidden();//判断文件是否隐藏
		System.out.println("isHiddden"+b);
	}
}
