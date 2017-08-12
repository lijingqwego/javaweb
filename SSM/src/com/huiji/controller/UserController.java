package com.huiji.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huiji.po.PageBean;
import com.huiji.po.User;
import com.huiji.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

	private int pageSize = 3;
	@Resource
	private UserService userService;

	@RequestMapping("/userlist")
	public String userList(int currPage,Model model) {
		// ������
		int userCount = userService.getUserCount();
		// ��ҳ��
		int pageCount = (int) Math.ceil(userCount * 1.0 / pageSize);

		PageBean pageBean = new PageBean();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);

		List<User> list = userService.findUserList(pageBean);
		model.addAttribute("userList", list);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		return "user.userlist";
	}

	/**
	 * ��ת����¼����
	 * @return
	 */
	@RequestMapping("/userlogin")
	public String login() {
		return "user.login";
	}

	@RequestMapping("/checkaccount")
	public void checkAccount(String username, HttpServletResponse resp) {
		try {
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			User user = new User();
			user.setUsername(username);
			User login = userService.login(user);

			if(login==null){
				login=new User();
				login.setUsername(UUID.randomUUID().toString());
			}
			if (login.getUsername().equals(username)) {
				out.println("<font color='green'>���ʺ��Ѿ�����!</font>");
			} else if ("".equals(username)) {
				out.println("<font color='red'>�Բ��𣬸��ʺŲ�����Ϊ��!</font>");
			} else {
				out.println("<font color='green'>��ϲ�������ʺſ���ʹ��!</font>");
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/checklogin")
	public String checkLogin(String username, String password, HttpServletResponse resp,HttpSession session) {
		try {
			PrintWriter out = resp.getWriter();
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			User login = userService.login(user);
			if (login.getUsername().equals(username) && login.getPassword().equals(password)) {
				session.setAttribute("user", login);
				return "base.definition";
			}
			out.println("�û���������������������룡");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "user.login";
	}

}
