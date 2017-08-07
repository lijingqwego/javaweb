package cn.com.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.Resources;
import cn.com.demo.service.ResourceService;

@RequestMapping("/resource")
@Controller
public class ResourceController {

	@Resource
	private ResourceService resourceService;
	@RequestMapping("/resourceList")
	public ModelAndView resourceList(){
		
		List<Resources> list=resourceService.findResourceList();
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("resourceList", list);
		
		mv.setViewName("resource.resourcelist");
		
		return mv;
	}
	
	@RequestMapping("/addResource")
	public ModelAndView addResource(){
		String resource_id=resourceService.getResourceId();
		if(resource_id==null){
			resource_id="20000";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("resource_id", resource_id);
		mv.setViewName("resource.addResource");
		return mv;
	}
	
	@RequestMapping("/commAddResource")
	public String commAddResource(Resources resource){
		resourceService.addResource(resource);
		return "redirect:/resource/resourceList.action";
	}
	
	@RequestMapping("/delResource")
	public String delResource(String resource_id){
		resourceService.delResource(resource_id);
		return "redirect:/resource/resourceList.action";
	}
	
	@RequestMapping("/findResource")
	public ModelAndView findResource(String resource_id){
		Resources resources=resourceService.findResource(resource_id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("resource", resources);
		mv.setViewName("resource.updResource");
		return mv;
	}
	
	
	@RequestMapping("/updResource")
	public String updResource(Resources resource){
		resourceService.updResource(resource);
		return "redirect:/resource/resourceList.action";
	}
}
