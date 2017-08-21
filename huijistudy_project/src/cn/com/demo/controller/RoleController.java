package cn.com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.Role;
import cn.com.demo.service.RoleService;
import cn.com.demo.utils.PageBean;
@RequestMapping("/role")
@Controller
public class RoleController {
	@Resource
	private RoleService roleService;
	@RequestMapping("/roleList")
	public ModelAndView roleList(@RequestParam(value="currPage",defaultValue="1")int currPage,String roleid,String rolename){
		Role role=new Role();
		role.setRoleid(roleid);
		role.setRolename(rolename);
		PageBean pageBean = roleService.findRoleListByPage(currPage,3,role);
		
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("roleList", pageBean.getList());
		
		mv.addObject("currPage", currPage);
		
		mv.addObject("totalPage", pageBean.getTotalPage());
		
		mv.addObject("roleid", roleid);
		
		mv.addObject("rolename", rolename);
		
		mv.setViewName("role.rolelist");
		
		return mv;
	}
	
	
	@RequestMapping("/delRole")
	public String delRole(String roleid){
		roleService.delRoleById(roleid);
		return "redirect:/role/roleList.action";
	}
	
	@RequestMapping("/findRole")
	public ModelAndView findRole(String roleid,int currPage){
		
		Role role = roleService.findRoleById(roleid);
		
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("role", role);
		
		mv.addObject("currPage", currPage);
		
		mv.setViewName("role.updRole");
		
		return mv;
	}
	
	
	@RequestMapping("/updRole")
	public String updRole(Role role,int currPage){
		
		roleService.updRole(role);
			
		return "redirect:/role/roleList.action?currPage="+currPage;
	}
	
	@RequestMapping("/addRole")
	public ModelAndView addRole(){
		
		String roleid = roleService.getRoleId();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("roleid", roleid);
		mv.setViewName("role.addRole");
		
		return mv;
	}
	
	@RequestMapping("/commAddRole")
	public String commAddRole(Role role){
		
		roleService.addRole(role);
		
		return "redirect:/role/roleList.action";
	}
	@RequestMapping("/delMoreRole")
	public String delMoreRole(String[] delitems){
		for(String roleid:delitems){
			roleService.delRoleById(roleid);
		}
		return "redirect:/role/roleList.action";
	}
	
	
	/**
	 * ½ûÓÃ/Õý³£
	 * @param roleid
	 * @return
	 */
	@RequestMapping("/roleEnable")
	public String roleEnable(String currPage,String roleid,Integer enabled){
		Role role = new Role();
		role.setRoleid(roleid);
		role.setEnabled(enabled);
		roleService.roleEnable(role);
		return "redirect:/role/roleList.action?currPage="+currPage;
	}
}
