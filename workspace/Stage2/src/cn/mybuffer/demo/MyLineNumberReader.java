package cn.mybuffer.demo;

import java.io.IOException;
import java.io.Reader;
//自定义获取行号的方法
public class MyLineNumberReader extends MyBufferedReader{
	
//	定义一个计数器
	private int lineNumber=0;

	public MyLineNumberReader(Reader reader) {
		super(reader);
	}
/**
 * 
 * @throws IOException 
 * @覆盖父类的读一行的方法
 */
	public String myReadLine() throws IOException {
		lineNumber++;
		return super.myReadLine();
	}
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	
}
