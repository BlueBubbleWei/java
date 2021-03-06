package cn.network.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
	/**
	* @param args
	* 创建TCP服务端
	* 思路：
	* 	1、创建socket服务器端服务 。服务器端为了让客户端可以连上，必须提供端口，监听一个端口
	* 	2、获取客户端对象，通过客户端的socket流和对应的客户端进行通讯
	* 	3、获取客户端的socket流的读取流
	* 	4、读取数据并显示在服务器端
	* 	5、关闭资源
	 * @throws IOException 
	* 	
	*/
	public static void main(String[] args) throws IOException {
		System.out.println("服务器端启动..........");
		//创建服务器对象
		ServerSocket serverSocket=new ServerSocket(10004);
		
		//获取客户端对象
		Socket socket=serverSocket.accept();
		String ip=socket.getInetAddress().getHostAddress();
		System.out.println(ip+".........connected");
		
//		通过客户端对象获取socket流的读取流
		InputStream inputStream=socket.getInputStream();
		
		byte[] buf=new byte[1024];
		int len=inputStream.read(buf);
		
		String string=new String(buf, 0, len);
		System.out.println(string);
		
		socket.close();
	}
}
