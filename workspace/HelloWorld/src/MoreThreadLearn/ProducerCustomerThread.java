package MoreThreadLearn;
import java.util.concurrent.locks.*;
/*
解决了多生产多消费的效率问题
使用了JDK1.5 java.util.concurrent.locks包中的对象
lock接口：它的出现比synchronized有更多的操作
	lock():获取锁
	unlock():释放锁
同步代码块或者同步函数的锁的操作是隐式 的
JDK1.5  Lock接口，按照面向对象的思想，将锁单独封装成一个对象，并提供了对锁的显示操作

Lock接口就是同步的替代
1、将线程中的同步更换为Lock接口的形式

替换完运行失败了，因为wait没有同步区域，没有了所属的同步锁
同步升级了。其中锁已经不再是任意对象，而是Lock类型的对象
那么和任意对象绑定的监视方法，是不是也升级了，有了专门的和Lock类型锁的绑定的监视机器方法呢？
查阅api。Condition接口替代啦Object中的监视器方法

以前监视器方法封装到每一个对象当中
现在将监视器方法封装到Condition对象中
方法名为：await signal signalAll
obj作为锁，本身就是监视器方法
监视器对象Condition如何和
*/

/*
wait()和 sleep()的区别？
相同：可以让线程处于冻结状态
不同点：
	1、wait()可以指定时间。也可以不指定
	sleep()必须指定时间
	2、wait()：释放资源，释放锁
	sleep():释放cpu资源，不释放锁
*/


/*
synchronized(obj){
	obj.wait();
	code ....
}
Synchronized(obj){
	obj.notifyAll();
}*/


public class ProducerCustomerThread {
	public static void main(String[] args) {
		Res res=new Res();
		Producer producer=new Producer(res);
		Consumer consumer=new Consumer(res);
//		创建线程
	     Thread t1= new Thread(producer); 
	     Thread t2 =new Thread(consumer);
	     t1.start();
	     t2.start();
	}
}

class Res2{
	private String name;
	private int count=1;
	private boolean flag;
	private Lock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	public void set(String name){
		//获取锁
		lock.lock();
		try {
			while (flag)
				try {
					condition.await();
				} catch (Exception e) {}
			this.name=name+"--"+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
			
			flag=true;
			condition.signalAll();
		} finally {
			//释放锁
			lock.unlock();
		}
	}
	
	public void get(){
		lock.lock();
		try {
			while (!flag)//一定要记得用while判断
				try {
					condition.await();
				} catch (Exception e) {}
			this.name=name+"--"+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
			
			flag=false;
			condition.signalAll();//和while相对应的signalAll();   
		} finally {
			//释放锁
			lock.unlock();
		}
	}
}

class Consumer implements Runnable{
	private Res res;
	public Consumer(Res res) {
		this.res=res;
	}
	public void run(){
		while(true){
			res.get();		
		}		
	}
}

class Producers implements Runnable{
	private Res res;
	public Producers(Res res) {
	this.res=res;
	}
	public void run(){
		while(true){
			res.set("面包");	
		}		
	}
}
