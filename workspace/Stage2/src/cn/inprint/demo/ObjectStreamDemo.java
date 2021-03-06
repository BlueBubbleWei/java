package cn.inprint.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectStreamDemo {
	/**
	* @param args
	* 用于操作对象的流对象，对象的序列化
	* ObjectInputStream  ObjectOutputStream
	* 特点：用于操作对象
	* 解决问题：可以将对象进行序列化和反序列化。注意：对象序列化一定要实现Serializable接口，为了给类定义一个serialVersionUID
	* 功能：ObjectInputStream  readObject()  ObjectOutputStream  writeObject()
	* 关键字：瞬态：transient
	* 
	* 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	*/
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeObj();
		readObj();
	}

	/**
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	private static void readObj() throws ClassNotFoundException, IOException {
//		定义流对象关联存储了对象文件
		FileInputStream fileInputStream=new FileInputStream("obj.txt");
//		建立用于读取对象的功能对象
		ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		Person object=(Person)objectInputStream.readObject();
		System.out.println(object.toString());
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void writeObj() throws IOException {
		File file=new File("obj.txt");
		if(!file.exists()){
			System.out.println(123);
			file.createNewFile();
		}
//		明确存储对象的文件
		FileOutputStream fileOutputStream=new FileOutputStream("obj.txt");
//		给操作文件对象加入写入对象的功能
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
//		调用了写入对象的方法
		objectOutputStream.writeObject(new Person("大黑",1));
		objectOutputStream.close();
	}
}
