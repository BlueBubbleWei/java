package cn.network.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSendDemo {
	/**
	* @param args
	* 需求：建立udp的发送端
	* 思路：
	* 	1、建立可以实现udp传输的socket服务
	* 	2、明确具体发送的数据
	* 	3、通过socket服务将具体的数据发送出去
	* 	4、关闭服务
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		System.out.println("UDP发送端启动......");
//		创建udp服务
		DatagramSocket datagramSocket=new DatagramSocket(8888);
//		明确数据
		String string="注意啦！UDP来啦！";
		
//		发送数据，将数据封装到数据包中
//		3、1将数据封装到数据包对象中。数据包会明确目的地址和端口
		byte[] buf=string.getBytes();
		DatagramPacket dPacket=new DatagramPacket(buf, buf.length,
				InetAddress.getByName("192.168.1.136"),10000);
//		3、2发送
		datagramSocket.send(dPacket);
		
//		3、3关闭
		datagramSocket.close();
	}
}
