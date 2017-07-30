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
		// 两种情况：1.在登录页面。2.未在登录页面
		if (isFilter(path)) {
			chain.doFilter(request, response);
		} else {
			if (object == null) {
				//obj==null，说明用户没用登录，除了登录页面不需要过滤
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
	 * @return true表示不要过滤，false需要过滤
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
