package cn.network.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadTextClient {
	/**
	* @param args
	* 上传文本的客户端。读取本地的文本数去，发送给服务端，服务端接收完毕后，回馈“上传成功字样”
	* 客户端 socket
	 * @throws IOException 
	 * @throws UnknownHostException 
	*/
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("上传客户端启动了......");
//		客户端socket
		Socket socket=new Socket("192.168.1.136", 8887);
		
//		确定数据源，本地文件
		BufferedReader bufferedReader=new BufferedReader(new FileReader("client.txt"));//高效
		
//		确定数据流，socket输出
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);//true代表刷新
		
		String line=null;
		while((line=bufferedReader.readLine())!=null){
			out.println(line);
		}
		
//		给服务器端发送标记
		out.println("over");
	
		
//		上面的over  使用socket的禁用输出流方法
		socket.shutdownOutput();
		
//		通过socket读取流获取服务器端返回的数据
		BufferedReader bufferedIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String lineIn=bufferedIn.readLine();
		System.out.println(lineIn);
		
//		关闭
		bufferedReader.close();
		socket.close();
	}
}
