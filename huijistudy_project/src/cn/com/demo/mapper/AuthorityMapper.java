package cn.com.demo.mapper;

import java.util.List;

import cn.com.demo.po.Authority;
import cn.com.demo.utils.PageBeanVO;

public interface AuthorityMapper {
    
	List<Authority> findAuthorityList();

	void delAuthorById(String authorityid);

	Authority findAuthorById(String authorityid);

	void updAuthor(Authority author);

	String getAuthorId();

	void addAuthor(Authority author);
	
	int getAuthorCount(PageBeanVO pageBean);
	
	List<Authority> findAuthorListByPage(PageBeanVO pageBean);

	void authorEnable(Authority authority);
}