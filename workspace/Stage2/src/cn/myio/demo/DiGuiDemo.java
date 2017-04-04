package cn.myio.demo;

public class DiGuiDemo {
	/**
	* @param 递归：函数自身调用自身。函数内部又使用到了该函数的功能
	* 什么时候使用？
	* 功能被重复使用，但是每次该功能使用参与预算的数据不同是，可以考虑递归方式解决
	* 
	* 使用时，一定要定义条件
	* 注意递归次数过多，会出现内存溢出
	*/
	public static void main(String[] args) {
		int sum = getSum(3);
		System.out.println("sum"+":\t"+sum);
	}
	/**
	 * @param i
	 * @return
	 */
	private static int getSum(int i) {
		if(i==1)
			return i;
		return i+getSum(i-1);
	}
	public void show() {
		show();		
	}
}
