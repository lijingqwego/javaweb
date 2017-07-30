package com.huiji.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.huiji.po.Employee;
import com.huiji.utils.HibernateUtil;


@WebServlet(urlPatterns="/servlet/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		try {
			Session session = HibernateUtil.getSession();
			Employee employee = (Employee) session.get(Employee.class, id);
			session.delete(employee);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		
		PrintWriter writer = response.getWriter();
		
		writer.write(200);
		
		writer.close();
		
	}

}
