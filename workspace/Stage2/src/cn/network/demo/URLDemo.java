package cn.network.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
	/**
	* @param args
	* 解析URL中放入数据，使用URL对象
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		String str_url="http://192.168.1.136:8080/lala/hello.html?name=lili";
		URL url=new URL(str_url);
		System.out.println(":"+url.getProtocol());
		System.out.println(":"+url.getHost());
		System.out.println(":"+url.getPort());
		System.out.println(":"+url.getPath());
		System.out.println(":"+url.getFile());
		System.out.println(":"+url.getQuery());
		
		
//		通过openconnection()获取到远程资源的连接对象
		URLConnection connection=url.openConnection();
		
		System.out.println(connection);
		System.out.println("-----------------");
//		调取连接对象的读取烦烦烦，准备读取资源
		InputStream in=connection.getInputStream();
		
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		String strs=new String(buf, 0, len);
		System.out.println(strs);
		
	}
}
