package com.huiji.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiji.mapper.ItemsMapper;
import com.huiji.po.Items;
import com.huiji.po.PageBean;
@Service
public class ItemsService {
	@Resource
	private ItemsMapper itemsMapper;
	
	public Items findItemsById(Long id){
		return itemsMapper.findItemsById(id);
	}
	
	public List<Items> findItemsList(Items items){
		return itemsMapper.findItemsList(items);
	}
	

	public List<Items> findItemsListAll(){
		return itemsMapper.findItemsListAll();
	}
	
	public void updItemsById(Items items){
		itemsMapper.updItemsById(items);
	}
	
	public void addItems(Items items){
		itemsMapper.addItems(items);
	}
	
	public void delItems(Long id){
		itemsMapper.delItems(id);
	}

	public int getItemsCount() {
		return itemsMapper.getItemsCount();
	}

	public List<Items> findItemsList(PageBean pageBean) {
		return itemsMapper.findItemsList(pageBean);
	}
	
}
