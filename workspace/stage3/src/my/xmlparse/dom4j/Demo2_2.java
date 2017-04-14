package my.xmlparse.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.omg.PortableInterceptor.AdapterManagerIdHelper;

//查询出所有学生的所有信息
public class Demo2_2 {
	public static void main(String[] args) {
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(new File("src/students.xml"));
//			首先要获得根元素
			Element root=(Element) document.getRootElement();
//			迭代根元素下的所有名叫student的子元素
			List<Element> list=root.elements("student");
			for(Element student:list){
//				Element student=iterator.next();
//				获得student元素的number属性
				String number=student.attributeValue("number");//获取的是元素的属性值
//				student子元素的内容（Name,AdapterManagerIdHelper sex）
				String name=student.elementText("name");
				String age=student.elementText("age");
				String sex=student.elementText("sex");
				System.out.println("当前学生的学号是："+number+"，姓名是："+name+"，年龄是："+age+"，性别是:"+sex);
			}
//			System.out.println(document.asXML());//将document.asXML()由xml转成String类型
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
