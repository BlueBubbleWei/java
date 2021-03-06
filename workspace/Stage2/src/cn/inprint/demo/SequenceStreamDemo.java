package cn.inprint.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.sound.midi.Sequence;

public class SequenceStreamDemo {
	/**
	* @param args
	* 序列流
	* 特点：流对象的有序排列
	* 解决问题：将多个输入流合并成一个输入流。将多个源合并成一个源，对于多源的操作会变得简单
	* 功能：特殊之处在构造函数上，一初始化就合并了多个流进来
	* 
	* 使用场景之一：对多个文件进行数据的合并。多个源对应一个项目
	* 
	* 演示序列流
	* 如何获取一个 Enumeriation呢？Vector有，但是效率低，使用ArrayList
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		ArrayList<FileInputStream> a1=new ArrayList<FileInputStream>();
		for(int x=0;x<=3;x++){
			a1.add(new FileInputStream("D:\\java\\workspace\\Stage2\\src\\cn\\inprint\\demo\\tempfile\\"+x+".txt"));
		}
//		a1.add(new FileInputStream("D:\\java\\workspace\\Stage2\\src\\cn\\inprint\\demo\\tempfile\\1.txt"));
		
//		怎么通过ArrayList获取枚举接口，可以使用Collections工具类中的方法
		Enumeration<FileInputStream> enumeration=Collections.enumeration(a1);
		SequenceInputStream s1=new SequenceInputStream(enumeration);
		
//		创建目录、文件
		FileOutputStream fileOutputStream=new FileOutputStream("D:\\java\\workspace\\Stage2\\src\\cn\\inprint\\demo\\tempfile\\4.txt");
		
//		频繁的读写操作
//		创建缓冲区
		byte[] buf=new byte[124];
		int len=0;
		while((len=s1.read())!=-1){
			fileOutputStream.write(buf,0,len);
		}
		fileOutputStream.close();
		s1.close();//能把它所包含的集合内的流都关掉
	}
}
