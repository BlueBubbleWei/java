package cn.inprint.demo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeStreamDemo {
	/**
	* @param args
	* 管道流：
	* 特点：读取管道和写入管道可以连接
	* 需要使用多线程技术，单线程 容易死锁
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
//		创建管道对象
		PipedInputStream pipedInputStream=new PipedInputStream();
		PipedOutputStream pipedOutputStream=new PipedOutputStream();
		
//		将两个流连接上
		pipedInputStream.connect(pipedOutputStream);
		new Thread(new Input(pipedInputStream)).start();
		new Thread(new Output(pipedOutputStream)).start();
		
	}
	
}

class Input implements Runnable{
	private PipedInputStream PipedInputStream;
	
	/**
	 * @param pipedInputStream
	 */
	public Input(java.io.PipedInputStream pipedInputStream) {
		super();
		PipedInputStream = pipedInputStream;
	}

	@Override
	public void run() {
		byte[] buf=new byte[1024];
		int len;
		try {
			len = PipedInputStream.read(buf);
			String string=new String(buf, 0, len);
			System.out.println(string);
			PipedInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

class Output implements Runnable{
	private PipedOutputStream PipedOutputStream;
	
	/**
	 * @param pipedOutputStream
	 */
	public Output(java.io.PipedOutputStream pipedOutputStream) {
		super();
		PipedOutputStream = pipedOutputStream;
	}

	@Override
	public void run() {
		try {
			PipedOutputStream.write("Hi,管道来了".getBytes());
			PipedOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}