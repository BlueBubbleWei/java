package cncollectionframe.demo;

public class GenericDemo5 {
	public static void main(String[] args) {
		Demo<String> demo= new Demo<String>();
		demo.show("123324");
//		demo.print(5);//类型不对应
		Demo<Integer> demo2=new Demo<Integer>();
		demo2.print(5);
//		demo2.show("123324");//类型不对应
		Demo<String> demo3= new Demo<String>();
		demo3.clear(123);//调用 泛型方法
		demo3.clear("spring");
	}
}

class Demo<W>{
	public static<A> void staticShow(A w) {//静态方法是无法访问类上定义的泛型的。如果静态方法需要定义泛型，泛型只能定义在方法上
		System.out.println("show:"+w);
	}
	public void show(W w) {
		System.out.println("show:"+w);
	}
	public void print(W w) {
		System.out.println("print"+w);
	}
	public <Q> void clear(Q w) {//泛型方法
		System.out.println("clear:"+w);
	}
}

