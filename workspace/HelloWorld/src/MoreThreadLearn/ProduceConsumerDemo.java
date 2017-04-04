package MoreThreadLearn;

import java.util.Set;

/*
多线程间的通信，多个线程都在处理同一个资源，但是处理的任务却不一样
生产者，消费者
通过同步，解决了没生产就消费的问题
但是出现了连续的生产没有消费的情况，和需求生产一个，消费一个的情况不符
使用了等待唤醒机制

wait();//该方法可以让线程处于冻结状态，并将线程临时存储到线程池中国
notify();//唤醒指定线程池中的任意一个线程
notifyAll();//唤醒指定线程池中的所有线程

这些方法必须使用在同步中，因为它们又来操作同步锁上的现成的状态的
在使用这些方法时，必须标识它们所属于的锁，标识方式就是  锁对象.wait();   锁对象.notify();	锁对象.notifyAll();
相同锁的notify()，可以获取相同锁的wait();
*/
/*
多生产多消费
问题1：
	重复生产，重复消费
	原因：经过复杂的（等、资格）分析，发现被唤醒的线程没有判断标记就开始工作了（生成或消费）
	导致了重复的生成和消费的发生
	解决：
	那就是被唤醒的线程必须判断标记
	使用while循环搞定

问题2：
	死锁了 。所有的线程都处于冻结状态
	原因：本方线程在唤醒时，又一次唤醒了本方线程。而本方线程循环判断标记，又继续等待
	而导致所有的线程都等待了
	
	解决：
	希望本方如果唤醒了对方线程，就可以解决
	可以使用notifyAll()方法
	那不是全唤醒了吗？是的，既有本方又有对方。但是本方醒后，会判断标记继续等待
	这样对方就有线程可以执行了
*/
	
public class ProduceConsumerDemo {
	public static void main(String[] args) {
//		创建资源
		Res res=new Res();
//		创建两个任务
		Producer producer=new Producer(res);
		Customers customers=new Customers(res);
		Thread t1=new Thread(producer);
		Thread t2=new Thread(customers);
		t1.start();
		t2.start();
	}
}
//描述资源
class Res{
	private String name;
	private int count=1;
	//定义标记
	private boolean flag;
	//提供给商品赋值的方法
	public synchronized void set(String name){		
		if(flag)//判断标记为true，执行wait，为false，就生产
			try {
			wait();		
			} catch (InterruptedException e) {}				
		this.name = name +"--"+count;
		count++;
		System.out.println(Thread.currentThread().getName()+"...生产者....."+this.name);
		//生产完毕，将标记改为notify()
		flag=true;
		//唤醒消费者
		notify();
	}
//	提供一个获取商品的方法
	public synchronized void get() {		
		if(!flag)
			try {
				wait();		
				} catch (InterruptedException e) {}	
		System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
		//将标记改为false
		flag=false;
		//唤醒消费者
		notify();
	}
}
//生产者
class Producer implements Runnable{
	private Res res;
	public Producer(Res res) {
		this.res=res;
	}
	public void run(){
		while(true){
			res.set("面包");			
		}		
	}
}

//消费者
class Customers implements Runnable{
	private Res res;
	public Customers(Res res) {
	this.res=res;
	}
	public void run(){
		while(true){
			res.get();
		}		
	}
}