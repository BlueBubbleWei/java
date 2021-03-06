package cn.myframe.demo;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameDemo {
	/**
	* @param args
	* 需求：想要点击按钮有鲜果，比如打印一句话
	* 思路：
	* 	确定事件源：按钮
	* 	确定监听器。按钮添加监听器，按钮对象组清楚。到按钮对象中查找
	* 	定义处理模式
	* 	
	*定义规范：XXXListener:XXX监听器 --对应的XXXEvent事件
	*
	*在按钮上添加所需的监听器
	*
	*需求：想要实现点击窗体X就可以实现窗体的关闭
	*思路：
	*	事件源：窗体
	*	监听器：通过窗口对象去查
	*	事件处理
	* 	
	*到底哪些监听接口有适配器类啊？
	*只要监听接口中的方法在2个以内，都没有适配器类。适配器的出现只为方便创建监听器对象
	*
	*但是一般监听接口都有适配器
	*/
	public static void main(String[] args) {
//		创建一个窗体
		Frame frame=new Frame("My Frame");
		//设置窗体
		createFrame(frame);
//		给窗体添加按钮组件
		createButton(frame);
//		给窗体添加文本框组件
		createTextBox(frame);
//		关闭窗体
		closeFrame(frame);

		System.out.println("over");
	}

	/**
	 * @param frame
	 */
	private static void createTextBox(Frame frame) {
		/**
		 * 
		 */
//		加入一个文本框组件
		TextField textField=new TextField(40);
//		将组件添加到窗体中
		frame.add(textField);//要注意添加的顺序
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
		/*		
//				如何获取录入的内容，通过键盘事件对象获取
				char key=e.getKeyChar();
				int code=e.getKeyCode();
				System.out.println(key+":"+code+KeyEvent.getKeyText(code));
			*/
			/*	
				int code=e.getKeyCode();
				if(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9){
					System.out.println("必须是0-9的数字");
					e.consume();//直接取消默认处理方式
				}
			*/	
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					System.out.println("enter run!");
				}
				if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ENTER){
					System.out.println("ctrl+enter run");
				}
			}
			
		});
	}

	/**
	 * @param frame
	 */
	private static void closeFrame(Frame frame) {
		/*
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.out.println("Closing");
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
			}
		});
	*/	
//		另一种快捷方法
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				System.out.println("Closing");
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("孔雀开屏");
			}
			
		});
	}

	/**
	 * @param frame
	 */
	private static void createButton(Frame frame) {
		Button button=new Button("MyButton");
//		button.setSize(20, 20);
		
//		将组件添加到窗体中
		frame.add(button);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("按钮被触发了"+e);//触发处理事件
//				System.exit(0);//退出程序
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 5; j++) {
						System.out.print("*");
					}
					System.out.println();
					
				}
			}
		});
		/*	
		演示鼠标监听
		按钮事件源
		鼠标监听器注册到按钮上
		组件 .addXXXListener(new XXXAdapter){
			
		}
	*/
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
//				想要对鼠标双击进行处理，应该找鼠标事件对象。因为事件对象一产生，内部必然封装事件源以及事件相关内容
//				要查MouseEvent
				if(e.getClickCount()==2){
					System.out.println("mouse click");	
				}
			}
			
		});
	}

	/**
	 * 
	 */
	private static void createFrame(Frame frame) {
		frame.setVisible(true);//设置窗体可见
//		对窗体进行基本设置
		frame.setSize(500,400);//width:500,height:400
		frame.setLocation(400, 500);//pageX  pageY
		
//		设置布局
		frame.setLayout(new FlowLayout());//创建流式布局    让下面的button自适应大小
		
	}
}
