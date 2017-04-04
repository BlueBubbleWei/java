package practice;

import android.R.string;

/*
在一个类中编写一个方法，这个方法搜素一个字符数组中是否存在某个字符，
如果存在，则返回这个字符在字符数组中第一次出现的位置（序号从0开始计算），
否则，则返回-1，要搜索的字符数组的字符都以参数形式传递给该方法，
如果传入的数组为null，应抛出IllegalArgumentException异常
在类的main方法中，以各种可能出现的情况测试验证该方法是否编写的正确
例如：字符不存在，字符存在，传入的数组为null等
*/
public class SearchStr { 
	public static void main(String[] args) {
		char[] a={'a','b','c'};
		SearchDemo searchDemo=new SearchDemo(a,'a');
		System.out.println(searchDemo.search());
	}
}
  
class SearchDemo{
	private char[] str;
	private char s;
	SearchDemo(char[] str,char s) {
		try {
			if(str.length!=0){
				this.str=str;
				this.s=s;
			}else {
				throw new Exception("数组不能为空。");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int search(){
		int ans=0;
		for(int i=0,end=str.length;i<end;i++){	
			if(s==str[i]){
				ans= i;
			}else{
				ans= -1;
			}
			
		}
		return ans;
	}
}
