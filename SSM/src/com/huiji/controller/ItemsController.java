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
	 * ��ʾ������Ʒ�б���ʾҳ��
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
	 * ����id��ѯ��Ʒ����ʾҳ��
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
	 * �޸���Ʒ��Ϣ
	 * @param items
	 * @return
	 */
	@RequestMapping("/itemsupd")
	public String updItems(Items items){
		itemsService.updItemsById(items);
		return "redirect:itemslist.action";
	}
	
	/**
	 * �����Ʒҳ��
	 * @return
	 */
	@RequestMapping("/additems")
	public ModelAndView addItems(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("items/itemsadd");
		return modelAndView;
	}
	
	/**
	 * �����Ʒ
	 * @param items
	 * @return
	 */
	@RequestMapping("/commitems")
	public String commItems(Items items){
		itemsService.addItems(items);
		return "redirect:itemslist.action";
	}
	
	/**
	 * ����IDɾ����Ʒ
	 * @param id
	 * @return
	 */
	@RequestMapping("/delitems")
	public String delItems(Long id){
		itemsService.delItems(id);
		return "redirect:itemslist.action";
	}
}
