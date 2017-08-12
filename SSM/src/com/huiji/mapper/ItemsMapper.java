package com.huiji.mapper;

import java.util.List;

import com.huiji.po.Items;
import com.huiji.po.PageBean;

public interface ItemsMapper {
	
	Items findItemsById(Long id);
	
	List<Items> findItemsList(Items items);
	
	List<Items> findItemsListAll();
	
	//��ҳ��ѯ��Ʒ
	List<Items> findItemsList(PageBean pageBean);
	//��ȡ��Ʒ������
	int getItemsCount();
	
	void updItemsById(Items items);
	
	void addItems(Items items);
	
	void delItems(Long id);
}
