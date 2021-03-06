package cn.mybuffer.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDemo {
	/**
	* @param args
	 * @throws IOException 
	*/	
	public static void main(String[] args) throws IOException {
	/*	  
//		需求：定义一个功能，记录程序运行的次数。满足5次后，给出提示，试用次数已到，请注册！
		思路：
		1、需要计数器
		2、计数器的值生命周期要比应用程序的周期要长，需要对计数器的值进行持久化
		3、count=1,里面存储的应该是键值方式，map集合，要和设备上的数据关联，需要IO技术
		集合+IO=Properties
	*/	
		boolean b=checkOut();
		if(b)
			run();
	}

	/**
	 * @return
	 * @throws IOException 
	 */
/*	
	public static boolean checkOut() {		
		int count=0;
		count++;
		System.out.println("count="+count);
		return false;
	}
	*/
	public static boolean checkOut() throws IOException {
		int count=0;
		boolean isRun=true;
//		1、将配置文件封装成File对象，因为要判断文件是否存在
		File configFile=new File("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\count.properties");
		if(!configFile.exists()){//如果不存在，就创建
			configFile.createNewFile();
		}
		Properties properties=new Properties();//用于存储配置文件中的数据
//		定义流对象
		FileInputStream fileInputStream= new FileInputStream(configFile);
//		将流中的数据加载到集合中
		properties.load(fileInputStream);
//		获取键对应的次数
		String value=properties.getProperty("count");
		if(value != null){
			count=Integer.parseInt(value);
			if (count>=5) {
				System.out.println("使用次数已到！");
				isRun=false;
			}
		}
		count++;//对取出的次数自增
//		将键count，和自增后的重新存储到集合中
		properties.setProperty("count", Integer.toString(count));
//		将集合中的数据存储到配置文件中
		FileOutputStream fileOutputStream=new FileOutputStream(configFile);
		properties.store(fileOutputStream, "");
		fileOutputStream.close();
		fileInputStream.close();
		return isRun;
	}
	public static void run(){
		System.out.println("软件运行！");
	}
}
