package cn.com.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.User;
import cn.com.demo.service.UserService;
import cn.com.demo.utils.MD5Config;

@Controller
public class LoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/loginCheckUser")
	public @ResponseBody String loginCheckUser(String username ,String password,HttpSession session){
		//System.out.println("===========username===="+username+"======passowrd====="+password);
		String md5Password = MD5Config.md5(password);
		//System.out.println("===========md5====username"+username+"====passowrd======"+md5Password);
		User user=userService.loginUser(username,md5Password);
		//将用户对象保存到Session中
		session.setAttribute("user", user);
		if(user!=null){
			return "success"; 
		}else{
			return "fail";
		}
	}
	@RequestMapping(value="/login")
	public  ModelAndView login(String username ,String password){
		//System.out.println(username);
		//System.out.println(password);
		userService.updLoginInfo(username);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("base.definition");
		return mv ; 
	}
	
	@RequestMapping(value="/enterLayout")
	public ModelAndView enterLayout(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("base.definition");
		return mv ;
	}
}
