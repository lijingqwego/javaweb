package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;
@WebServlet(urlPatterns="/ActiveServlet")
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收激活码
		String code = request.getParameter("code");
		
		//根据激活码查询用户
		UserService userService=new UserServiceImpl();
		
		//已经查到，修改用户的状态
		try {
			User user=userService.findUserByCode(code);
			
			if(user !=null){
				//查到用户，修改用户的状态
				user.setState(1);
				user.setCode("");
				userService.update(user);
				request.setAttribute("message", "您已激活成功，请去登录！");
			}else{
				request.setAttribute("message", "您的激活码有误，请重新激活！");
			}
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
