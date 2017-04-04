package mythreads;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class threadsRunnable{
/*
创建线程的第二种方式，实现Runnabe接口
1、定义一个Runnable类
2、覆盖Runnable接口中的run方法，将线程要运行的任务代码存储到该方法中
3、通过Thread类创建线程对象，并将实现了Runnable接口的对象作为Thread类的构造函数的参数进行传递
4、调用Thread类的start方法，开启线程
*/
	
/*	
实现Runnable接口的好处
	1、避免了继承Thread类的单继承的局限性
	2、Runnable接口出现更符合面向对象，并实现了Runnable接口的对象作为Thread类的构造函数的参数进行传递
	3、Runnable接口出现，降低了线程对象和线程任务的耦合性
	所以，以后创建进程都使用第二种方式
	*/
	
/*	
多线程的安全问题
	1、线程中有处理到共享的数据
	2、线程任务中有多条对共享数据的操作
一个线程在操作共享数据的过程中，其他线程参与了运算，造成了数据的错误

解决的思想：
只要保证多条操作共享数据的代码在某一时间段，被一条线程所执行，在执行期间不允许其他线程参与运算。
咋保证呢？
用到了同步代码块
sychronized（对象）{
	需要被同步的代码块
}
好处：解决了多线程的安全问题
弊端：减低了效率

有可能出现这样一种情况
多线程安全问题出现后，加入了同步机制，没有想到，安全问题依旧！咋办？
这时肯定是同步出了问题
只要遵守了同步的前提，就可以解决
同步的前提：
	多个线程在同步中必须使用同一个锁，这才是对多个线程同步
*/
	public static void main(String[] args) {
		//创建四个线程		
		ThreadD t= new ThreadD();
		Thread t1= new Thread(t);
		Thread t2= new Thread(t);
		Thread t3= new Thread(t);
		Thread t4= new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class ThreadD implements Runnable{
	//卖票的代码需要被多个线程执行，所以要将这些代码定义在线程任务中，run方法
	Object obj= new Object();
	private int tickets=100;
	public void run(){			
		while(tickets>0){
			synchronized (obj) {
				try {
					if(tickets!=0){
						System.out.println(Thread.currentThread().getName()+"\n"+tickets--);	
					}
					Thread.sleep(5);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());						
				}
			}
		}
	}
	
}