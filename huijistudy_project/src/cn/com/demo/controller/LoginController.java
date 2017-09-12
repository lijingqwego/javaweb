package cn.com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.User;
import cn.com.demo.po.UserCustom;
import cn.com.demo.service.UserService;
import cn.com.demo.utils.UserSecurity;

@Controller
public class LoginController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 登录
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
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/loginOut")
	public String loginOut(HttpSession session){
		if(session!=null){
			session.removeAttribute("user");
			session.invalidate();
		}
		return "base.logout";
	}
	
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping(value="/regiestView")
	public ModelAndView regiestView(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("base.regist");
		return mv;
	}
	
	/**
	 * 检查账号是否可用
	 * @param empName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkLoginid")
	public Map<String,String> checkAccount(@RequestParam("loginid")String loginid) {
		String result="";
		//先判断用户名是否是合法的表达式
		String regx="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!(loginid.matches(regx))){
			result="用户名必须是6-16位数字和字母的组合或者2-5位中文";
		}else{
			//数据库用户名重复校验
			int count = userService.findUserByLoginid(loginid);
			if(count==0){
				result="success";
			}else{
				result="用户名不可用";
			}
		}
		//将结果以map的形式发送到ajax
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", result);
		return map;
			
	}
	
	/**
	 * 注册用户
	 */
	@ResponseBody
	@RequestMapping("/registUser")
	public String registUser(User user){
		userService.registUser(user);
		return "success";
	}
}
