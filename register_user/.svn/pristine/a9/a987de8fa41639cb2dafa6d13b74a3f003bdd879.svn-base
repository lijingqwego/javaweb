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
import com.imooc.utils.UUIUtils;

@WebServlet(urlPatterns="/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String nickname = req.getParameter("nickname");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setEmail(email);
		user.setState(0);//0 未激活  1 已激活
		
		String code = UUIUtils.getUUID();
		user.setCode(code);
		
		UserService userService = new UserServiceImpl();
		try {
			userService.regist(user);
			
			req.setAttribute("message", "您已经注册成功，请去邮箱中激活");
			
			req.getRequestDispatcher("/message.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
