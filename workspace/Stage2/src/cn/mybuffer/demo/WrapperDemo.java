package cn.mybuffer.demo;


public class WrapperDemo {
	/**
	* @param args
	*/
	public static void main(String[] args) {
		Person person=new Person();
		NewPerson child=new NewPerson(person);
		child.eat();
		System.out.println("-----------------");
		Men men=new Men();
		men.eat();
		SubMan subMan=new SubMan();
		subMan.eat();
		System.out.println("--------------------");
		NewPerson newPerson=new NewPerson(men);
		newPerson.eat();
	}
}


class Person{
	void eat(){
		System.out.println("吃饭");
	}
}
/*
class SubPerson extends Person{
	void eat(){
		System.out.println("开胃菜");
		super.eat();
		System.out.println("甜点");
	}
}
*/

class NewPerson extends Person{
	private Person person;
	/**
	 * 
	 */
	public NewPerson(Person p) {
		this.person=p;
	}
	void eat(){
		System.out.println("开胃菜");
		person.eat();
		System.out.println("甜点");
	}
}

class Men extends Person{
	void eat(){
		System.out.println("喝酒！");
	}
}

class SubMan extends Men{
	void eat(){
		System.out.println("开胃菜");
		super.eat();
		System.out.println("甜点");
	}
}