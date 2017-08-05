package cn.com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.AuthorityOfResources;
import cn.com.demo.po.AuthorityResources;
import cn.com.demo.service.AuthorityResourceService;

@RequestMapping("/author")
@Controller
public class AuthorityResourceController {
	@Resource
	private AuthorityResourceService authorityResourceService;
	@RequestMapping("/authorofres")
	public ModelAndView authorResList(String authorityid){
		//System.out.println("=======authorofres====authorityid==============="+authorityid);
		List<AuthorityOfResources> list = authorityResourceService.findAuthorityOfResourcesById(authorityid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("authorOfResList", list);
		mv.addObject("authorityid", authorityid);
		mv.setViewName("author.authorofres");
		return mv;
	}
	
	@RequestMapping("/updAuthorOfRes")
	public String updAuthorOfRes(String authorityid,HttpServletRequest req){
		//System.out.println("========updAuthorOfRes===authorityid============"+authorityid);
		//先删除权限的资源
		authorityResourceService.delAuthorOfResByAuthorityId(authorityid);
		//插入权限关联的资源
		String[] idArr=req.getParameterValues("checked");
		List<AuthorityResources> authResList=new ArrayList<>();
		if(idArr!=null){
			for(String resource_id : idArr){
				AuthorityResources authorityResources = new AuthorityResources();
				authorityResources.setAuthorityid(authorityid);
				authorityResources.setResource_id(resource_id);
				authResList.add(authorityResources);
			}
			authorityResourceService.addAuthorOfResources(authResList);
		}
		
		return "redirect:/author/authorList.action?currPage=1";
	}
}
