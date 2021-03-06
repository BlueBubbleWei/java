package cn.myframe.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class MyMenu extends JFrame {
	private JTextField textField1;
	private JScrollPane scrollPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMenu frame = new MyMenu();
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
	public MyMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 466);
		JPanel contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.RED);
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("文件");
		menu.setBackground(Color.DARK_GRAY);
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("打开菜单项");
		menu.add(menu_1);
		
		JMenu menu_2 = new JMenu("哈哈哈");
		menu.add(menu_2);
		
		JMenu menu_3 = new JMenu("关闭文件");
		menu_3.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		menu.add(menu_3);
	}
}
