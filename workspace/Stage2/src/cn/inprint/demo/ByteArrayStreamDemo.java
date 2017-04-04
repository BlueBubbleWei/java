package cn.inprint.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {
	/**
	* @param args
	*/
	public static void main(String[] args) {
//		用IO的读写思想操作数组
//		确定源
		ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream("abcde".getBytes());
		ByteArrayOutputStream byArrayOutputStream=new ByteArrayOutputStream();
//		确定目的。内置一个byte数组
		int by=0;
		while((by=byteArrayInputStream.read())!=-1){
			byArrayOutputStream.write(by);
		}
		System.out.println(byArrayOutputStream.toString());
	}
}
