package com.huiji.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Object object = req.getSession().getAttribute("user");
		String path = req.getRequestURI();
		// ���������1.�ڵ�¼ҳ�档2.δ�ڵ�¼ҳ��
		if (isFilter(path)) {
			chain.doFilter(request, response);
		} else {
			if (object == null) {
				//obj==null��˵���û�û�õ�¼�����˵�¼ҳ�治��Ҫ����
				if(path.contains(".jsp")){
					resp.sendRedirect("login.jsp");
				}else{
					resp.sendRedirect("../login.jsp");
				}
			}else{
				chain.doFilter(request, response);
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param path
	 * @return true��ʾ��Ҫ���ˣ�false��Ҫ����
	 */
	private boolean isFilter(String path) {
		boolean flag = false;
		String[] str = { "login.jsp", "LoginServlet", ".css", ".js" };
		for (int i = 0; i < str.length; i++) {
			if (path.contains(str[i])) {
				flag = true;
				break;
			}
		}
		return flag;
	}

}
