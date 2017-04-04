package cncollectionframe.demo;

public class Person implements Comparable<Person> { 
	private String name;
	private int age;
		
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
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
	public int compareTo(Person o) {
		int temp=this.age=o.age;
		
		return temp==0?this.name.compareTo(o.name):temp;
	}
	/**
	* @param args
	*/

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
	final int NUMBER=38;
	return this.name.hashCode()+age*NUMBER;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(!(obj instanceof Person)){
			throw new ClassCastException();
		}
		Person person=(Person)obj;
		return this.name.equals(person.name) && this.age== person.age;
	}
}
