package com.huiji.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huiji.po.Student;
import com.huiji.service.StudentService;


@WebServlet(urlPatterns="/servlet/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentService service = new StudentService();
		List<Student> list = service.queryStudent(id);
		req.setAttribute("stu",list.get(0));
		req.getRequestDispatcher("../update.jsp").forward(req, resp);
	}
}
