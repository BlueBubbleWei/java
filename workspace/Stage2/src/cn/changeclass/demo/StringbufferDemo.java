package cn.changeclass.demo;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

/**
 * @author 韦玉梅
 *
 */
public class StringbufferDemo {
	/**
	* @StringBuffer 字符缓冲区
	* 字符串的组成原理就是通过该类实现的
	* StringBuffer可以对字符串内容进行增删
	* StringBuffer是一个字符容器
	* 很多方法与String相同
	* 特点
	* 	1、StringBuffer是可变长度的
	* 	2、可以对内容通过指定方法进行修改
	* 	3、容器对象一般都会具备对容器中的元素进行操作的功能，增删改查
	* 	4、缓冲区可以存储不同类型的数据
	* 	5、最终缓冲区存储的数据都会变成字符串
	*/
	public static void main(String[] args) {
		String string="a"+4+'c';
		System.out.println(string);
//	在内存中的过程，1、创建一个字符串缓冲区 2、将要组成字符串的元素先存储起来,最后将缓冲区填充数据变成字符串
		string =new StringBuffer().append("a").append('c').toString();
		System.out.println(string);
		/*
		缓冲区可以对数据进行临时存储
		了解缓冲区的常见方法
		添加元素：
		StringBuffer append(各种类型的数据)：添加
		StringBuffer InsertBreakAction(inde,各种类型的数据):指定位置添加
		*/
//		1、创建一个缓冲对象
		StringBuffer sb=new StringBuffer();
//		追加一个字符串
		sb.append("abc");
//		
//		插入一个boolean值true
		sb.insert(1, true);
		System.out.println(sb);
		
//		删除字符
		sb.delete(1, 4);//删除的下标1-4的字符
		System.out.println(sb);
		
//		修改字符
		sb.replace(1, 5, "green");
		System.out.println(sb);
		
		sb.setLength(2);//限制字符串长度
		System.out.println(sb);
		
		sb.reverse();//反转字符串
		System.out.println(sb);//println方法会将所有要打印的数据先转成字符串输出，对于对象会自顶调用toString方法
		
		/*
		字符串缓冲区中维护一个“可变长度的数组”
		解释：其实是超出内部数组长度，将原来的数组长度扩充为原来的1.x倍
		并将原数组的数据复制到新数组中，并将新的元素也添加到新数组中
		*/
	}
}
