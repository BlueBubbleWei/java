package cn.inprint.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccesFileDemo {
	/**
	* @param args
	* RandomAccessFile
	* 特点：1、只能操作文件
	* 2、既能读，又能写
	* 3、维护了一个byte数组，内部定义了字节流的读取和写入
	* 4、通过对指针的操作可以实现对文件的任意位置的读取和写入
	* 功能：getFilePointer  用于操作文件指针的方法
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
//		writeFile();
		readFile();
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void readFile() throws IOException {
		RandomAccessFile randomAccessFile=new RandomAccessFile("obj.txt", "r");
		byte[] buf=new byte[8];
		randomAccessFile.read(buf);
		String name= new String(buf);
		
		int age=randomAccessFile.readInt();
		System.out.println(name+":"+age);
		randomAccessFile.close();
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void writeFile() throws IOException {
//		创建一个随机访问文件的对象，文件不存在，则创建，若不存在，即不创建也不覆盖
		RandomAccessFile randomAccessFile=new RandomAccessFile("obj.txt", "rw");
		
		
		randomAccessFile.seek(8);//设置指针的位置 从此处开始写入数据
//		随机写入	写入姓名和年龄
		System.out.println(randomAccessFile.getFilePointer());
		randomAccessFile.write("小王八".getBytes());
		randomAccessFile.write(97);
		randomAccessFile.writeInt(45);//writeInt保证整数的字节原样性
		
		randomAccessFile.close();
	}
}
