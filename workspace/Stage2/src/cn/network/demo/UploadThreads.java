package cn.network.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadThreads {
	public static void main(String[] args) throws IOException {
		System.out.println("上传图片服务端已开启........");
		ServerSocket serverSocket=new ServerSocket(18079);
		while(true){
			Socket socket=serverSocket.accept();
			
			new Thread(new UploadPic(socket)).start();
		}
	}
}
