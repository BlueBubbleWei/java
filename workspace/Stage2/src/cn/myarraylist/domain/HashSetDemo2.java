package cn.myarraylist.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author 韦玉梅
 *
 */
public class HashSetDemo2 {
	/**
	*1、不允许存储重复元素，因为会发生查找的不确定性
	*2、不保证存入和取出的顺序一致
	*3、比数组的查询效率高
	*4、用于存储元素和哈希值对应关系的容器称之为哈希表，冲突后，需要对元素进行进一步的判断，判断的是元素的内容，equals。
	*当哈希算法算出的两个元素的值相同时，称为哈希冲突
	*
	*哈希表在判断元素是否相同，依据hasCode()方法，如果哈希重复（哈希值相同），
	*再判断元素的equals方法，如果equals返回true,不存，返回false，存储！
	*
	* @param 练习：往hashset中存储学生对象（姓名 年龄）。 同姓名，同年龄视为同一人，不存	
	* 1、描述学生
	* 2、定义容器
	* 3、将学生对象存储到容器
	* 
	* 发现存储了同姓名同年龄的学生是可以的
	* 原因是每一次存储学生对象，都想调用hasCode（）获取哈希值
	* 但是调用的Object类中的hassCode，所以不同的对象，哈希值也不同
	* 这就是同姓名同年龄存入的原因
	* 
	* 解决：
	* 需要根据学生对象自身的特点来定义哈希值
	* 所以就需要覆盖hasCode方法
	* 
	*/
	public static void main(String[] args) {
//		创建容器对象
		Set<Student> set =new HashSet<>();
		
//		创建学生对象
		set.add(new Student("大黑",1));
		set.add(new Student("Blue",5));
		set.add(new Student("Bubble",1));
		set.add(new Student("Blue",25));
		set.add(new Student("Blue",5));
		
//		获取所有的学生
		for(Iterator iterator=set.iterator();iterator.hasNext();){
			Student student=(Student) iterator.next();
			System.out.println(student.getName()+"\t"+student.getAge());
		}
	}
}
