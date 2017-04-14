package stage3.htmlcss.demo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//获得所有学生信息并打印出来
public class Myhandler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
			System.out.println("文档开始解析啦！");
	
	}

	@Override
	//参数3告诉开发者当前的元素时那个元素
//	参数4将标签上的属性提供给你
//	SAX 1.0的版本中前两个参数没有用，永远是null
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("元素解析开始啦！");
//		判断当前元素遇到的元素是否是student元素
		if(qName.equals("student")){
			String number= attributes.getValue("number");
			System.out.println("学生的学号是："+number);
		}
	}	

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String strs=new String(ch, start, length);
		strs=strs.trim();//去掉两端的空白字符 回车 空格  制表符
		if (strs.length()>0) {
			System.out.println(strs);
		}		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName+"元素结束啦");
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("文档解析结束啦！");
	}

}
