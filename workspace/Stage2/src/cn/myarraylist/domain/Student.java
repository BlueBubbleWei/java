package cn.myarraylist.domain;

import javax.print.attribute.standard.Copies;

public class Student implements Comparable{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Student() {
		
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
//	覆盖hasCode()，根据对象的特点定义哈希值
	@Override
	public int hashCode() {
//		System.out.println("123");
//		return this.age;
		return name.hashCode();
	}
	
	@Override
//	需要定义自身判断自身相同的依据，需要覆盖equals方法
	public boolean equals(Object object) {
		System.out.println(this+"\t"+object);
		if(this==object)
			return true;
		
		if(! (object instanceof Student)){
			throw new ClassCastException("类型错误");
		}
		
		Student student=(Student)object;
		if(name.equals(student.name)){
			return true ;
		}else{
			if(this.age == student.age){
				return true ;
			}
		}
		return false ;
	}
	@Override
	/*
	学生就具备了比较的功能，该功能是自然排序使用的方法
	自然排序就年龄的升序排序为主
	*/
	public int compareTo(Object o) {
		/*Student student=(Student) o;
		if(this.age>student.age)
			return 1;
		if(this.age<student.age)
			return -1;
		return 0;*/
		
		/*return 1;*/
		/*
		既然是同姓名同年龄是同一个人，视为重复元素，要判断的要素有两个
		既然是按照年龄进行排序，所以先判断年龄，再判断姓名*/
		Student student=(Student) o;
		int temp=this.age-student.age;
		return temp==0?this.name.compareTo(student.name):temp;
	}
}
