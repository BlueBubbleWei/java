package cn.network.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	/**
	* @param args
	* tcp客户端的建立
	* 思路：
	* 	1、建立TCP客户端
	* 	1、1因为是面向连接的，必须有连接才可以进行通信
	* 	1、2在创建客户端时，就必须明确目的地址 和端口
	* 	2、一旦连接建立,就有了传输数据的通道，就可以在通道中金属数据传输
	* 	这个传输其实就是通过流实现的。这个流就是socket io 流
	* 	3、只要获取socket io中的鞋动作就可以将数据写到socket流中发给服务端
	* 	4、关闭资源
	 * @throws IOException 
	 * @throws UnknownHostException 
	*/
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端启动....");
//		创建客户端对象，明确目的和端口
		Socket socket=new Socket("192.168.1.136", 10004);
		
//		获取socket流中的输出流，将数据发送给服务端
		OutputStream outputStream=socket.getOutputStream();
		
//		通过输出流写数据
		outputStream.write("TCP来啦".getBytes());
		
//		关闭资源
		socket.close();
	}
}
