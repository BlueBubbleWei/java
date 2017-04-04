package cn.myarraylist.domain;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author john5
 *
 */
public class EnumerationDemo {
	/**
	* @param 枚举取出元素
	* Enumeration：枚举
	* 具备枚举取出方式的容器只有Vector
	*/
	public static void main(String[] args) {
		Vector vector=new Vector();
		vector.add("abc1");
		vector.add("abc2");
		vector.add("abc3");
		vector.add("abc4");
		
		
		//获取枚举类型
		Enumeration enumeration=vector.elements();
		while(enumeration.hasMoreElements()){
			System.out.println("enumeration:"+enumeration.nextElement());
		}
		
		
//		获取迭代
		for (Iterator iterator = vector.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			
		}
		
//		高级for
		for(Object object:vector){
			System.out.println("foreach:"+object);
		}
	}
}
