package practice;

/*
 * 建立一个图形接口，声明一个面积函数，圆形和矩形都实现这个接口，并得出这两个图形的面积
注:体现面向对象的特征，对数值进行判断，用异常处理，不合法的数值要出现“这个数值不合法的提示”，不再进行运算
*/
public class AreaDemo {
	public static void main(String[] args) {
		Circle circle = new Circle(-1);
		Rectangular rectangular = new Rectangular(4, 5);
		System.out.println(circle.getArea());
		System.out.println(rectangular.getArea());
	}
}

interface Shape{
	public  double getArea() throws Exception;	
}

class Circle implements Shape{
	final static double PI=3.14;
	private double r ; 
	public Circle(double r) {
		this.r = r ;
	}
	public double getArea() {
		try{
			if(r>0)
				return PI*r*r;
			else{
				throw new Exception("数值非法！");//抛出异常捕捉异常
			}
		}catch( Exception e){
			e.printStackTrace();
		}
		return -1;
	}	
}

class Rectangular{
	private double x ;
	private double y ;
	public Rectangular(double x, double y) {
		this.x = x ;
		this.y = y; 
	}
	public double getArea() {
		try {//如果x<0，不执行if语句会不会马上跳出try执行catch?不会。
			if(x>0 || y>0){
				return x*y;
			}else{
				throw new Exception("数值非法！");//抛出异常捕捉异常
			}
		} catch( Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}
