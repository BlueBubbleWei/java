package cn.network.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadPicCllient {
	/**
	* @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	*/
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("上传图片的客户端已开启......");
		Socket socket=new Socket("192.168.1.136", 18079);
		
		File picFile=new File("1.jpg");
		
		FileInputStream fileInputStream=new FileInputStream(picFile);
		OutputStream outputStream=socket.getOutputStream();
		
		byte[] buf=new byte[1024];
		int len=fileInputStream.read(buf);
		while((len=fileInputStream.read(buf))!=-1){
			outputStream.write(buf,0,len);
		}
		socket.shutdownOutput();
		
		
//		读取服务器端的数据
		InputStream inputStream=socket.getInputStream();
		byte[] bufIn=new byte[1024];
		int lenIn=inputStream.read(bufIn);
		String strs=new String(bufIn, 0, lenIn);
		System.out.println(strs);
		
		fileInputStream.close();
		socket.close();
		
	}
}
