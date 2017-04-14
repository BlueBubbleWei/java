package cn.network.demo;

import java.lang.reflect.Field;

public class ReflectFieldDemo {
	/**
	* @param args
	* 获取类中的成员
	* 反射字段
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	*/
	public static void main(String[] args) throws Exception {
		getField();
	}

	/**
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	private static void getField() throws Exception {
		String className="cn.network.demo.Person";
		Class class1=Class.forName(className);
		
		//获取age字段
		Field field1=class1.getField("age");//只能拿到公有的
		Field field2=class1.getDeclaredField("name");//能拿到公有和私有的，但是不包括继承的
		System.out.println(field1);
		System.out.println(field2);
		
		
//		要对非静态的字段操作必须有对象
		Object object=class1.newInstance();
//		使用父类的方法将访问权限检查能力取消
		field2.setAccessible(true);//暴力访问
		field2.set(object, "小王");
		System.out.println(field2.get(object));		
	}
}
