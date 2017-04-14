package stage3.htmlcss.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BeanFactory {
	private static Properties properties =new Properties();
	static{
//		1、读取配置文件
		try {
			properties.load(new FileInputStream("src/BeanFactory.properties"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static <T> T getBean( Class<T> c) throws IOException {	
		try {
			//2、取出哪个类
			String className=properties.getProperty(c.getSimpleName());
//			3、根据完整类名创建实例并返回
			Class<T> class1=(Class<T>)Class.forName(className);
			return class1.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
