package cn.myarraylist.domain;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 韦玉梅
 *
 */
public class ArrrayListDemo {
	/**
	* @param 向ArrayList中存储自定义对象 Person（name，age）
	* 思路
	* 1、描述：Person
	* 2.定义容器对象
	* 3、将Person对象存储到集合中
	*/
	public static void main(String[] args) {
//		创建ArrayList集合对象
		ArrayList array1 =new ArrayList();
		
		
//		添加Person类型的对象
		Person p1=new Person("张三",19);
		Person p2=new Person("王五",20);
		array1.add(p1);
		array1.add(p2);
		array1.add(new Person("王二",21));
		System.out.println(array1);
		
		
		System.out.println("-------------------------");
		for(Iterator iterator=array1.iterator();iterator.hasNext();){
//			iterator.next():取出的元素都有Object类型的
//			System.out.println(iterator.next());
			Person person= (Person) iterator.next();
			System.out.println(person);
			System.out.println("---------------");
			System.out.println(person.getName()+":"+person.getAge());
			
		}
		
//		取出元素
		
	}
}

class Person{
	private String name;
	private int age;
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
	/**
	 * 
	 */
	public Person() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}	
	
	
}
