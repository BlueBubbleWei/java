package cn.network.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
	/**
	* @param args
	* 服务端收到客户端的数据并反馈数据给客户端。应答
	 * @throws IOException 
	* 
	*/
	public static void main(String[] args) throws IOException {
		System.out.println("服务器端启动");
//		创建服务端socket对象
		ServerSocket sSocket=new ServerSocket(10005);
		
//		获取客户端对象
		Socket socket=sSocket.accept();
		String ip=socket.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");
		
//		获取socket读取流
		InputStream inputStream=socket.getInputStream();
		
		byte[] buf=new byte[1024];
		int len=inputStream.read(buf);
		String strs=new String(buf, 0, len);
		System.out.println(strs);
		
//		给客户端反馈数据，socket输出流
		OutputStream outputStream=socket.getOutputStream();
		outputStream.write("已连接".getBytes());
		socket.close();
		sSocket.close();
		
	}
}
