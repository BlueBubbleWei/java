package my.servletlearn.generic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CServlet extends MyGenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String servletName=getServletConfig().getServletName();
		String servletName=getServletName();
//		String param=getInitParameter("name");
		arg1.getWriter().print(servletName);
	}

//	重新init方法
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("哈哈哈");
		super.init(config);
	}

}
