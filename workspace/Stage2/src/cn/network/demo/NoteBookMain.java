package cn.network.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class NoteBookMain {
	/**
	* @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	*/
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		NoteBook book=new NoteBook();
		book.run();
		book.useUSB(null);
		
	/*	
		因为有了鼠标，所以需要在源程序中。创建鼠标对象并传到笔记本
		希望后期出现了设备以后，可不可以不用修改NoteMain的代码，还可以不断地加入新的设备		
		book.useUSB(new MouseByUSB());
	*/
//		对外提供配置文件
		File configFile=new File("usb.properties");
		if(!configFile.exists()){
			configFile.createNewFile();
		}
//		读取流和配置文件关联
		FileInputStream inputStream=new FileInputStream(configFile);
		Properties properties=new Properties();
//		将流中的数据加载到properties
		properties.load(inputStream);
		
		for (int i = 0; i < properties.size(); i++) {
			String className=properties.getProperty("usb"+i);
			
//			对指定的类进行加载
			Class class1=Class.forName(className);
			USB usb=(USB) class1.newInstance();
			book.useUSB(usb);
		}
	}
}
