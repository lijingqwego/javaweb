package cn.com.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.Authority;
import cn.com.demo.service.AuthorityService;

@RequestMapping("/author")
@Controller
public class AuthorityController {
	
	@Resource
	private AuthorityService authorityService;
	
	@RequestMapping("/authorList")
	public ModelAndView authorList(){
		List<Authority> list = authorityService.findAuthorityList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("authorList", list);
		mv.setViewName("author.authorlist");
		return mv;
	}
	
	@RequestMapping("/delAuthor")
	public String delAuthor(String authorityid){
		authorityService.delAuthorById(authorityid);
		return "redirect:/author/authorList.action";
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
	public String updAuthor(Authority author){
		
		authorityService.updAuthor(author);
		
		return "redirect:/author/authorList.action";
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
	public String commAddAuthor(Authority author){
		authorityService.addAuthor(author);
		return "redirect:/author/authorList.action";
	}
}
