/**
 * 
 */
package cn.changeclass.demo;

/**
 * @author 韦玉梅
 *
 */
public class ChangeClassDemo {
	/**
	* @param 
	* 基本数据类型包装类
	* 将基本数据类型封装成对象的好处在于可以在对象中定义更多的功能方法操作该数据
	* 常用的操作之一：用于基本数据类型与字符串之间的转换
	* 例：Integer的parseInt方法，intValue方法
	* 
	* 基本数据类型包装类
	* 将基本数据值封装成了对象
	* 好处：可以在对象中定义更多属性和行为对基本数据操作
	* bye	Byte
	* short	Short
	* int	Integer
	* long	Long
	* boolean 	Boolean
	* float 	Float
	* double 	Double
	* char		Character
	* 
	* 基本数据类型对象包装类的重要功能，在基本类和String类型之间转换
	* 
	*/
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(6));
		/*
		字符串转成基本数据类型
		使用的是parse基本类型（字符串）；parseInt parseByte parseDouble  parseBoclean
		*/
		System.out.println(Integer.parseInt("234")+1);
		System.out.println(Integer.parseInt("110",2));//可以将其他进制的字符串转成十进制数
		
//		基本类型转字符串
		System.out.println(Integer.toString(8)+2);
		
//		为了对整数进行更多的操作，可以将整数封装层对象，通过Integer的方法完成，  int---->Integer
		Integer integer =new Integer(3);//构造方法
		Integer integer2=new Integer("4");//构造方法
		Integer integer3=Integer.valueOf(4);//静态方法
//		Integer---->int
		Integer integer4=new Integer(5);
		int n=integer4.intValue();
		System.out.println(n+"====n");
		
//		自动装箱自动拆箱，像操作int一样操作Integer
		Integer integer5=4;//自动装箱。integer.valueOf(4)
		integer5=integer5+1;//右边的integer5 自动拆箱。。 integer5.intValue()+6 运算完的结果又一次装箱赋值给integer5
		
		System.out.println("-----------------------");
		Integer xInteger= new Integer(100);
		Integer yInteger=new Integer(100);
		System.out.println(xInteger==yInteger);//false
		System.out.println(xInteger.equals(yInteger));//true
		
		System.out.println("-----------------------");
		//jdk1.5以后，自动装箱的值如果在byte范围内，相同的值不会单独开辟空间，而是重复使用
		Integer mInteger=127;
		Integer nInteger=127;
		System.out.println(mInteger==nInteger);//true
		System.out.println(mInteger.equals(nInteger));//true
		
	}
}
