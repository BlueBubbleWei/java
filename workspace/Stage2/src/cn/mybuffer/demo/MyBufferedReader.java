package cn.mybuffer.demo;

import java.io.IOException;
import java.io.Reader;
//读取一个字符的方法，而且是高效的  重写read()方法
public class MyBufferedReader  extends Reader{
//	1、持有一个流对象
	private Reader reader;
//	因为是缓冲区对象，所以内部必须维护了数组
	private char[]  buffer=new char[1024];
	
//	定义脚标
	private int index=0;
//	定义变量，记录数组中元素的个数
	private int count=0;
//	一初始化就必须明确被缓冲的对象
	public MyBufferedReader(Reader reader) {
		super();
		this.reader = reader;
	}
	

	/**
	 * @throws IOException 
	 * 
	 */
	private int myRead() throws IOException {
//		通过被缓冲流对象的方法，就可以将设备上的数据存储到数组中
		if(count==0){
			count=reader.read(buffer);
			index=0;
		}
		
		if(count<0){
			return -1;
		}
		
		char ch=buffer[index];
		index++;//脚标每取一次自增
		count--;//既然取出一个，数组的数量要减少，一旦减到0，就再从设备上获取一批数据存储到数组中
		return ch;
	}
	
	/**
	 *读取一行文本
	 * @throws IOException 
	 */
	public String myReadLine() throws IOException{
		
//		定义临时缓冲区，用于存储一行文本
		StringBuilder stringBuilder=new StringBuilder();
//		不断的调用myRead方法从缓冲区中取出数据
		int ch=0;
		while((ch=myRead())!=-1){
//			在存储前要判断行终止符
			if(ch=='\r'){
				continue;
			}
			if(ch=='\n'){
				return stringBuilder.toString();
			}
//			对读到的字符进行临时存储
			stringBuilder.append((char)ch);			
		}
		
//		如果文本结尾处有数据，但是没有行结束符
//		数据已被读到，并存储到stringBulider中，只要判断stringBuilder的长度即可
		if(stringBuilder.length()!=0){
			return stringBuilder.toString();
		}
		return null;
	}
	
//	定义一个缓冲区的关闭方法
	public void myclose() throws IOException {
//		其实就是在关闭被缓冲区的流对象
		reader.close();
	}


/* (non-Javadoc)
 * @see java.io.Reader#close()
 */
@Override
public void close() throws IOException {
}


/* (non-Javadoc)
 * @see java.io.Reader#read(char[], int, int)
 */
@Override
public int read(char[] cbuf, int off, int len) throws IOException {
	return 0;
}
}
