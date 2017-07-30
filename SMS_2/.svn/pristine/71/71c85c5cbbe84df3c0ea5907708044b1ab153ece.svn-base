package com.huiji.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huiji.po.Student;
import com.huiji.service.StudentService;


@WebServlet(urlPatterns="/servlet/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取表单里面的值 
		int id = Integer.parseInt(req.getParameter("id")) ;
		String name =req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String birthday = req.getParameter("birthday");
		String address = req.getParameter("address");
		String tel = req.getParameter("tel");
		String des =req.getParameter("des");
		
		Student stu = new Student(id,name,age,birthday,address,tel,des);
		
		StudentService service = new StudentService();
		service.addStudent(stu);
		
		resp.sendRedirect("ShowServlet");
	}
}
