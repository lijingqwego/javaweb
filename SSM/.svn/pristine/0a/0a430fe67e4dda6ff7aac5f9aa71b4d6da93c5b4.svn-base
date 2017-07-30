package com.huiji.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.huiji.po.Items;
import com.huiji.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Resource
	private ItemsService itemsService;

	/**
	 * 显示所有商品列表，显示页面
	 * @return
	 */
	@RequestMapping("/itemslist")
	public ModelAndView itemsList(){
		List<Items> itemsList = itemsService.findItemsListAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/itemslist");
		return modelAndView;
	}
	
	/**
	 * 根据id查询商品，显示页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/finditems")
	public ModelAndView findItems(Long id){
		Items items = itemsService.findItemsById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("items", items);
		modelAndView.setViewName("items/itemsupd");
		return modelAndView;
	}
	
	/**
	 * 修改商品信息
	 * @param items
	 * @return
	 */
	@RequestMapping("/itemsupd")
	public String updItems(Items items){
		itemsService.updItemsById(items);
		return "redirect:itemslist.action";
	}
	
	/**
	 * 添加商品页面
	 * @return
	 */
	@RequestMapping("/additems")
	public ModelAndView addItems(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("items/itemsadd");
		return modelAndView;
	}
	
	/**
	 * 添加商品
	 * @param items
	 * @return
	 */
	@RequestMapping("/commitems")
	public String commItems(Items items){
		itemsService.addItems(items);
		return "redirect:itemslist.action";
	}
	
	/**
	 * 根据ID删除商品
	 * @param id
	 * @return
	 */
	@RequestMapping("/delitems")
	public String delItems(Long id){
		itemsService.delItems(id);
		return "redirect:itemslist.action";
	}
}
