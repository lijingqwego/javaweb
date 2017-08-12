package cn.com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.User;
import cn.com.demo.service.UserService;
import cn.com.demo.utils.PageBeanVO;
@RequestMapping("/user")
@Controller
public class UserController {
	@Resource
	private UserService userService;
	@RequestMapping("/userList")
	public ModelAndView userList(int currPage,String userid,String username){
		
		PageBeanVO vo = userService.findUserListByPage(currPage,userid,username);
		
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("userList", vo.getList());
		
		mv.addObject("currPage", currPage);
		
		mv.addObject("userid", userid);
		
		mv.addObject("username", username);
		
		mv.addObject("totalPage", vo.getTotalPage());
		
		mv.setViewName("user.userlist");
		
		return mv;
	}
	
	@RequestMapping("/delUser")
	public String delUser(String userid){
		userService.delUserById(userid);
		return "redirect:/user/userList.action?currPage=1";
	}
	
	/**
	 * 批量删除
	 * @param delitems
	 * @return
	 */
	@RequestMapping("/delMoreUser")
	public String delMoreUser(String delitems){
		String[] item = delitems.split(","); 
		for (int i = 0; i < item.length; i++) { 
			userService.delUserById(item[i]);
		} 
		return "redirect:/user/userList.action?currPage=1";
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/addUser")
	public ModelAndView addUser(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user.addUser");
		return mv;
	}
	
	/**
	 * 提交添加用户信息
	 * @return
	 */
	@RequestMapping("/commAddUser")
	public String commAddUser(User user){
		userService.addUser(user);
		return "redirect:/user/userList.action?currPage=1";
	}
	
	/**
	 * 查找用户根据userID
	 * @param userid
	 * @return
	 */
	@RequestMapping("/findUser")
	public ModelAndView findUser(String userid){
		
		User user = userService.findUserById(userid);
		
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("user", user);
		
		mv.setViewName("user.updUser");
		
		return mv;
	}
	
	@RequestMapping("/updUser")
	public String updUser(User user){
//		Integer userflag = user.getUserflag();
//		System.out.println("--------------------"+userflag);
		userService.updUser(user);
		
		return "redirect:/user/userList.action?currPage=1";
	}
	
	/**
	 * 禁用/正常
	 * @param userid
	 * @return
	 */
	@RequestMapping("/userEnable")
	public String userEnable(String currPage,String userid,Integer enabled){
		User user = new User();
		user.setUserid(userid);
		user.setEnabled(enabled);
		userService.userEnable(user);
		return "redirect:/user/userList.action?currPage="+currPage;
	}
}
