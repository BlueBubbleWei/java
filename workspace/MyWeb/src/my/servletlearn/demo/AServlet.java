package my.servletlearn.demo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AServlet implements Servlet {
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
//		init 是在第一次请求Aservlet时调用 ===>Servlet实例的创建是在第一次访问的时候
//		servlet在多次访问时，发现只调用了1次init方法，在多次访问，只创建了一个实例
		System.out.println("ASerlet的init方法被调用！");
	}
//	当客户端请求的时候调用service,参数1 request对象封装了请求信息，参数2 response 中填入信息生成的响应
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		arg1.getWriter().print("hello world!");
		System.out.println("ASerlet的service方法被调用le！");
	}

	@Override
//	在服务器将要关闭时，会小会内存中的servlet实例，在真正小会之前会调用destroy方法
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("ASerlet方法被调用了！");
	}
	
	@Override
	
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
//	这个方法没有用
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}
