package my.daolearn.demo;

public class Student {
	private String number;
	private String name;
	private String sex;
	private String age;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @param number
	 * @param name
	 * @param sex
	 * @param age
	 */
	public Student(String number, String name, String sex, String age) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
}
