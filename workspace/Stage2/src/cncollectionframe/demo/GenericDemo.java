
package cncollectionframe.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author john5
 *
 */
public class GenericDemo {
	/**
	* @param args
	* 泛型：
	* 在JDK1.4版本之前，容器什么类型的对象都可以存储，但是在取出时，需要用到对象的特有内容是，需要向下转型
	* 但是对象的类型不一致，导致了向下转型是发生了ClassCastException异常
	* 为了避免这个问题，只能主观上控制，往集合中存储的对象类型保持一致
	* 
	* JDK1.5以后解决了这个问题，在定义集合时，就明确集合中存储元素的具体类型
	* 这样，编译器在编译时，就可以对集合中存储的对象类型进行检查。
	* 一旦发现类型不匹配，就编译失败，这个技术就是泛型技术
	* 
	* 好处：
	* 	1、将运行时期的问题转移到编译时期，可以更好的让程序员发现问题并解决问题
	* 	2、避免了向下转型的麻烦
	* 
	* 总结：泛型就是应用在编译时期的一项安全机制
	* 
	* 泛型的擦除：编译器通过泛型对元素类型进行检查，只要检查通过，
	* 就会生成class文件，但在class文件中，就将泛型标识去掉了。
	* 泛型的表现：泛型技术在集合框架中应用的范围很大。什么时候需要些泛型呢？
	* 	1、只要看到类，或者接口在描述时的右边定义<>，就需要泛型
	* 其实是，容器在不明确操作元素的类型的情况下，对外提供了一个参数<>
	* 使用容器时，只要将具体的类型实参传递给该参数即可
	* 说白了，泛型就是，传递类型参数
	*/
	public static void main(String[] args) {
//		为了运行时期不出现类型异常，可以在定义类型时，就明确容器中的元素类型
//		List<String> list=new ArrayList<String>();
		List list =new ArrayList();
		list.add("adsa");
		list.add(4);
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//			Object object=iterator.next();
			String string=(String)iterator.next();
			System.out.println(iterator.next().toString());
			System.out.println(string.length());
		}
		/*
		给Iterator加上泛型，就不用再强转
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String string=iterator.next();
			System.out.println(string.length());
		}
		*/
	}
}
