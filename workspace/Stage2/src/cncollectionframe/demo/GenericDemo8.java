package cncollectionframe.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo8 {
	public static void main(String[] args) {
		/*
		演示泛型限定在api中的体现
		TreeSet的构造函数
		TreeSet(Collection <? extends E> collection);
		什么时候会用到上限呢？
		一般往集合存储元素时，如果集合 定义了E类型通常情况下应该存储E类型的对象
		对E的子类型的对象E类型也可以接受，所以这是可以将泛型从E改为 ？ extends E
		
		什么时候会用到下限呢？
		*/
		
		
		/*Collection collection=new ArrayList();
		collection.add("1223");
		collection.add("asss");*/
		
		Collection<Student> collection=new ArrayList<Student>();		
		collection.add(new Student("sdsd",24));
		collection.add(new Student("sdsddd",12));
		collection.add(new Student("123",56));
		
//		TreeSet treeSet=new TreeSet<>();
//		treeSet.add("wei");
		TreeSet<Integer> treeSet=new TreeSet<Integer>();
		treeSet.add(123);
		
		TreeSet<Person> treeSet2=new TreeSet<Person>(collection);
		treeSet2.add(new Person("Bubble",23));
		treeSet2.add(new Worker("Bubble",23));
		
		
		for (Iterator<Person> iterator = treeSet2.iterator(); iterator.hasNext();) {
			Person person = iterator.next();
			System.out.println(person.getName());
		}
	}
}
class MyTreeSet<E>{
	public MyTreeSet() {
		
	}
	/*和下面的方法相同
	public MyTreeSet(Collection collection) {
		
	}
	*/
	public MyTreeSet(Collection<? extends E> collection) {
		
	}
}





