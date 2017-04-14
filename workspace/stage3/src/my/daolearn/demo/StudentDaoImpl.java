package my.daolearn.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class StudentDaoImpl implements StudentDao{

	@Override
	public void saveStudent(Student stu) {
		// TODO Auto-generated method stub
		try {
			Document document=getDocument();
			Element root=document.getRootElement();
//			4、在根元素上添加student子元素，添加属性
			Element studentEle=root.addElement("student").addAttribute("number", stu.getNumber());
//			5、在student上添加name,age,sex子元素并添加内容
			studentEle.addElement("name").setText(stu.getName());
			studentEle.addElement("age").setText(stu.getAge());
			studentEle.addElement("sex").setText(stu.getSex());
			save2File(document);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void save2File(Document document) throws IOException {
		// TODO Auto-generated method stub
//		6、回写
//		创建OutputFormat
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
//		创建xmlwriter
		XMLWriter writer=new XMLWriter(new FileOutputStream("src/student_dao.xml"),format);
//		写入
		writer.write(document);
//		释放资源
		writer.close();
	}

	private Document getDocument() throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader=new SAXReader();
//		加载xml文件==>doc
		Document document=reader.read(new File("src/student_dao.xml"));
//		获得根元素
		return document;
	}

	@Override
	public void deleteStudent(String number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student student2=getStudentByNumber(student.getNumber());//删除之前先查一下
		if(student2==null){
			return;
		}
		deleteStudent(student.getNumber());
		saveStudent(student);
		
	}

	@Override
	public Student getStudentByNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
