package stage3.htmlcss.demo;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Demo2 {
	public static void main(String[] args) throws Exception {
//		获得解析器工厂类
		SAXParserFactory factory=SAXParserFactory.newInstance();
//		获得解析器
		try {
			SAXParser parser=factory.newSAXParser();
			parser.parse(new File("src/students.xml"), new Myhandler());
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		解析文档
		
	}
}