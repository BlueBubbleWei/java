//package com.example.helloworld;
package mypackage;
import packageDemo.*;
/* 
 可以直接引入包名，再直接引用包，就不用引用类时用包名.类名的方式  
 .*是导入包中所有的类    import packageDemo.DemoB;只引入DemoB类，使得开发效率更高   
import导入的是类。不是包
如果目录如  \haha\zz.class ,导入package包中haha子包中的类 
import package.hahah.*;导入package包中的haha子包中的类
*/

/*把包压缩成jar包
 * jar 直接输入jar可以看到命令提示
 * 命令行目录文件下输入 jar cf my.jar pack
 * jar cfc my.jar pack//可以看到压缩的大小和压缩率
 * jar-xfv my.jar
 * 
 * */

//这个包里有个类
//在不写包的情况下，里面包含有一个默认包

//有了包以后，包的名称应该是：包名.类名
public class packageLearn {
	public class DemoB {

	}

	/*包
	 * 对类文件进行分类管理
	 * 给类提供多层命名空间
	 * 写在程序文件的第一行
	 * 类名的全称是   包名.类名
	 * 包也是一种封装形式
	 * */
	
//	包与包之间禁止访问可以加上protected
/*	
		public        protected     default    private
同一个类中		ok			ok 				ok		ok
同一个包中		ok			ok 				ok		
子类			ok			ok 			
不同包中		ok
*/
	public static void main(String[] args) {
		DemoA d1=new DemoA();
		packageDemo.DemoB d2=new packageDemo.DemoB();
		d1.show();
		d2.run();
		System.out.println("Hello Package");
	}
}
