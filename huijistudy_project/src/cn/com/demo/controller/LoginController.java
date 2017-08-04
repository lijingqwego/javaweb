package cn.com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/loginCheckUser")
	public @ResponseBody String loginCheckUser(String username ,String password){
		System.out.println(username);
		System.out.println(password);
		return "success" ; 
	}
	@RequestMapping("/loginUser")
	public  ModelAndView loginUser(String username ,String password){
		System.out.println(username);
		System.out.println(password);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("base.definition");
		return mv ; 
	}
}
