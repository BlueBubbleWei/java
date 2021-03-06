package cn.network.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadPic implements Runnable {
	private Socket socket;

	public UploadPic(Socket s) {
		super();
		this.socket = s;
	}

	@Override
	public void run() {
		String ip=socket.getInetAddress().getHostAddress();
		File file= getfile("D:\\java\\workspace\\Stage2\\Pic",ip);
		
		System.out.println(ip+"......connected");
		
		InputStream iStream;
		try {
			iStream=socket.getInputStream();
			FileOutputStream fOutputStream=new FileOutputStream(file);
			
			byte[] buf=new byte[1024];
			int  len=0;
			
			while((len=iStream.read(buf))!=-1){
				fOutputStream.write(buf, 0, len);
			}
			
//			回馈客户端数据
			OutputStream oStream=socket.getOutputStream();
			oStream.write("上传图片成功".getBytes());
			
			fOutputStream.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
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
