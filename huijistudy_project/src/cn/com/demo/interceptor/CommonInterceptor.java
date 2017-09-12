package cn.com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter {

	/**
	 * true:������
	 * false:����
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("=======preHandle========");
		Object obj = request.getSession().getAttribute("user");
//		System.out.println("===========obj==========="+obj);
		String path = request.getRequestURI();
//		System.out.println("===========path==========="+path);
		if(isColation(path)){
			return true;
		}else{ 
			if(obj==null){
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				return false;
			}else{
				return true;
			}
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("=======postHandle========");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("=======afterCompletion========");
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	/**
	 * �жϴ��ݽ����ĵ�ַ�Ƿ���Ҫ����������
	 * @param path
	 * @return
	 */
	boolean isColation(String path){
		boolean flag=false;	
		String[] strs={"login.jsp","loginLocale.action","regist.jsp","regiestView.action",".css",".js"};
		for(int i=0;i<strs.length;i++){
			if(path.contains(strs[i])){
				flag=true;
				break;
			}
		}
		
		return flag;
	}
}
