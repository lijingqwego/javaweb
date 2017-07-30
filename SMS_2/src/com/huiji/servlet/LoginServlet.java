package com.huiji.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huiji.po.User;
import com.huiji.util.JsonReader;

import net.sf.json.JSONObject;


@WebServlet(urlPatterns="/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONObject json = JsonReader.stream2Json(req);
		User user=(User) JSONObject.toBean(json, User.class);
		
		if("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())){
			req.getSession().setAttribute("user", user);
			json.put("msg", "µÇÂ¼³É¹¦");
		}else{
			json.put("msg", "µÇÂ¼Ê§°Ü");
		}
		PrintWriter out = resp.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
}
