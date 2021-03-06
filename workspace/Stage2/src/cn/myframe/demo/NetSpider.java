package cn.myframe.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetSpider {
	/**
	* @param args
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
//		1、将文件封装成对象
		File file=new File("mail.html");
		if(!file.exists()){
			file.createNewFile();
		}
		String regex="\\w+@\\w+(\\.\\w)+";
		
		
		List<String> mailList=getMails(file,regex);
		for(String mail : mailList){
			System.out.println(mail);
		}
	}

	/**
	 * @param file
	 * @return
	 */
	private static List<String> getMails(File file,String regex) throws IOException {
//		读取数据
		BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
		
//		将正则封装成对象
		Pattern pattern=Pattern.compile(regex);
		
//		定义list集合
		List<String> list=new ArrayList<String>();
		String line=null;
		while((line=bufferedReader.readLine())!=null){
			Matcher matcher=pattern.matcher(line);
			while(matcher.find()){
				list.add(matcher.group());
			}
		}
		return list;
	}
}
