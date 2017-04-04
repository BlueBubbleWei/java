package com.example.helloworld;
/*面向对象
设计模式：解决某一种问题的一种思想，是一种行之有效的解决方式
23种设计模式
单例设计模式
解决的问题：保证一个类的对象在内存中的唯一性
应用场景：多个程序都在操作同一个配置文件的时间，需要程序A操作的后果
程序B要知道并继续基于A操作后的结果进行操作
前提，数据都存储在配置文件对象中，要求程序A和程序BC啊哦做的配置文件对象是同一个*/

/*怎么实现？怎么可以保证这个类只能产生一个对象呢？
思路：
1、问题是其他程序都可以通过new创建该类的对象，无法控制数量
2。那第一步的问题也产生了，那其他程序不就没有对象了吗？
干脆，在本类中自己new一个本类对象，这样的好处是，不让别的程序new，自己new，也可以实现数量的控制
3、对外提供让其他程序获取该对象的方式

步骤：
1、不让其他程序new该类对象，咋办？
可以将该类中的构造函数私有化
2、在本类中new一个对象
3.定义一个方法返回该对象*/
public class Thinking {
	public static void main(String[] args) {
		// Single s1=Single.getInstance();
		// Single s2=Single.getInstance();
		Single s1 = Single.s;
		Single s2 = Single.s;
		System.out.println(s1 == s2);
		Single s3= new Single("Bubble");
	}
}

/*子父类中的方法的特点
特殊情况：
当子父类中出现一模一样的方法时
子类对象运行的是子类的方法
这种特殊的情况，称之为覆盖override，复写，重写
父类已定义的功能，子类可以直接使用
但是子类对功能的内容要有自己的定义，建立子类功能特有的内容：覆盖的应用*/


/*当子父类中出现了同名的成员变量，用关键字super来区分
super和this的用法很像素
this：代表的是本类的对象引用
super:代表的是父类那片空间*/

class People{
	private String marriage="none";//子类具备这个属性，但是对于父类中的私有部分，子类没有访问权限，且需重新声明
	String sex;
	int age;
	People() {
		// TODO Auto-generated constructor stub
		System.out.println("go away");
	}
	People(String name) {
		// TODO Auto-generated constructor stub
		System.out.println("name="+name);
	}
	void walk(){
		System.out.println("People");
	}
}
/*继承
1、提高了代码的复用性
2、让类与类之间产生了关系

Java支持单继承，不直接支持多继承
多继承：一个类可以有多个父类，Java并不直接支持
优势：可以让子类具备更多的功能
弊端：调用的不确定性，因为方法的主体不同，java对其进行改良
什么时候定义继承？
当事物之间存在着所属（is a)关系时，可以通过继承来体现这个关系
x是y的一种，x extends y


覆盖使用的注意事项：
子类方法覆盖父类方法，必须保证权限大于父类权限
静态只能覆盖静态，或者被静态覆盖
静态方法时不属于对象的，它是属于类的
*/

/*子父类总构造函数的特点：
就会发现，创建子类对象时，父类中的空构造函数也会运行
因为子类中所有的构造函数的第一行都默认有一个super();方法
调用本类中的构造函数用this（实参列表）语句，调用父类中的构造函数用super(实参列表)

*为什么子类对象初始化都要访问父类中的构造函数呢？
*因为子类继承了父类中的内容，所以创建对象时必须要看父类是如何对内容进行初始化的
*这就是子类的实例化过程
*
*注意：当父类中没有空参数构造函数时，子类需要通过显示定义super语句制定要访问的父类中的构造函数
*注意：用来调用父类构造函数的super语句在子类构造函数中必须定义自第一行，因为弗雷德初始化要先完成
*
*问题：
*1、this和super用于调用构造函数，可以同时存在吗？
*不可以   因为它们只能定义在第一行
*为什么需要定义在第一行？
*因为初始化动作要先执行。
*/
class Single extends People {
	private String name="df";
	Single(){
		System.out.println("Single");
	}
	Single(String name) {		
		super("Blues");//显示指定的super的方式俩访问父类中的构造函数
//		this();//有了this一句，就没有super语句，二者不能共存,this也可以初始化父类
		System.out.println("name="+name);
	}
//	String marriage="none";
	{
		walk();
		System.out.println("marriage="+age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 创建一个本类对象
	static Single s = new Single();

	/*// 构造函数私有化
	private Single() {
	};*/

	// 定义一个方法返回该对象，让其他程序可以获取到，之所以定义访问，就是为了可控
	public static Single getInstance() {
		return s;
	}
void walk(){
	super.walk();//和父类同名的方法，使用时加super，防止死循环
		System.out.println("go back");
	}
}

/*
 * 类的延迟加载形式，在引用到类时再创建对象
 *  class Single{ 
 *  	private Single s=null;
 *   private Single(){}
 * public static Single getInstance(){
	 *  if(s==null){ 
	 *  	s=new Single(); 
	 *  } 
	 *  return s;
	 * } 
 * }
 */

/*//final关键字  能修饰类，修饰方法，修饰变量
//加上final关键字，这个类就不能再有子类，final修饰的类不可以被继承
 * final修饰的方法不能被覆盖
 * final修饰的变量是常量，只能赋值一次
 * 当使用的数据不变时，需要定义阅读性强的名称来表示该数据，并将该数据final化
 * 被final修饰的变量   名称规范是：所有字母都大写，如果由多个单词组成，需要通过_进行分隔
final class Fu{
	
}
class zi extends Fu{
	
}*/

 
