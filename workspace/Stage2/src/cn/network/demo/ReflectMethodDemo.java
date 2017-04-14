package cn.network.demo;
import java.lang.reflect.Method;

public class ReflectMethodDemo {
	/**
	* @param args
	 * @throws Exception 
	*/
	public static void main(String[] args) throws Exception {
//		getMethodDemo();
		getMethodDemo2();
		getMethodDemo3();
		
	}

	/**
	 * 
	 */
	private static void getMethodDemo3() throws Exception{
		String className="cn.network.demo.Person";
		Class class1=Class.forName(className);
		Method method=class1.getMethod("paramShow", String.class,int.class);
		Object object=class1.newInstance();
		method.invoke(object,"张三",30);
	}

	/**
	 * 反射方法，静态，无参数的show方法
	 */
	private static void getMethodDemo2() throws Exception{
		String className="cn.network.demo.Person";
		Class class1=Class.forName(className);
		Method method=class1.getMethod("staticShow", null);
		method.invoke(null, null);
	}

	/**
	 * @throws Exception 
	 * 
	 */
	private static void getMethodDemo() throws Exception {
		String className="cn.network.demo.Person";
		Class class1=Class.forName(className);
		
//		反射方法  非静态，无参数的show方法
		Method method=class1.getMethod("show", null);
		Object object=class1.newInstance();
		method.invoke(object, null);
	}
}
