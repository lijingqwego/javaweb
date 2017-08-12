package cn.com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.Authority;
import cn.com.demo.service.AuthorityService;
import cn.com.demo.utils.PageBeanVO;
import cn.com.demo.utils.StringUtils;

@RequestMapping("/author")
@Controller
public class AuthorityController {
	
	@Resource
	private AuthorityService authorityService;
	
	@RequestMapping("/authorList")
	public ModelAndView authorList(int currPage,String authorityid,String authorityname){
		PageBeanVO page = authorityService.findAuthorListByPage(currPage, authorityid, authorityname);
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
		return "redirect:/author/authorList.action?currPage=1";
	}
	
	@RequestMapping("/findAuthor")
	public ModelAndView findAuthor(String authorityid){
		Authority author = authorityService.findAuthorById(authorityid);
		ModelAndView mv=new ModelAndView();
		mv.addObject("author", author);
		mv.setViewName("author.updauthor");
		return mv;
	}
	
	
	@RequestMapping("/updAuthor")
	public String updAuthor(Authority author,String[] function){
		String f = StringUtils.appendStr(function);
		author.setFunction(f);
		authorityService.updAuthor(author);
		
		return "redirect:/author/authorList.action?currPage=1";
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
		String f = StringUtils.appendStr(function);
		author.setFunction(f);
		authorityService.addAuthor(author);
		return "redirect:/author/authorList.action?currPage=1";
	}
	
	@RequestMapping("/delMoreAuthor")
	public String delMoreAuthor(String[] delitems){
		for(String authorityid:delitems){
			authorityService.delAuthorById(authorityid);
		}
		return "redirect:/author/authorList.action?currPage=1";
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
