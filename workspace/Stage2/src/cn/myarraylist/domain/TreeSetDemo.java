package cn.myarraylist.domain;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 韦玉梅
 *
 */
public class TreeSetDemo {
	/**
	* @param TreeSet
	* |--二叉树数据结构。TreeSet可以对元素进行排序 。不同步的
	* 排序方式：需要元素具备比较功能，所以元素需要实现Comparab;e接口。覆盖CompareTo方法
	* 如何保证元素的唯一性？
	* 参考的就是比较方法的返回值是否是0，是，就是重复元素，不存。
	* 排序方式：需要元素具备背胶功能，所以元素需要实现Comparable接口，覆盖CompareTo方法
	*/
	public static void main(String[] args) {
		/*
		初始化TreeSet集合明确一个比较器，实现Comparator接口，覆盖compare方法，将Comparator接口的对象，
		作为参数传递给TreeSet集合的构造函数
		比较器更为灵活，自然排序通常作为元素的默认排序
		*/
		Set set =new TreeSet(new ComparatorByName());//会自动排序 比较器
/*//		创建容器对象
		Set set =new TreeSet();*/
		
/*//		创建对象
		set.add("abc1");
		set.add("eferf");
		set.add("1bc3");
		set.add("abc4");*/
//		创建学生对象
		set.add(new Student("大黑",1));//java.lang.ClassCastException:
										//因为学生要排序，就需要比较，而没有定义比较方法，无法完成排序
										//比较add方法中使用的是comparable接口中的比较方法
		set.add(new Student("Blue",5));
		set.add(new Student("Bubble",1));
		set.add(new Student("Blue",25));
		set.add(new Student("Alue",5));//CompareTo会将Alue排到Blue前面
		
//		获取所有的学生
		for(Iterator iterator=set.iterator();iterator.hasNext();){
//			System.out.println(iterator.next());
			Student student=(Student) iterator.next();
			System.out.println(student.getName()+"\t"+student.getAge());
		}
	}
}
