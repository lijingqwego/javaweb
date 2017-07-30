package com.huiji.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.huiji.po.Employee;
import com.huiji.utils.HibernateUtil;

@WebServlet(urlPatterns="/servlet/AddServlet")
public class AddServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		int sal = Integer.parseInt(req.getParameter("sal"));
		
		Employee employee = new Employee(ename,job,sal);
		
		PrintWriter out = resp.getWriter();
		
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			out.write(500);
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
			out.write(200);
			out.flush();
			out.close();
		}
	}
}
