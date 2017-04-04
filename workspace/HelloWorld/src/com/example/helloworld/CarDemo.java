package com.example.helloworld;

/*同学们在教室
同学  class Student{学习();}
教室 class Room{students(元素类型)=new Student[50];getStudent(index);setStudent(Student);};*/

/*描述事物中的属性和行为
类是由成员组成的
属性对应的就是类中的成员变量
行为对应的就是类中的成员方法*/


public class CarDemo {
	public static void main(String[] args){
	/*	定义该类的目的是为了定义主函数，让该类运行，让该类调用car类中的内容
		要想使用car类中的内容，必须先有car类的对象
		如何创建对象呢？通过new关键字完成*/
//		创建了一个Car类型的变量c指向了Car类型的对象 数据类型  变量名=初始值;   int x=4;
		
		Car c=new Car();
		new Car().num=4;
		new Car().run();
		c.num=5;
		c.color="Blue";
		c.run();//c是局部变量，定义在方法中的变量都是局部变量，栈里面存储的都是局部变量
		Person person= new Person();
//		person.age=24;
		person.talk();
	}
	public static void Show(Car car,int num){
		car.num=5;
		car.color="green";
		car.run();
	}
}


class Car{
	/*成员变量和局部变量的区别？
	1源代码中定义的位置不同
	成员变量定义在类中
	局部变量定义在方法中（只有是类的下一集大括号都是局部的)也可以定义在语句中
	2内存中的存储位置不同
	成员变量存储在堆内存中的对象中
	局部变量存储在栈内存的方法中
	3生命周期不同
	成员变量随着对象的出现而出现
	局部变量随着所属区间的运行出现，随着所属区间的结束释放*/
	
	int num;
	String color;//堆变量的初始值
	void run(){
		System.out.println(num+':'+color);
	}
}

/*描述人：
属性：年龄
行为：说话*/
class Person{
//	private 私有权限修饰符，访问权限就降低了
	private int age=9;
	void talk(){
		System.out.println("My age is"+ age);
	}
	public void setAge(int a){
//		可以对数据进行控制		
		age=a;
	}
	
	public int getAge(int a){
		return age;
	}
}

