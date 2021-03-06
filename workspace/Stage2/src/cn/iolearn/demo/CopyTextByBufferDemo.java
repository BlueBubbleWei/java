package cn.iolearn.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyTextByBufferDemo {
	/**
	* @param args
	* 复制图片原理  通过缓冲区
	*/
	public static void main(String[] args) {
		CopyTextByBuffer();
	}

	/**
	 * 
	 */
	private static void CopyTextByBuffer() {
		FileInputStream fileInputStream=null;
		FileOutputStream fileOutputStream=null;
		try {
			fileInputStream=new FileInputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\fos.txt");
			fileOutputStream=new FileOutputStream("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\copy.txt");
//			创建缓冲区
			byte[] buf=new byte[1024];
//			定义记录个数的变量
			int len=0;
//			循环读写
			while((len=fileInputStream.read(buf))!=-1){
				fileOutputStream.write(buf,0,len);
			}
		} catch (Exception e) {
//			异常日志
		}finally {
			if(fileInputStream!=null){
				try {
					if(fileInputStream!=null){
						fileInputStream.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(fileOutputStream!=null){
				try {
					if(fileOutputStream!=null){
						fileOutputStream.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
