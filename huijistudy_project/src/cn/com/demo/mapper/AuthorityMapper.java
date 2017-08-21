package cn.com.demo.mapper;

import java.util.List;
import java.util.Map;

import cn.com.demo.po.Authority;

public interface AuthorityMapper {
    
	List<Authority> findAuthorityList();

	void delAuthorById(String authorityid);

	Authority findAuthorById(String authorityid);

	void updAuthor(Authority author);

	String getAuthorId();

	void addAuthor(Authority author);
	
	int getAuthorCount(Authority authority);
	
	List<Authority> findAuthorListByPage(Map<String,Object> map);

	void authorEnable(Authority authority);
}