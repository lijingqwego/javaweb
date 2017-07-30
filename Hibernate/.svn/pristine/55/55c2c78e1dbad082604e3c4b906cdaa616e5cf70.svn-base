package com.huiji.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.huiji.po.Employee;
import com.huiji.utils.HibernateUtil;
import com.huiji.utils.JsonUtil;

@WebServlet(urlPatterns="/servlet/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> list = null;
		try {
			Session session = HibernateUtil.getSession();
			Query query = session.createQuery("from Employee");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		String jsonList = JsonUtil.bean2Json(list);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		writer.write(jsonList);
		
		writer.flush();
		
		writer.close();
		
	}
}
