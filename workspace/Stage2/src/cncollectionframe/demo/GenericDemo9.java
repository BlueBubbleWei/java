package cncollectionframe.demo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo9 {
	/*
	演示泛型限定在api中的体现
	TreeSet的构造函数
	TreeSet(Collection <? extends E> collection);
	
	什么时候会用到下限呢？
	当从容器中取出元素操作时，可以用E类型接受，也可以用E的父类型接收
	*/
	public static void main(String[] args) {
//创建一个比较器
		Comparator<Person> comparator=new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				int temp=o1.getAge()-o2.getAge();
				return temp==0?o1.getName().compareTo(o2.getName()):temp;
			}
			
		};
		
		TreeSet<Student> students=new TreeSet<Student>(comparator);
		students.add(new Student("sdsd",24));
		students.add(new Student("sdsddd",12));
		students.add(new Student("123",56));
		
		TreeSet<Worker> student=new TreeSet<Worker>(comparator);
		student.add(new Worker("resd",24));
		student.add(new Worker("hnhsddd",12));
		student.add(new Worker("hn3",56));
		
		for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
			Person person = iterator.next();
			System.out.println(person.getName());
		}
	}
}

class YouTreeSet<E>{
	/**
	 * 
	 */
	public YouTreeSet(Comparator<? super E> comparator) {
		// TODO Auto-generated constructor stub
	}	
}
