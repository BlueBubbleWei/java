package cn.network.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient2 {
	/**
	* @param args
	* 需求：客户端发送数据给服务端，并读取服务端反馈的数据
	 * @throws IOException 
	 * @throws UnknownHostException 
	* 
	*/
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端2启动....");
//		创建socket客户端
		Socket socket=new Socket("192.168.1.136", 10005);
		
//		获取socket输出流，写数据
		OutputStream out=socket.getOutputStream();
		
		out.write("服务端我来了！".getBytes());
		
//		获取socket的读取流，读取服务端发回的数据
		InputStream inputStream=socket.getInputStream();
		
		byte[] buf=new byte[1024];
		int len=inputStream.read(buf);
		String strs=new String(buf, 0, len);
		
		System.out.println(strs);
		socket.close();
		
	}
}
