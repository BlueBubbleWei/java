package com.example.helloworld;

//Object是所有类的
public class Static_Annonyous {
	public static void main(String[] args) {
		Bi bilaoye =new BiLaoYe();//向上转型
		bilaoye.Lecture();
//		要想使用毕老师的特有方法  看电影		
		BiLaoYe bilaosi =(BiLaoYe) bilaoye;//向下转型
		bilaosi.Lecture();
	}
}
/*
毕姥爷
	讲课
	钓鱼
毕老师 extends 毕姥爷
	讲课
	看电影
要求体现多态
要看到向上转型  向下转型
转型过程中，至始至终，只有子类对象在做着类型的变化
*/

class Bi{
	public void Lecture(){
		System.out.println("讲课");
	}
}

class BiLaoYe extends Bi{
	public void DiaoYu(){
		
	}
}
class BiLaoShi extends Bi{
	public void WatchMovies(){
		System.out.println("电影");
	}
}

/*阶段一：
描述笔记本电脑*/

class NoteBook{
	public void run(){
		System.out.print("Computer");
	}
}

/*class USBTest{
	
}
*/









