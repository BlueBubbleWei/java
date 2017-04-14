package my.xmlparse.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.jar.Attributes.Name;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.omg.PortableInterceptor.AdapterManagerIdHelper;

//增加一个学生元素 003 小王八 2 男
public class Demo3 {
	public static void main(String[] args) {
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(new File("src/students.xml"));
//			获得根元素
			Element root=document.getRootElement();
//			添加element,添加number属性
			Element stuEle=root.addElement("student").addAttribute("number", "003");
//			添加name age sex子元素并添加子元素中的文本
			stuEle.addElement("name").addText("小王八");
			stuEle.addElement("age").addText("2");
			stuEle.addElement("sex").addText("男");
//			将document对象写到文件中
//			创建格式化器
			OutputFormat format=OutputFormat.createPrettyPrint();
			try {
				format.setEncoding("utf-8");//改方法设置文档的encoding 方法
//				创建写入器
//				XMLWriter writer=new XMLWriter(new FileWriter("src/students_copy.xml"),format);
//				XMLWriter writer=new XMLWriter(new PrintWriter("src/students_copy.xml","utf-8"),format);
				XMLWriter writer=new XMLWriter(new FileOutputStream("src/students_copy.xml"),format);//使用字节流绝对不会出现乱码
//				写入
				writer.write(document);
//				关闭资源
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			添加name,age,sex子元素，并添加子元素中的文本
//			将dom对象写到文件中
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
