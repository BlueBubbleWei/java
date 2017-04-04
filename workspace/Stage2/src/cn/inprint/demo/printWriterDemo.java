package cn.inprint.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class printWriterDemo {
	/**
	* @param args
	* 演示一个小例子
	* 读取键盘录入，将数据转成大写显示在屏幕上
	*/
	public static void main(String[] args) throws IOException {
		
//		键盘录入
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
//		定义目的
//		BufferedWriter bufferedWriter= new BufferedWriter(System.out);
		PrintWriter printWriter=new PrintWriter(System.out,true);//加入true参数，对println方法可以实现自动刷新
		
//		改变目的为文件，还想自动刷新
		printWriter=new PrintWriter(new FileWriter("1.txt"),true);//对流进行刷新
		
//		读一行写一行，键盘结束一定要定义结束标记
		String line=null;
		while((line=bufferedReader.readLine())!=null){
			if("over".equals(line)){
				break;
			}
			printWriter.println(line.toUpperCase());
		}
		printWriter.close();
		bufferedReader.close();//不需要关闭键盘录入这种标准输入	流一旦关闭后面获取不到
	}
}
