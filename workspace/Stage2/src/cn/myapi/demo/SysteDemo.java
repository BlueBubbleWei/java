package cn.myapi.demo;

import java.util.Properties;
import java.util.Set;

public class SysteDemo {
	private static final String FILE_SEPARATOR=System.getProperty("file.separator");
	private static final String LINE_SEPARATOR=System.getProperty("line.separator");
	public static void main(String[] args) {
	/*	
		System:全是静态的行为和属性
		属性：
		out：标准输出流，默认对应设备显示器
		in：标准输入流，默认的设备键盘
	*/	
		long time= System.currentTimeMillis();
//		System.out.println(time);
		
//		System getProperties(); 获取到系统的信息都存储到Properties键值集合中了
		Properties properties =System.getProperties();
		
//		如何去除属性集？
		Set<String> set =properties.stringPropertyNames();
		
		for(String key :set){
			String value=properties.getProperty(key);
//			System.out.println(key+":"+value);
		}
//		System.out.println(System.getProperty("os.name")+"ssssssssssssssssss");
		
		System.out.println("C:"+FILE_SEPARATOR+"abc"+FILE_SEPARATOR+"1.txt");//会变成文件路径
		System.out.println("hello "+LINE_SEPARATOR+"world!");//会分割换行
	}
}
