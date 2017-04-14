package my.xmlparse.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;


public class Demo1 {
	public static void main(String[] args) {
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(new File("src/students.xml"));
			System.out.println(document.asXML());//将document.asXML()由xml转成String类型
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
