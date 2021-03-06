package cn.mybuffer.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
	/**
	* @param 演示properties的特有方法
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
//		methodDemo();
//		methodDemo2();
		methodDemo3();
	}

	/**
	 * @throws IOException 
	 * 
	 */
	private static void methodDemo3() throws IOException {
		File configFile=new File("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\info.properties");
//		读取流中的数据
		Properties properties=new Properties();
//		定义读取流和数据文件关联
		FileInputStream fileInputStream=new FileInputStream(configFile);
		properties.load(fileInputStream);
		properties.setProperty("向往", "45");
//		要将改完的数据持久化
		FileOutputStream fileOutputStream=new FileOutputStream(configFile);
		properties.store(fileOutputStream, "");
		fileOutputStream.close();
		
	}

	private static void methodDemo2() throws IOException {

		Properties properties=new Properties();
		properties.setProperty("张三", "25");
		properties.setProperty("李四", "20");
		properties.setProperty("王五", "30");
//		将集合中的数据持久化存储到设备上
//		需要输出流对象
		FileOutputStream fileOutputStream=new FileOutputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\info.properties");
//		使用properties的store方法
		properties.store(fileOutputStream, "mydemoo,personinfo");
		fileOutputStream.close();
	}

	private static void methodDemo() {

//		Properties的基本存取
//		创建一个properties
		Properties properties=new Properties();
		properties.setProperty("张三", "25");
		properties.setProperty("李四", "20");
		properties.setProperty("王五", "30");
		
		/*Set<String> set=properties.stringPropertyNames();
		for (String name : set) {
			String value=properties.getProperty(name);
			System.out.println(name+"\t"+value);
		}*/
		
		properties.list(System.out);
	}
}
