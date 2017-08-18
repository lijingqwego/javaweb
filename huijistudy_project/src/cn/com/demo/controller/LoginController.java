package cn.com.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.UserCustom;
import cn.com.demo.service.UserService;
import cn.com.demo.utils.UserSecurity;

@Controller
public class LoginController {
	
	@Resource
	private UserService userService;
	
	/**
	 * µÇÂ¼
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/loginLocale")
	public ModelAndView loginLocale(HttpSession session){
		UserCustom user = UserSecurity.getSecurityUser();
		ModelAndView mv = new ModelAndView();
		if(user!=null && user.getUserid()!=null){
			session.setAttribute("user", user);
			userService.updLoginInfo(user.getUserid());
			mv.setViewName("base.definition");
		}else{
			mv.setViewName("base.logout");
		}
		return mv ;
	}
	
	/**
	 * ÍË³öµÇÂ¼
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/loginOt")
	public String loginOt(HttpSession session){
		if(session!=null){
			session.removeAttribute("user");
			session.invalidate();
		}
		return "base.logout";
	}
}
