package cn.network.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MYBrowser {
	/**
	* @param args
	* 模拟浏览器，发送一些http的消息给tomcat服务器，并获取服务器反馈的信息
	 * @throws IOException 
	 * @throws UnknownHostException 
	*/
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.1.136", 18080);
		
//		获取输出流，给服务器发送数据
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		out.println("GET /lala/hello.html HTTP/1.1");
		out.println("Accept: */*");
		out.println("Host: 192.168.1.136:9090");
		out.println("Connection: close");//keep-alive，服务器会一直等着发数据，close发送一次就停止了
//		out.println("User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
//		out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//		out.println("Accept-Encoding: gzip, deflate, sdch");
//		out.println("Accept-Language: zh-CN,zh;q=0.8");
		out.println();
		
		InputStream in=socket.getInputStream();
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		String strs=new String(buf, 0, len);
		System.out.println(strs);
		socket.close();
	}
}
