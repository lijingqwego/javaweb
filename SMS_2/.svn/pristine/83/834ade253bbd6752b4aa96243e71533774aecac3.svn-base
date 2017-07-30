package com.huiji.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingHttpServletRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;
	private String encoding;

	public EncodingHttpServletRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	public EncodingHttpServletRequest(HttpServletRequest request, String encoding) {
		super(request);
		this.request = request;
		this.encoding = encoding;
	}

	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		if (value != null) {
			try {
				value = new String(value.getBytes("iso-8859-1"), encoding);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = request.getParameterValues(name);
		if (values != null) {
			int i = 0;
			for (String value : values) {
				try {
					values[i++] = new String(value.getBytes("iso-8859-1"), encoding);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		return values;
	}
}
