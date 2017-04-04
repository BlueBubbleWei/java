package cncollectionframe.demo;

public class Worker extends Person {

	@Override
	public String toString() {
		return "Worker [getName()=" + getName() + ", getAge()=" + getAge() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

	public Worker() {
		super();
	}

	public Worker(String name, int age) {
		super(name, age);
	}

	
}
