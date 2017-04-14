package cn.network.demo;

public class Person {
	private String name;
	public int age;
	
	/*public Person() {
		super();
		System.out.println("I'm person.");
	}*/

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
	
	public void show() {
		System.out.println("Person show run!");
	}
	
	public static void  staticShow() {
		System.out.println("staticShow run!");
	}
	
	public static void paramShow(String name,int age) {
		System.out.println("show"+name+"-----"+age);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
