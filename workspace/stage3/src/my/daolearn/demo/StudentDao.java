package my.daolearn.demo;

import java.util.List;

//	Dao ==> Data  Access Object
public interface StudentDao {
//	増
	void saveStudent(Student stu);
//	删
	void deleteStudent(String number);
	void deleteStudent(Student student);
//	改
	void updateStudent(Student student);	
//	查
	Student getStudentByNumber(String number);
	List<Student> getAllStudent();
}
