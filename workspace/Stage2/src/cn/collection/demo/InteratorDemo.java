/**
 * 
 */
package cn.collection.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 韦玉梅
 *
 */
public class InteratorDemo {
	/**
	* @param 
	* Iterator的方法
	* hasNext()   next()  remove()
	*/
	public static void main(String[] args) {
		//创建集合
		Collection collection =new ArrayList();
		collection.add("abc");
		collection.add("xyz");
		
		//获取该容器的迭代器
		Iterator iterator =collection.iterator();
//		System.out.println(iterator.next()+"\t"+iterator.next()+"\t"+iterator.next());//会报NoSuchElementException
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//循环打印输出
		for(Iterator iterator2=collection.iterator();iterator2.hasNext();){
			System.out.println(iterator2.next());
		}
	}
}
