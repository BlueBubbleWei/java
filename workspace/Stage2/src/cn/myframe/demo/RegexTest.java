package cn.myframe.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	/**
	* @param args
	*/
	public static void main(String[] args) {
//		matchesDemo();
//		splitDemo();
//		replaceDemo();
		getDemo();
		
	}

	/**
	 * 
	 */
	private static void getDemo() {
	/*	
		实现获取，将符合规则的内容提取出来
		用到正则表达式对象。java.util.regex.Pttern
		
		1、将字符串数组封装成Pattern对象  compile(regex)
		2、通过正则对象获取匹配器对象   用将正则规则作用到要操作的字符串上
		3、通过匹配器对象的方法，对字符串进行操作
		
		Pattern pattern=Pattern.compile("a*b");//将规则编译成对象
		Matcher matcher=pattern.matcher("abcd");//和要操作的字符串关联，生成匹配器对象
		boolean b=matcher.matches();//使用匹配字符串方法对字符串操作
	*/	
		//取出字符串中符合规则的内容
		String temp="wei shen me xia yu bu da shan";
		//取出由三个字母组成的单词
		String regex="[a-zA-Z]{3}";
		
//		将规则编译成Pattern对象
		Pattern pattern=Pattern.compile(regex);
		
//		和字符串关联，获取匹配器对象
		Matcher matcher=pattern.matcher(temp);
		/*System.out.println(matcher.find());
		System.out.println(matcher.group());*/
		
		while(matcher.find()){
			System.out.println(matcher.start()+":"+matcher.group()+":"+matcher.end());
		}
		
		
	}

	/**
	 * 
	 */
	private static void replaceDemo() {
		String temp="13127716930";
		temp=temp.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");// $可以在多参数时，后面的参数可以通过￥编号的形式取到前一个参数的组
//		System.out.println(temp);
		
		String strs="qw##%%refefkffrrr";
		strs=strs.replaceAll("(.)\\1+","&" );//所有的叠词替换成&	qw&&refefk&&

		strs=strs.replaceAll("(.)\\1+","&1" );//所有的叠词替换成&   qw&1refefk&1
		System.out.println(strs);
	}

	/**
	 * 
	 */
	private static void splitDemo() {
		String temp="小王八   ，  李四  wewe   dddd ";
		String regex=" +";//包含1-n个空格一起切
		
		
		String netadd="www.baidu.com";
		String net="\\.";
		
		String vo="saadiioshddhsssss";
		String resvo="(.)\\1+";//为了实现规则的复用，用（）将需要复用的规则封装，就称为正则表达式中的组。每一个组都有一个编号，从1开始
//		通过使用编号就可以复用对应组的规则内容。注意：编号必须用到组的后面】
//		也就是说：先封装完再调用
		
		String[] names=temp.split(regex);
		for(String name:names){
//			System.out.println(name+"--");
		}
		String[] strs=netadd.split(net);
		for(String str:strs){
//			System.out.println(str);
		}
		
		String[] vos=vo.split(resvo);
		for(String v:vos){
			System.out.println(v);
		}
		
	}

	/**
	 * 
	 */
	private static void matchesDemo() {
		//需求：校验手机号码是否正确
		String tel="13255538615";
		String regex="1[32456789][0-9]{9}";
		boolean b=tel.matches(regex);
		System.out.println(tel+"\t"+b);
	}
}
