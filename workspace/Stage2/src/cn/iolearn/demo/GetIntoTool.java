package cn.iolearn.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class GetIntoTool {
	/**
	* @param 获取学生对象
	 * @throws IOException 
	 * @throws NumberFormatException 
	*/
	/*public static Set<Student> getStudents() throws IOException{
		return null;
	}
	*/
	public static Set<Student> getStudents(Comparator<Student> comparator) throws IOException{
		//键盘输入
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		
//		创建一个容器存储学生对象
//		Set<Student> set=new TreeSet<Student>();
		Set<Student> set=null;
		if(comparator!=null){//如果传了比较器，就按比较器调用集合，否则就不按比较器调用集合
			set=new TreeSet<Student>(comparator);
		}else {
			set=new TreeSet<Student>();
		}
		
//		获取键盘输入的信息
		String line=null;
		while((line=bufferedReader.readLine())!=null){
//			键盘录入结束标记
			if("over".equals(line)){
				break;
			}
			
//			因为录入的数据是有规律 的。可以通过指定的规则进行分割
			String[] strings=line.split(",");
//			将数组中的元素封装成对象
			Student student=new Student(strings[0], Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), Integer.parseInt(strings[3]));
			
//			将学生对象存储到容器中
			set.add(student);
		}
/*		
		关闭键盘录入需知：
		如果后面不再使用键盘录入四可以关闭的。如果后面还要使用，就不要关闭。继续通过System.in就可以获取
		bufferedReader.close();
	*/	
		return set;
	}
	
	/**
	 * 将集合中的学生信息写入到文件中
	 * @throws IOException 
	 * 
	 */
	public static void write2File(Set<Student> set,File destFile) throws IOException {
		BufferedWriter bufferedWriter=null;
		try {
			bufferedWriter=new BufferedWriter(new FileWriter(destFile));
			
//			遍历集合
			for (Student student : set) {
				bufferedWriter.write(student.getName()+"\t"+student.getSum());
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		} finally {
			if(bufferedWriter!=null){
				try{
					bufferedWriter.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
