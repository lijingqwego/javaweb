package com.huiji.mapper;

import java.util.List;

import com.huiji.po.Items;
import com.huiji.po.PageBean;

public interface ItemsMapper {
	
	Items findItemsById(Long id);
	
	List<Items> findItemsList(Items items);
	
	List<Items> findItemsListAll();
	
	//分页查询商品
	List<Items> findItemsList(PageBean pageBean);
	//获取商品总数量
	int getItemsCount();
	
	void updItemsById(Items items);
	
	void addItems(Items items);
	
	void delItems(Long id);
}
