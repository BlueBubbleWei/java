package cn.iolearn.demo;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class FileReader_WriterDemo {
	/**
	* @param 
作业：键盘录入多名学生的信息:  格式：姓名，数学成绩没语文成绩，英文成绩
按总分由高到低，将学生的信息进行排列到文件中

思路：
1、是永久键盘录入技术
2、操作的学生信息，信息很多，需要将信息封装成学生对象
3、总分由高到低，需要排序，需要对学生对象中的总分排序，需要将多个学生对象进行容器存储
哪个容器呢？ TreeSet集合
4、将容器中翻学生对象的信息写入到文件中
	 * @throws IOException 

	*/
	public static void main(String[] args) throws IOException {
//		创建一个人比较器
		Comparator<Student> comparator=Collections.reverseOrder();
//		使用操作学生信息的工具类
		Set<Student> set=GetIntoTool.getStudents(comparator);
		
		File destFile=new File("D:\\java\\workspace\\Stage2\\src\\cn\\iolearn\\demo\\tempfile\\fos.txt");
		GetIntoTool.write2File(set, destFile);
	}
}
