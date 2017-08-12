package com.huiji.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huiji.po.Items;
import com.huiji.po.PageBean;
import com.huiji.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Resource
	private ItemsService itemsService;
	
	private int pageSize=3;

	/**
	 * 显示所有商品列表，显示页面
	 * @return
	 */
	@RequestMapping("/itemslist")
	public String itemsList(int currPage,Model model){
		// 总条数
		int userCount = itemsService.getItemsCount();
		// 总页数
		int pageCount = (int) Math.ceil(userCount * 1.0 / pageSize);
		PageBean pageBean = new PageBean();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);

		List<Items> list = itemsService.findItemsList(pageBean);
		model.addAttribute("itemsList", list);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
				
		return "items.itemslist";
	}
	
	/**
	 * 根据id查询商品，显示页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/finditems")
	public String findItems(Long id,Model model){
		Items items = itemsService.findItemsById(id);
		model.addAttribute("items", items);
		return "items.itemsupd";
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
	public String addItems(){
		return "items.itemsadd";
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
