package com.example.helloworld;

import java.security.PublicKey;

import android.provider.MediaStore.Images.Thumbnails;

/*一般函数与构造函数有什么区别？
 * 之前定义的函数都是一般的函数，用于描述事物应具备的功能
构造函数：也是功能，只不过这个功能有特殊，转嫩用于给对象初始化
构造函数在创建对象时就执行了，而且只执行一次
一般函数实在对象创建后，需要时才被对象调用，可以调用多次
格式：
1、函数名和类名相同
2、没有返回值类型
3、没有具体的返回值
*/

/*构造函数中有return语句吗？
有  用于结束初始化的
构造函数中可以调用方法
构造函数是可以私用化的，只在本了诶中使用
而且构造函数一旦私有化，其他程序就无法创建该类的独享，原因：无法对创建的对象初始化
*/
public class PersonDemo {
	public static void main(String[] args) {
	/*	创建一个对象的流程：
		1.加载制定的字节码文件进内存
		2.通过new在堆内存中开辟堆空间，分配首地址值
		3.对对象中的属性进行默认初始化
		4.调用与之对应的构造函数。构造函数压栈
		5.构造函数中执行隐式的语句super()访问父类中的构造函数
		6.对属性进行显示初始化
		7.调用类中的构造代码块
		8.执行构造函数中自定义的初始化代码
		9.初始化完毕，将地址赋值给指定的引用*/
		
		
		// 创造一个Personal对象。需求：描述事物符合现实生活，Personal对象一建立就有姓名和年龄
		// 相当于要对对象进行初始化，怎么来实现呢？Java中的构造函数就可以解决该问题

		/*当前new对象时，有没有构造函数啊？那这个对象怎么初始化的呢？
		注意1：定义的每一个类中，都有一个默认的空参数的构造函数
		注意2：一旦在类中自定义了构造函数，默认的构造参数就没了
		 有了构造方法以后（Personal(参数){},下面这句话就会报错，除非再自定义一个不带参的构造函数 */
		Personal personal = new Personal();
//		Personal p1 = new Personal("张三");
		Personal p2 = new Personal("李四", 46);
		personal.setName("Bubble");
		personal.setAge(20);
		personal.talk();
//		p1.talk();
		p2.talk();	
		
//		通过类名直接调static方法
		boolean b=p2.equals(personal);
		System.out.println("b="+b);
		
		/*既然sleep方法没有访问到对象中的特有数据
		都可以不需要对象就可以使用该方法，只要在该方法上用staitc修饰即可
		static:用于修饰成员的静态关键字
		
		什么时候函数需要静态修饰呢？
		该函数没有访问过对象的属性时，就需要用静态修饰
		*/
		
		Personal.sleep();
		Stranger s=new Stranger();
//		局部代码块
		{
//			局部代码块，可以控制局部变量的生命周期
			int x=3;
			System.out.println("x="+x);
		}
//		System.out.println("x="+x);
	}
	
}

class Personal {
	private String name;
	private int age;	
	
	/*静态关键字static
	是什么？
	成员修饰符
	有什么特点：
	 静态成员优先于对象存在
	 静态成员随着类的加载二加载，随着类的消失而消失。静态成员生命周期很长
	 
	 注意事项：
	 1、静态方法只能访问静态成员，不能访问非静态成员，这就是静态方法访问局限性
	 2、静态的方法中不能出现this或者super关键字
	 3、主函数是静态的
	 怎么用？
	 直接用于修饰成员
	 什么时候用 ？
	 成员变量：如果数据在所有对象中都是一样的，直接静态修饰
	 成员函数：如果函数中没有访问过对象中的属性数据，那么该函数就是静态的
	 
	*/
	
/*	成员变量和静态变量的区别？
	1、名称上的区别？
	成员变量也叫实例变量
	静态变量也叫类变量
	
	2.内存存储上的区别
	成语那边两存储到堆内存的对象中
	静态变量存储到方法区的静态区
	
	3、生命周期不同
	成员变量随着对象的出现而出现，随着对象的消失而消失
	静态变量随着类的出现而出现，随着类的消失而消失*/
	
	static String country="CN";//不再存放在堆内存里面，不再作为对象的属性，可以通过Personal.country使用
	// 定义一个构造函数，用于给Personal对象初始化
	// Personal对象初始化就可以有姓名

	Personal() {
	}
	
/*构造函数私有，只在本类中有效，该如何访问呢？
	注意1：构造函数只能被构造函数调用，不能直接被一般方法调用数
	构造函数之间该如何访问呢？通过关键字this来解决	
	this:代表的是对象。代表的是那个对象呢？哪个对象调用this所在的函数，this就代表哪个对象*/
	
	private Personal(String n) {
		if(n.length()<0){
			return;
		}else
		name = n;
		talk();
		return;//结束函数用的
	}

	Personal(String n, int age) {
		
/*		this 带上参数列表的方式就是可以范文本类中的其他构造函数
		比如：this("李四")：访问的就是本类中，带一个字符串参数的构造函数
		记住：用于调用构造函数的this语句必须定义在构造函数第一行，因为初始化动作要先执行
		*
		*总结：只要直接被对象调用的方法都持有this引用（凡是访问了对象中数据的方法都持有this引用）
		*/
		
		this(n);
		name = n;
		
//		当成员变量和局部变量同名时，可以通过this关键字区分
		
		this.age = age;
	}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setAge(int n) {
		age = n;
	}

	public int getAge() {
		return age;
	}
	
	public boolean equalsAge(Personal p){
		if(p.age==this.age)
			return true;
		else {
			return false;
		}
	}

	public void talk() {
		System.out.println("Your name is" + name + "\n" + "your age is" + age);
	}
	
//	可以通过类名直接访问
	/*如果创建的对象没有调用sleep方法，发现sleep并没有使用对象中的数据，该对象的建立是没有意义的
	该方法所属于Personal.class
	可以通过类名的方式来访问
	注意：用类名直 接调用的方法必须通过修饰符来修饰，就是关键字 static*/
	public static void sleep(){
		System.out.println("Good night!");
	}
}


//静态代码块:随着类的加载而执行，而且只执行一次
//作用：给类初始化的
//应用场景：类不需要创建对象，但是需要初始化，这是将部分代码存储到静态代码中 
class Stranger{
	private int age;
	
//	当所有的构造函数中都使用相同的方法时，将其放入到代码块里面
	Stranger() {
		cry();
	}
	Stranger(int age) {
		this.age=age;
		cry();
	}
//	构造代码块，给所有对象进行初始化，构造函数只给对应的对象初始化
	{
		cry();
		System.out.println("This class is going to be runing.");
	}
	static{
//		静态代码块
		System.out.println("A");
	}
		
	/*1、super;//调用父类构造函数
	2、显示初始化
	3、构造代码块初始化*/
	
	static void show(){
		System.out.println("show run!");
	}
	public void cry(){
		System.out.println("shutup");
	}
}
