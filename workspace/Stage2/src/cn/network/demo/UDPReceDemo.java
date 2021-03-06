/**
 * 
 */
package cn.network.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author john5
 *
 */
public class UDPReceDemo {
	/**
	* @param args
	* 创建udp的接收端
	* 思路：
	* 	1、创建socket服务，明确一个端口
	* 	2、、收数据
	* 	3、将其中所需的数据取出来， ipdata 端口
	* 	4、关闭资源
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		System.out.println("UDP接收端启动了......");
//		创建socket服务
		DatagramSocket dSocket=new DatagramSocket(10000);
	/*	
		2、使用socket的接收方法。接收数据。需要将收到的数据存储到数据包中
		可以通过数据包对象的方法对收到的数据进行解析
	*/
		byte[] buf=new byte[1024];
		DatagramPacket datagramPacket=new DatagramPacket(buf, buf.length);
		dSocket.receive(datagramPacket);
		
//		通过数据包对象解析收到的数据，使用数据包的方法
		String ip=datagramPacket.getAddress().getHostAddress();
		int port=datagramPacket.getPort();
//		获取文字数据
		
		String string=new String(datagramPacket.getData(),0,datagramPacket.getLength());
		System.out.println(ip+"："+port+"-----"+string);
	}
}
