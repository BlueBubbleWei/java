package cn.iolearn.demo;

public class Student implements Comparable<Student>{
	private String name;
	private int math,chinese,english;
	private int sum;
	/**
	 * @param name
	 * @param math
	 * @param chinese
	 * @param english
	 */
	public Student(String name, int math, int chinese, int english) {
		super();
		this.name = name;
		this.math = math;
		this.chinese = chinese;
		this.english = english;
		this.sum=math+chinese+english;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sum != other.sum)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override  
//	判断总分和姓名
	public int compareTo(Student o) {
		int temp=this.sum-o.sum;
		return temp==0?this.name.compareTo(o.name):temp;
	}
	
	
	
}
