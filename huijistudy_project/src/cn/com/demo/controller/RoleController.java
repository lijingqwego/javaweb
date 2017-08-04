package cn.com.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.Role;
import cn.com.demo.service.RoleService;
@RequestMapping("/role")
@Controller
public class RoleController {
	@Resource
	private RoleService roleService;
	@RequestMapping("/roleList")
	public ModelAndView roleList(){
		
		List<Role> list = roleService.findRoleList();
		
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("roleList", list);
		
		mv.setViewName("role.rolelist");
		
		return mv;
	}
	
	
	@RequestMapping("/delRole")
	public String delRole(String roleid){
		roleService.delRoleById(roleid);
		return "redirect:/role/roleList.action";
	}
	
	@RequestMapping("/findRole")
	public ModelAndView findRole(String roleid){
		
		Role role = roleService.findRoleById(roleid);
		
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("role", role);
		
		mv.setViewName("role.updRole");
		
		return mv;
	}
	
	
	@RequestMapping("/updRole")
	public String updRole(Role role){
		
		roleService.updRole(role);
			
		return "redirect:/role/roleList.action";
	}
}
