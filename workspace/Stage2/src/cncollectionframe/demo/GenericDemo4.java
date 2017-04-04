package cncollectionframe.demo;

import cn.myarraylist.domain.Student;

public class GenericDemo4 {
	/**
	* @param args
	*/
	public static void main(String[] args) {
		Tool tool=new Tool();
		tool.setObject(new Student());
		Student stduent=(Student)tool.getObject();
		
		/*定义泛型类，传参数
		 * Util<Student> util=new Util<Student>();
		util.setObject(new Worker());//如果类型不匹配，直接编译失败
		Student student=util.getObject();//避免了向下转型
		System.out.println(student);*/
	}
}

/*class Tool{
	
	创建一个用于操作Student对象的工具类。对对象进行设置和获取
	太有局限性了，可不可以定义一个可以操作所有对象的工具呢？
	类型向上抽取,当要操纵的对象不确定的时候，为了扩展，可以使用Object类型来完成
	但是这种方式会出现一种小弊端，会出现转型，向下转型容易在运行时出现ClassCastException
	
	jdk1.5以后，出现新的解决方案
	类型不确定时，可以对外提供参数，用使用者通过传递参数的形式完成类型的确定
	
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}*/
class Tool{
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}

//在类定义时就传递擦拿书，由使用该类的调用者，来传递具体的类型
class Util<W>{//泛型类，类上多了参数
	private W object;

	public W getObject() {
		return object;
	}

	public void setObject(W object) {
		this.object = object;
	}
}