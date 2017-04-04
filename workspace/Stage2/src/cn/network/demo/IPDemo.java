package cn.network.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {
	/**
	* @param args
	 * @throws UnknownHostException 
	*/
	public static void main(String[] args) throws UnknownHostException  {
		
		InetAddress ip=InetAddress.getLocalHost();
		System.out.println(ip);
//		获取其他主机信息
		ip=InetAddress.getByName("www.sina.com.cn");
		
		String address=ip.getHostAddress();
		String name=ip.getHostName();

		
		System.out.println(address);
		System.out.println(name);
	}
}
