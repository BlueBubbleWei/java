package cn.myserver.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Myserver {
	/**
	* @param args
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
//		创建一个服务器为了获取浏览器发送过来的数据
		ServerSocket serverSocket=new ServerSocket(9090);
		Socket socket=serverSocket.accept();
		System.out.println(socket.getInetAddress().getHostAddress()+"...connected");
		
//		接收浏览器的数据
		InputStream iStream=socket.getInputStream();
		byte[] buf=new byte[1024];
		
		int len=iStream.read(buf);
		String strs=new String(buf, 0, len);
		System.out.println(strs);
		
//		给浏览器一个回馈
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		out.println("<font size='7' color='green'>欢迎光临，你访问的是自定义的服务器！</font>");//可以用localhost:9090访问
		socket.close();
		serverSocket.close();
	}
}
