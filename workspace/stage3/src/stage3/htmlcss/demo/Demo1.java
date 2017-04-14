package stage3.htmlcss.demo;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Demo1 {
	/**
	 * 获得所有学生信息
	* @param args
	*1、获得jasp工厂
	*2、通过工厂获得解析器实现类
	*3、使用解析器加载xml文档   ===> document
	*/
	public static void main(String[] args) {
		//获得jasp工厂
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
//		通过工厂获得解析器实现
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			
//			使用解析器加载xml文档  ===>document
			Document document=builder.parse(new File("src/students.xml"));
//			获得所有学生元素的集合
			NodeList studentList=document.getElementsByTagName("student");
//			遍历集合
			for (int i = 0; i < studentList.getLength(); i++) {
				Element stuEle=(Element) studentList.item(i);
//				获得学生的number属性
				String number =stuEle.getAttribute("number");
				System.out.println("学生的学号是"+number);
//				获得学生节点下的所有子节点（包括文本在内一共7个）
				NodeList children=stuEle.getChildNodes();
//				遍历集合并提取出我们想要的name,age,sex元素对象
				for (int j = 0; j < children.getLength(); j++) {
					Node node = (Node) children.item(j);
//					方式二
					if(node.getNodeType()==Node.ELEMENT_NODE){
						Element child=(Element) node;
						if(child.getNodeName().equals("name")){
							String name=child.getTextContent();
							System.out.println("学生的姓名是"+name);
						}else if(child.getNodeName().equals("age")){
							String age=child.getTextContent();
							System.out.println("学生的年龄是"+age);
						}else if(child.getNodeName().equals("sex")){
							String sex=child.getTextContent();
							System.out.println("学生的性别是"+sex);
						}
					}
				}
			}	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
