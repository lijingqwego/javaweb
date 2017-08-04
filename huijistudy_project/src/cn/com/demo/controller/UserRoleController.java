package cn.com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.UserOfRole;
import cn.com.demo.po.UserRole;
import cn.com.demo.service.UserRoleService;
@RequestMapping("/user")
@Controller
public class UserRoleController {
	
	@Resource
	private UserRoleService userRoleService;
	
	@RequestMapping("/userOfRole")
	public ModelAndView userOfRoleList(String userid){
		List<UserOfRole> list=userRoleService.findUserOfRoleListByUserId(userid);
		ModelAndView mv=new ModelAndView();
		mv.addObject("userid", userid);
		mv.addObject("userOfRoleList", list);
		mv.setViewName("user.userofrole");
		return mv;
	}
	
	@RequestMapping("/updUserOfRole")
	public String updUserOfRole(String userid,HttpServletRequest req){
		//��ɾ���û��Ľ�ɫ
		userRoleService.delUserOfRoleByUserId(userid);
		//�����û������Ľ�ɫ
		String[] idArr=req.getParameterValues("checked");
		List<UserRole> userRoleList=new ArrayList<>();
		if(idArr!=null){
			for(String roleid : idArr){
					UserRole userRole=new UserRole();
					userRole.setRoleid(roleid);
					userRole.setUserid(userid);
					userRoleList.add(userRole);
			}
			userRoleService.addUserOfRole(userRoleList);
		}
		
		return "redirect:/user/userList.action?currPage=1";
	}
	
}
