package cn.myframe.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JScrollPane scrollPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton1 = new JButton("开始");
		btnNewButton1.setBounds(550, 40, 82, 51);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	
				通过在文本框输入具体的目录。将目录中的当前文件或者文件夹的名称列出到文本框中
				思路：
					获取文本框中的路径
					将路径封装成File对象，list();
					将list()列表中的内容展现在文本区域中
					
				方法：
					1、获取路径。通过文本框对象完成
					String str_dir=textField.getText();
					
					2、
					
				
			*/	
				showDirs();
			}

			public void showDirs() {
//				1、获取路径。通过文本框对象完成
				String str_dir=textField1.getText();
				
//				2、将字符串路径封装成对象
				File dir=new File(str_dir);
//				判断
				if(dir.exists() && dir.isDirectory()){
//					清空文本区域
					textField.setText("");
//					获取文件名称列表
					String[] names=dir.list();
					System.out.println("next:"+names);
					for(String name:names){
					
//						textField.append();
//						将名字显示到文本区域中
						textField.setText(name);
					}
				}
				System.out.println(str_dir);
			}
			
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton1);
		
		textField1 = new JTextField();//显示框
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				    if(e.getKeyCode()==KeyEvent.VK_ENTER){
				    	System.out.println(e+"谁知道哪儿不对！");
				    }
			}

			
		});
		textField1.setBounds(58, 40, 419, 51);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 101, 574, 317);
		contentPane.add(scrollPane);
		
		textField = new JTextField();//输入框
		textField.setText("  ");
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
	}
}
