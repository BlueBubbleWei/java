package cn.network.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {
	/**
	* @param args
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		System.out.println("上传图片服务端已开启........");
		ServerSocket serverSocket=new ServerSocket(18078);
		
		Socket socket=serverSocket.accept();
		String ip=socket.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");
		
		InputStream iStream=socket.getInputStream();
		
		File file = getfile("D:\\java\\workspace\\Stage2\\Pic",ip);
//		FileInputStream fInputStream=new FileInputStream(file);
		FileOutputStream fOutputStream=new FileOutputStream(file);
		
		byte[] buf=new byte[1024];
		int  len=0;
		
		while((len=iStream.read(buf))!=-1){
			fOutputStream.write(buf, 0, len);
		}
		
//		回馈客户端数据
		OutputStream oStream=socket.getOutputStream();
		oStream.write("上传图片成功".getBytes());
		
		fOutputStream.close();
		socket.close();
		serverSocket.close();
	}

	private static File getfile(String dir,String ip) throws IOException {
		File pic_dir=new File(dir);
		if(!pic_dir.exists()){
			pic_dir.mkdir();
		}
		File file=new File(pic_dir,ip+".jpg");//创建失败？？？
		int count=0;
		if(file.exists()){
			file=new File(ip,"("+count+").jpg");
		}else{
			file.createNewFile();
		}
		return file;
	}
}
