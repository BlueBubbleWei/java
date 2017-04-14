package my.xmlparse.dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.jar.Attributes.Name;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.omg.PortableInterceptor.AdapterManagerIdHelper;

//修改一个学生 001 ==>大黑 1 female
public class Demo5 {
	public static void main(String[] args) throws Exception, FileNotFoundException {
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(new File("src/students.xml"));
//			1、定义xpath表达式
			String xpath="//student[@number=001]";
//			2、定义xpath查找
			Element studentEle=(Element) document.selectSingleNode(xpath);
//			3.修改student元素的子元素的name sex,age
			studentEle.element("name").setText("大黑");
			studentEle.element("age").setText("1");
			studentEle.element("sex").setText("女");
//			回写
			XMLWriter writer=new XMLWriter(new FileOutputStream("src/students_3.xml"),OutputFormat.createPrettyPrint());
			writer.write(document);
			writer.close();
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
