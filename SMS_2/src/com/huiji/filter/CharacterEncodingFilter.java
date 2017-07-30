package com.huiji.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import com.huiji.filter.EncodingHttpServletRequest;
@WebFilter(urlPatterns="/*",initParams=@WebInitParam(name="encoding",value="utf-8"))
public class CharacterEncodingFilter implements Filter {
	
	private String encoding;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		if("GET".equalsIgnoreCase(httpRequest.getMethod())){
			EncodingHttpServletRequest wrapper = new EncodingHttpServletRequest(httpRequest, encoding);
			chain.doFilter(wrapper, response);
		}else{
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding=config.getInitParameter("encoding");
	}

}
