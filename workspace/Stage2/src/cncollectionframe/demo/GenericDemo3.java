package cncollectionframe.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GenericDemo3 {
	public static void main(String[] args) {
		Set<String> set =new TreeSet<String>();	
//		Set<Person> set2 =new TreeSet<Person>();	
		Set<Person> set2=new HashSet<Person>();//重写hasCode()方法和equals()方法去冗
		set.add("23");
		set.add("forjf");
		set.add("asds");
		set2.add(new Person("sdfs",39));
		set2.add(new Person("seres",32));
		set2.add(new Person("adsdfs",13));
		set2.add(new Person("sdfs",39));
		set.add(set2.toString());
		for(String s:set){
			System.out.println(s);
		}
		
		for(Person s:set2){
			System.out.println(s);
		}
	}	
}
