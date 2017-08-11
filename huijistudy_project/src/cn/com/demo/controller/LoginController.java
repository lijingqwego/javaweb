package cn.com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.User;
import cn.com.demo.service.UserService;

@Controller
public class LoginController {
	
	@Resource
	private UserService userService;

	@RequestMapping("/loginCheckUser")
	public @ResponseBody String loginCheckUser(String username ,String password){
		System.out.println(username);
		System.out.println(password);
		User user=userService.login(username,password);
		if(user!=null){
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return "success" ; 
			}else{
				return "fail";
			}
		}
		return "fail";
	}
	@RequestMapping(value="/login")
	public  ModelAndView loginUser(String username ,String password){
		System.out.println(username);
		System.out.println(password);
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
