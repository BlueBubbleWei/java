package cn.iolearn.demo;

import java.io.File;
import java.io.FileInputStream;

public class FileOutputStream3 {
	/**
	* @param args
	* 演示第二种读取方式 read(byte[])
	*/
	public static void main(String[] args) {
		FileInputStream  fileInputStream=null;
		try {
			fileInputStream=new FileInputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\fos.txt");
//		创建一个字节数组
		/*	
			解决数组该多大的问题，一般为1024的整数倍
			byte[] b=new byte[1024];
			一般会搞一个常量
			private static final int default_size=1024;
			byte b=new byte[default_size];
		*/	
		
			
			byte[] b=new byte[2];
			
	/*		
//			调用read(byte[])方法
			int len=fileInputStream.read(b);//len记录的是往字节数组里存储的字节个数
			System.out.println(len+"..."+new String(b));//将字节数组转成字符串打印  看效果
			int len1=fileInputStream.read(b);//len记录的是往字节数组里存储的字节个数
			System.out.println(len1+"..."+new String(b));//将字节数组转成字符串打印  看效果
		*/
//			简写方式
			int len=0;
			while((len=fileInputStream.read(b))!=-1){
				System.out.println(new String(b,0,len));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(fileInputStream!=null)
				try {
					fileInputStream.close();
				} catch (Exception e) {
					//一般 可以throw RuntimeException异常。或者将异常信息写入到日志文件中进行记录
					e.printStackTrace();
				}
		}
	}
}
