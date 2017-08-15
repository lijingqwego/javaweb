package cn.com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.RoleAuthority;
import cn.com.demo.po.RoleOfAuthority;
import cn.com.demo.service.RoleAuthorityService;

@RequestMapping("/role")
@Controller
public class RoleAuthorityController {
	@Resource
	private RoleAuthorityService roleAuthorityService; 
	
	@RequestMapping("/roleOfAuthor")
	public ModelAndView userOfRoleList(String roleid,int currPage){
		List<RoleOfAuthority> list=roleAuthorityService.findRoleOfAuthorByRoleId(roleid);
		ModelAndView mv=new ModelAndView();
		mv.addObject("roleid", roleid);
		mv.addObject("currPage", currPage);
		mv.addObject("roleOfAuthorList", list);
		mv.setViewName("role.roleofauthor");
		return mv;
	}
	
	@RequestMapping("/updRoleOfAuthor")
	public String updRoleOfAuthor(String roleid,int currPage,HttpServletRequest req){
		//先删除用户的角色
		roleAuthorityService.delRoleOfAuthorByRoleId(roleid);
		//插入用户关联的角色
		String[] idArr=req.getParameterValues("checked");
		List<RoleAuthority> roleAuthorList=new ArrayList<>();
		if(idArr!=null){
			for(String authorityid : idArr){
				RoleAuthority roleAuthor=new RoleAuthority();
				roleAuthor.setAuthorityid(authorityid);
				roleAuthor.setRoleid(roleid);
				roleAuthorList.add(roleAuthor);
			}
			roleAuthorityService.addRoleOfAuthor(roleAuthorList);
		}
		
		return "redirect:/role/roleList.action?currPage="+currPage;
	}
}
