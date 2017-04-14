package cn.network.demo;

public class ReflectDemo {
	/**
	* @param args
	* 反射技术：动态的获取类以及类中的成员，并可以调用该类成员
	* 以前是有什么类，就new什么对象。没有类，给什么类就创建什么对象
	* 
	* 无论new什么对象，都需要先获取字节码文件
	* 如何获取呢？发现java已对字节码文件进行了描述用的class类完成的
	* 
	* 如何获取一个字节码文件的对象呢？
	* 方式一： Object getClass()方法
	* 
	* 方式二：所有的数据类型都有自己对对应的class对象。表示方式很简单
	* 每一个数据类型都有一个默认的静态的属性。.class 用该属性就可以获取到自字节码文件对象
	* 虽然不用对象调用了，还是要用到具体的类调用静态属性
	* 
	* 方式三：在Class类中找到了forName方法，通过名称就可以获取对应的字节码文件对象
	 * @throws ClassNotFoundException 
	*/
	public static void main(String[] args) throws ClassNotFoundException {
//		methodDemo_1();
//		methodDemo_2();
		methodDemo_3();
	}
	
/**
 * @throws ClassNotFoundException 
	 * 
	 */
	private static void methodDemo_3() throws ClassNotFoundException {
		String className="cn.network.demo.Person";//一定要传对类名，要完整版！
		Class class1=Class.forName(className);
		System.out.println(class1);
	}

/**
	 * 
	 */
	private static void methodDemo_2() {
		Class class1=Person.class;
//		int.class
		Class class2=Person.class;
		System.out.println(class1==class2);
	}

//	获取class独享的方式一
	public static void  methodDemo_1() {
//		调用getclass先有对象
		Person person1=new Person();
		Person person2=new Person();
		
		Class class1=person1.getClass();
		Class class2=person2.getClass();
		System.out.println(class1);
		System.out.println(class1==class2);//两个类相同
	}
}
