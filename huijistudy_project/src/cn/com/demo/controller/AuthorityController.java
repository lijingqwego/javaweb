package cn.com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.Authority;
import cn.com.demo.service.AuthorityService;
import cn.com.demo.utils.AuthorityFunctionUtils;
import cn.com.demo.utils.PageBean;

@RequestMapping("/author")
@Controller
public class AuthorityController {
	
	@Resource
	private AuthorityService authorityService;
	
	@RequestMapping("/authorList")
	public ModelAndView authorList(@RequestParam(value="currPage",defaultValue="1")int currPage,String authorityid,String authorityname){
		
		Authority authority=new Authority();
		authority.setAuthorityid(authorityid);
		authority.setAuthorityname(authorityname);
		
		PageBean page = authorityService.findAuthorListByPage(currPage,3,authority);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("authorList", page.getList());
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", page.getTotalPage());
		mv.addObject("authorityid", authorityid);
		mv.addObject("authorityname", authorityname);
		mv.setViewName("author.authorlist");
		return mv;
	}
	
	@RequestMapping("/delAuthor")
	public String delAuthor(String authorityid){
		authorityService.delAuthorById(authorityid);
		return "redirect:/author/authorList.action";
	}
	
	@RequestMapping("/findAuthor")
	public ModelAndView findAuthor(String authorityid,int currPage){
		Authority author = authorityService.findAuthorById(authorityid);
		ModelAndView mv=new ModelAndView();
		mv.addObject("author", author);
		mv.addObject("currPage", currPage);
		mv.setViewName("author.updauthor");
		return mv;
	}
	
	
	@RequestMapping("/updAuthor")
	public String updAuthor(Authority author,int currPage,String[] function){
		String fun = AuthorityFunctionUtils.appendCode(function);
		String funName=AuthorityFunctionUtils.appendName(function);
		author.setFunction(fun);
		author.setFunctionname(funName);
		authorityService.updAuthor(author);
		
		return "redirect:/author/authorList.action?currPage="+currPage;
	}
	
	@RequestMapping("/getAuthorId")
	public ModelAndView getAuthorId(){
		String id=authorityService.getAuthorId();
		ModelAndView mv = new ModelAndView();
		mv.addObject("authorityid", id);
		mv.setViewName("authro.addAuthor");
		return mv;
	}
	
	@RequestMapping("/commAddAuthor")
	public String commAddAuthor(Authority author,String[] function){
		String fun = AuthorityFunctionUtils.appendCode(function);
		String funName=AuthorityFunctionUtils.appendName(function);
		author.setFunction(fun);
		author.setFunctionname(funName);
		authorityService.addAuthor(author);
		return "redirect:/author/authorList.action";
	}
	
	@RequestMapping("/delMoreAuthor")
	public String delMoreAuthor(String[] delitems){
		for(String authorityid:delitems){
			authorityService.delAuthorById(authorityid);
		}
		return "redirect:/author/authorList.action";
	}
	
	/**
	 * ½ûÓÃ/Õý³£
	 * @param authorityid
	 * @return
	 */
	@RequestMapping("/authorEnable")
	public String authorEnable(String currPage,String authorityid,Integer enabled){
		Authority authority = new Authority();
		authority.setAuthorityid(authorityid);
		authority.setEnabled(enabled);
		authorityService.authorEnable(authority);
		return "redirect:/author/authorList.action?currPage="+currPage;
	}
	
}
