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
	 * ��ʾ������Ʒ�б���ʾҳ��
	 * @return
	 */
	@RequestMapping("/itemslist")
	public String itemsList(int currPage,Model model){
		// ������
		int userCount = itemsService.getItemsCount();
		// ��ҳ��
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
	 * ����id��ѯ��Ʒ����ʾҳ��
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
	public String addItems(){
		return "items.itemsadd";
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
