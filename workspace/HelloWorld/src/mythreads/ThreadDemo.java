package mythreads;

/*
通过查阅api文档 java.lang.Thread类
该类的描述中有创建线程的两种方式
1、继承Thread类
	1、继承Thread类
	2、覆盖run方法
	3、创建子类对象就是创建先成对象
	4、调用Thread类中的start()方法
	
	start（）开启线程后，都会执行run方法，说明run方法中存储的是线程要运行的代码。
	所以，记住，自定义现成的任务代码都存储在run方法中
*/

/*
调用start和调用run方法的区别
调用start会开启线程，让开启的线程去执行run方法中的线程任务
直接调用run方法，线程并未开启，去执行run方法的只有子线程
*/
public class ThreadDemo {
	public static void main(String[] args) {
		DemoA d1= new DemoA("大黑");
		DemoA d2= new DemoA("Blue");
		d1.start();//启动线程，自动执行run方法
		d2.start();
		for(int x=0,end=5;x<end;x++){
			System.out.println(Thread.currentThread().getName()+"\t"+"x="+x);//获取当前线程的名字
		}
	}
}
class DemoA extends Thread{
	String  name;
	public DemoA(String name) {
		this.name=name;
	}
	//覆盖run 方法，如果不写run方法，start（）会自动调用父类的run()
	public void run() {
		for(int x=0,end=5;x<end;x++){
			System.out.println("汪汪！"+name);
		}
	}
	//覆盖了start方法以后，就不能再执行，可以加上super.start()，就可以再次调用到父方法的start()
	public void start() {
		super.start();
	}
}
/*
运行结果 
汪汪！大黑
main	x=0
汪汪！Blue  
main	x=1
main	x=2
main	x=3
main	x=4
汪汪！大黑
汪汪！大黑
*/