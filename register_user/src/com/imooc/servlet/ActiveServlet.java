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
		//���ռ�����
		String code = request.getParameter("code");
		
		//���ݼ������ѯ�û�
		UserService userService=new UserServiceImpl();
		
		//�Ѿ��鵽���޸��û���״̬
		try {
			User user=userService.findUserByCode(code);
			
			if(user !=null){
				//�鵽�û����޸��û���״̬
				user.setState(1);
				user.setCode("");
				userService.update(user);
				request.setAttribute("message", "���Ѽ���ɹ�����ȥ��¼��");
			}else{
				request.setAttribute("message", "���ļ��������������¼��");
			}
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
