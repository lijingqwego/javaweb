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
	 * ��¼
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
	 * �˳���¼
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
	 * ע��ҳ��
	 * @return
	 */
	@RequestMapping(value="/regiestView")
	public ModelAndView regiestView(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("base.regist");
		return mv;
	}
	
	/**
	 * ����˺��Ƿ����
	 * @param empName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkLoginid")
	public Map<String,String> checkAccount(@RequestParam("loginid")String loginid) {
		String result="";
		//���ж��û����Ƿ��ǺϷ��ı��ʽ
		String regx="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!(loginid.matches(regx))){
			result="�û���������6-16λ���ֺ���ĸ����ϻ���2-5λ����";
		}else{
			//���ݿ��û����ظ�У��
			int count = userService.findUserByLoginid(loginid);
			if(count==0){
				result="success";
			}else{
				result="�û���������";
			}
		}
		//�������map����ʽ���͵�ajax
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", result);
		return map;
			
	}
	
	/**
	 * ע���û�
	 */
	@ResponseBody
	@RequestMapping("/registUser")
	public String registUser(User user){
		userService.registUser(user);
		return "success";
	}
}
