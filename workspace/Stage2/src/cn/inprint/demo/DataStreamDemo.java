package cn.inprint.demo;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {
	/**
	* @param args
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		writeData();
		readData();
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void readData() throws IOException {
		FileInputStream fileInputStream=new FileInputStream("obj.txt");
		DataInputStream dataInputStream=new DataInputStream(fileInputStream);
		
		boolean b=dataInputStream.readBoolean();
		System.out.println(b);
		dataInputStream.close();
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void writeData() throws IOException {
//		写入一些基本的数据值，存储到文件
		FileOutputStream fileOutputStream=new FileOutputStream("obj.txt");
		DataOutputStream dataOutputStream=new DataOutputStream(fileOutputStream);
		dataOutputStream.writeBoolean(true);
		dataOutputStream.writeInt(1234);
		dataOutputStream.close();
	}
}
