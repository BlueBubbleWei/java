package blue.myhtml.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ResServer {
	/**
	* @param args
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket=new ServerSocket(1256);
		Socket socket=serverSocket.accept();
		System.out.println(socket.getInetAddress().getHostAddress()+".....connected");
		
		InputStream in=socket.getInputStream();
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		String str=new String(buf, 0, len);
		System.out.println(str);
		
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		out.println("<meta charset='utf-8'><font color='green' size='18'>注册成功！</font>");
		socket.close();
		serverSocket.close();
		
	}
}
