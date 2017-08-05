package cn.com.demo.mapper;

import java.util.List;

import cn.com.demo.po.AuthorityOfResources;
import cn.com.demo.po.AuthorityResources;

public interface AuthorityResourceMapper {

	
	/**
	 * 根据authorityid查询所有资源
	 */
	List<AuthorityOfResources> findAuthorityOfResourcesById(String authorityid);
	
	/**
	 * 根据权限authorityid删除所有资源
	 * @param authorityid
	 */
	void delAuthorOfResByAuthorityId(String authorityid);

	/**
	 * 权限关联资源
	 * @param list
	 */
	void addAuthorOfResource(List<AuthorityResources> list);
}
