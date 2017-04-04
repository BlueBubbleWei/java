package cn.myframe.demo;

import java.util.Arrays;

public class ResTest1 {
	/**
	* @param args
	* 我我我...... 要要.........吃吃吃吃.........饭饭饭
	*/
	public static void main(String[] args) {
//		replaceDemo();
		
//		对IP地址进行排序
		OrderDemo();
		checkMail();
	}

	/**
	 * 
	 */
	private static void checkMail() {
		String mail="278663275@qq.com";
		String regex="\\w+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3})";
		boolean b=mail.matches(regex);
		System.out.println(mail+":"+b);
	}

	/**
	 * 
	 */
	private static void OrderDemo() {
//		校验邮件地址
		String temp="192.168.1.37  1.2.3.4    10.25.6.6   127.0.0.1";
		String[] ips=temp.split(" +");
		/*
		排序出现问题了。是按照字符串字典顺序拍的序
		问题出在哪儿呢？是因为每一个地址段的位数不对
		如果位数都是三位就可以了。只有补0了
		每一位段数都不同，怎么补？
		干脆，按照最大所需的0的个数补齐，每一段都补两个0
		
		for(String ip: ips){
			System.out.println(ip);
		}*/
		temp=temp.replaceAll("(\\d+)", "00$1");
		
//		保留最后三位
		temp=temp.replaceAll("0*(\\d{3})","$1");
		Arrays.sort(ips);
		for(String ip: ips){
			System.out.println(ip);
		}
	}

	/**
	 * 
	 */
	private static void replaceDemo() {

		String pharse="我我我...... 要要.........吃吃吃吃.........饭饭饭";
//		明确要使用替换 replaceAll()
//		将点去掉
		pharse=pharse.replaceAll("\\.+", "");
		
//		将叠词去掉
		pharse=pharse.replaceAll("(.)\\1+", "$1");
		
//		将空格去掉
		pharse=pharse.replaceAll(" ", "");
		System.out.println(pharse);
	}
}
