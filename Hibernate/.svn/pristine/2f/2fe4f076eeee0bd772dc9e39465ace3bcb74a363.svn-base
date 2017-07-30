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


@WebServlet(urlPatterns="/servlet/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		int sal = Integer.parseInt(req.getParameter("sal"));
		
		PrintWriter out = resp.getWriter();
		
		try {
			Session session = HibernateUtil.getSession();
			
			Employee employee=(Employee) session.get(Employee.class, id);
			
			employee.setEname(ename);
			employee.setJob(job);
			employee.setSal(sal);
			session.flush();
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
