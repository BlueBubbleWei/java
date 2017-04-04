package cncollectionframe.demo;

public class GenericDemo6 {
	public static void main(String[] args) {
		SubDemo subDemo=new SubDemo();
		subDemo.show("123");
	}
}

interface Inter<T>{//泛型接口
	public void show(T t);
}

class InterImpl<String> implements Inter<String>{
	@Override
	public void show(String t) {
	}
}

class InterImpl2<W> implements Inter<W>{

		@Override
	public void show(W t) {
			System.out.println(t);
	}	
}

class SubDemo extends InterImpl2<String>{
	
}
