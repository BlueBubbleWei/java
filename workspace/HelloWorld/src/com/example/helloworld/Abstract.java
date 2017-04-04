package com.example.helloworld;

public class Abstract {
	public static void main(String[] args) {
		Factory f = new Factory();
		f.show();
	}
}

/*
 * 描述
 *  狗：吼叫 
 *  狼：吼叫
 *   两个事物具备共性，向上抽去，
 *   犬科，具备吼叫功能
 * 
 * 描述一个事物，却没有足够信息，这时就将这个事物成为抽象事物 面对抽象的事物，虽然不具体，但是可以简单化 不用面对具体事物
 *
 * 特点： 1.抽象方法一定定义在抽象勒种，都需要用abstract来修饰 抽象类不能实例化，不能用new关键字创建对象
 * 只有子类覆盖了所有的抽象方法后，子类具体化，子类就可以创建对象 如果没有覆盖所有的抽象方法，那么子类还是一个抽象类
 *
 * 抽象类也是不断地向上抽取而来的，抽取了方法的声明而不确定具体的方法内容 由不同的子类来完成具体的方法的内容
 *
 *
 * 问题： 抽象类中有构造函数吗？
 *  有，抽象类的构造函数虽然不能给抽象类对象实例化，因为抽象类不能创建对象
 * 但是抽象类有子类，她的构造函数可以让自乐的对象实例化
 *
 * 抽象类和一般类的异同点？ 
 * 相同：都用来面熟事物，都可以进行属性和行为的描述
 *  不同：抽象类描述事物的信息不具体。一般类描述事物的信息具体
 * 代码的不同：抽象类可以定义抽象方法，一般类不行 抽象类不可以实例化，一般类可以
 *
 * 抽象类一定是一个父类吗？
 *  是的。必须需要自雷覆盖抽象方法后，才可以实例化，使用这些方法
 *
 * 抽象类中可以不定义抽象方法吗？ 可以的。仅仅是让该类不能创建对象
 *
 * 抽象关键字abstract和哪些关键字不能共存呢？ 
 * final 修饰的类不能有子类 
 * abstract  类的实例化必须依靠子类 
 * private   如果抽象父类私有化，子类不能修改父类的方法，必须重写 static 静态类不能创建对象，直接通过类名调用方法，而抽象类通过类名调用方法没有意义
 */

/*
 * 需求：公司中程序员有姓名，工号，薪水，还有奖金，工作内容 对给出需求进行数据建模 分析：
 * 问题领域中：
 *  程序员
 *   属性：姓名，工号，薪水 
 *  行为：工作内容
 * 项目经理
 *  属性：姓名，工号，薪水，还有奖金 
 *  行为：工作内容
 * 
 * 两者不存在所属关系，但是有共性内容，可以向上抽取 两者的共性类型是什么？
 * 雇员
 *  雇员： 属性：姓名，工号，薪水
 *   行为：工作
 */

class Employee {
	private String name;
	private String id;
	private double salary;

	Employee(String name, String id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
}

// 描述程序员
class Programmer extends Employee {

	Programmer(String name, String id, double salary) {
		super(name, id, salary);
	}

	public void work() {
		System.out.println("coder");
	}
}

// 描述经理
class Manger extends Employee {
	// 特有属性 奖金
	private double bonus;

	Manger(String name, String id, double salary, double bonus) {
		super(name, id, salary);
		this.bonus = bonus;

	}

}

/*
 * 抽象类中的所有方法都是抽象的 这时，可以把抽象类用另一种形式来表示。
 * 接口 初期可以理解为 接口是特殊的 
 * 接口的特点： 
 * 1、接口不可以实例化
 * 2、需要覆盖了的接口中的所有的抽象方法的子类，才可以实例化 否则，该类还是一个抽象类 
 * 3、接口是用来被实现的 类与类之间的关系 继承关系
 * 类与接口之间的关系是实现关系 接口与接口之间是 继承关系
 * 
 * 接口的好处或者解决了什么问题？ 
 * 多继承：
 * 好处：可以让子类具备更多的功能 弊端：调用的不确定性
 */

/*
 * 接口的思想：
 * 笔记本地懊恼的USB的接口
 * 1、接口的出现扩展了功能
 * 2、接口其实就是暴露出来的规则
 * 3、接口的出现降低了耦合性，解耦
 * */
//接口的出现，一方在使用接口，一方在实现接口
class Mouse{
	
}
interface USB{
	
}

class NewMouse extends Mouse implements USB{
	
}

// 定义接口

interface Inter1 {
	/*
	 * 接口中的成员和class定义的不同之处 接口中常见的成员有两种：1、全局常量 2、抽象方法 而且都有固定的修饰符，共性：成员都是public修饰的
	 */
	public static final int NUM = 4;

	public abstract void show();

	public abstract void show1();
}

interface Inter2 {
	public abstract void show();

	public abstract void show2();
}

interface Inter3 extends Inter1, Inter2 {
	void show3();
}

/*
 * 因为继承Factory具备所属的体系具备了该体系的基本功能 还想扩展一些功能，具备show2()的功能 一个类继承一个类的同时，还可以实现多个接口
 * 避免了单继承的局限性 继承是为了获取体系的基本功能，想要扩展功能可以通过实现接口来完成
 */

// 接口与接口 之间是继承关系，而且是多继承
class Factory implements Inter1, Inter2 {
	// 为了实现接口Inter1和接口Inter2，必须将抽象类中的所有方法都实现
	// @覆盖掉父类
	public void show() {
		System.out.println("123");

	}

	public void show1() {
	}

	public void show2() {
	}

}

class Worker {
	// 必须实现三个接口中的所有方法
	public void show1() {
	}

	public void show2() {
	}

	public void show3() {
	}
}

/*//DemoA和DemoB为了实现接口Inter1.必须实现Inter1下所有的方法，下面以建立空类初始化其方法来实现接口
class DemoA implements Inter1 {
	public void show1() {
		System.out.println("方法");
	}

	public void show() {
	}
}

class DemoB implements Inter1 {
	public void show1() {
		System.out.println("方法一");
	}

	public void show() {

	}
}*/

/*
 * 为了方便创建Inter1接口的子类对象 可以用一个类先把接口中的所偶遇方法都空实现，该类创建的独享没有意义，所以可以将该类抽象
 */

//没有抽象方法的抽象类
abstract class Demo implements Inter1 {
	Demo() { 
		
	}

	public void show() {

	}

	public void show1() {

	}
}

class DemoA extends Demo{
	public void show() {

	}
}
class DemoB extends Demo{
	public void show() {

	}
}


//抽象类与接口
//例子：
abstract class 犬{
	abstract void 吃();
	abstract void 叫();
}

/*interface 犬{
	abstract void 吃();
	abstract void 叫();
}*/

//添加一个功能。缉毒：单独描述一个缉毒功能犬

class 缉毒犬 extends 犬{
	void 吃() {}
	void 叫() {}	
}

/*class 缉毒犬 implements 犬{
	void 吃() {}
	void 叫() {}	
}
*/
//缉毒犬是犬中的一种是  is a 的关系
//犬用于描述所有功能犬的基本功能，用class定义。父类
//所以犬不适合定义成接口

class 缉毒猪{
	void 缉毒(){}
}
/*具备缉毒功能的有很多，缉毒功能需要抽取，抽取到类中，还是抽取到接口中？
都试一下。先定义成类
abstract class 缉毒{
	abstract void 缉毒();
}
不行，因为缉毒犬继承缉毒类就不能继承其他类。因为累不能多继承

定义成接口试试*/
interface 缉毒{
	abstract void 缉毒();
}

/*class 缉毒犬 extends 犬 implements 缉毒{
	
}*/
/*这是可行的
类用于描述的是事物的共性基本功能
接口用于定义的都是事物的额外功能

*抽象类和接口的区别？
*1、类与类之间是集成的关系  is a
*类与接口是实现关系    like a
*
*2、抽象类中可以定义抽象和非抽象方法，子类可以直接使用，或者覆盖使用
*接口中定义的都是抽象方法，必须实现才能用
*/


/*多态：多种形态
 * 重点说的是：对象的多样性
 * 
 * */

class 动物{
	
}
class 狗 extends 动物{
	
}
/*狗  x= new 狗();
动物  x = new 狗();//狗实例即是狗类型，又是动物类型。多态性
多态在程序中的体现：父类的引用或者接口的引用指向了子类的对象

多态在程序中的体现：父类的引用或者接口的引用指向了子类的对象
多态的好处：提高了代码的扩展性

多态的弊端：不能使用子类的特有方法

多态的前提：
必须有关系，继承，实现
2.通常有覆盖
*/

abstract class Animal{
	abstract void eat();
}
class Dog extends Animal{
	void eat() {		
		System.out.println(" Eat.");
	}
}
/*调用是
 Animal a= new Dog();向上转型  左边是父类型。向上转型的好处，吟唱了子类型，提高了代码的扩展性
弊端：只能使用父类中的功能，不能使用子类特有的功能，功能被限定了
如果不需要面对子类型，通过提高扩展性，或者使用弗雷德功能即可完成操作，就使用向上转型
如归想要使用子类特有的功能呢？这就需要向下转型
Dog dog=(Dog) a;//向下转型
向下转型的好处：可以使用子类型特有的功能
弊端：面对具体的子类型。向下转型有风险。容易发生ClassCastException.只要转换类型和对象类型不匹配就会发生
想要安全，必须要进行判断，判断一个对象是否匹配某一类型
需要使用一个关键字  instanceof 对象  instanceof 类型
什么时候用向下转型，需要用子类型特有方法时，但一定要判断
*/
class Cat extends Animal{
	void eat() {		
		System.out.println(" Eat.");
	}
}














