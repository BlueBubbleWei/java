package cn.network.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadTextServer {
	/**
	* @param args
	* 上传文本的服务端，接受文本数据，并存储到文件中，服务器端接收完毕以后，回馈“上传成功”字样
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		/*File file=new File("client.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		BufferedReader bufferedReader=new BufferedReader(new FileReader("client.txt"));//高效
		String line=null;
		while((line=bufferedReader.readLine())!=null){
			System.out.println(line);
		}
	*/
		System.out.println("上传服务端启动了........");
//		1、服务端对象
		ServerSocket serverSocket=new ServerSocket(8887);
		
//		2、获取客户端
		Socket socket=serverSocket.accept();
		String ip=socket.getInetAddress().getHostAddress();
		System.out.println(ip+"....connected");
		
		//3、获取读取流，确定源，网络socket
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
//	4、确定目的。文件
		PrintWriter printWriter=new PrintWriter(new FileWriter("server.txt",true));
		
//	5、频繁读写
		String line=null;
		while((line=bufferedReader.readLine())!=null){
			if("over".equals(line))
				break;
			printWriter.println(line);
		}
		
		printWriter.println("over");
		
//	6、给客户端返回信息
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		out.println("上传成功");
		
		printWriter.close();
		serverSocket.close();
		serverSocket.close();
	}
}
