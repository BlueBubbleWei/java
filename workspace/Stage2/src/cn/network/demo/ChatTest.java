package cn.network.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ChatTest {
	/**
	* @param args
	* 通过UDP协议
	* 完成一个聊天程序
	* 一个负责发送数据的任务，一个负责接收数据的任务。两个任务需要同时执行
	* 可以使用多线程技术
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		/**
		 * 通过UDP协议，完成一个聊天程序。一个负责发动数据的服务。一个负责接收数据的任务。两个任务需要同时进行。可以使用多线程技术
		 * 创建socket服务
		 * 发送端
		 */
		DatagramSocket send=new DatagramSocket(8888);
		DatagramSocket rec=new DatagramSocket(10002);
		
		new Thread(new Send(send)).start();
		new Thread(new Rece(rec)).start();
		
	}
}

//负责发送的任务
class Send implements Runnable{
//	任务对象一建立 ，需要socket对象
	private DatagramSocket  ds;
	public Send(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
//		具体的发送数据的任务内容
//		1.要发送的数据来自哪里?键盘录入
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		
//		读取数据
		String line=null;
		try {
			while((line=bufferedReader.readLine())!=null){
				
//				将数据变成字节数组，封装到数据不保
//				将数据封装到数据包中
				byte[] buf=line.getBytes();
				DatagramPacket datagramPacket=new DatagramPacket(buf, buf.length,
						InetAddress.getByName("192.168.1.155"),10002);
				ds.send(datagramPacket);
				
				if("over".equals(line)){
					System.exit(0);
					break;
					
				}
			}
			ds.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		2.将数据封装到数据包中
//		3.将数据包发送出去
		
		
		
		
	}
	
}


//负责接收的任务
class Rece implements Runnable{
	private DatagramSocket ds;
	
	public Rece(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		while(true){
//			接收的具体的任务的内容
//			因为接受的数据最终会存储到数据包中，而数据包中必须有字节数组
			byte[] buf=new byte[1024];
			
//			创建数据包对象
			DatagramPacket datagramPacket=new DatagramPacket(buf, buf.length);
			
//			将收到的数据存储到数据包中
			try {
				ds.receive(datagramPacket);
			} catch (IOException e) {
				e.printStackTrace();
			}
//			获取数据
			String ip=datagramPacket.getAddress().getHostAddress();
			String data=new String(datagramPacket.getData(),0 , datagramPacket.getLength());
			
			if("over".equals(data)){
				System.out.println(ip+"离开聊天室");
			}
			System.out.println(ip+":"+data);
		}
	}
}
