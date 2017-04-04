package mythreads;

public class TicketDemo {
	public static void main(String[] args) {
		//创建四个线程
		Ticket t1= new Ticket();
		Ticket t2= new Ticket();
		Ticket t3= new Ticket();
		Ticket t4= new Ticket();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Ticket extends Thread{
	//卖票的代码需要被多个线程执行，所以要将这些代码定义在线程任务中，run方法
	private int tickets=100;
	public void run(){
		while(tickets>0){
				System.out.println(Thread.currentThread().getName()+"\n"+tickets--);
		}
	}
}