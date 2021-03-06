package cn.inprint.demo;

import java.io.Serializable;
/*
	Person类的对象如果需要序列化，就需要Serilizable标记接口
	该接口给需要需要序列化的类，提供了一个序列版本号 serialVersionUID"
	该版本号的目的在于验证序列化对象的发送者和接收者是否为该对象加载了与序列化兼容的类
*/
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
//	private int age;
	private transient int age;   //transident 瞬态，使用完马上消失
	
	public Person() {
		super();
	}
	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
