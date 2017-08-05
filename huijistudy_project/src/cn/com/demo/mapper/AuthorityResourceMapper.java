package cn.com.demo.mapper;

import java.util.List;

import cn.com.demo.po.AuthorityOfResources;
import cn.com.demo.po.AuthorityResources;

public interface AuthorityResourceMapper {

	
	/**
	 * ����authorityid��ѯ������Դ
	 */
	List<AuthorityOfResources> findAuthorityOfResourcesById(String authorityid);
	
	/**
	 * ����Ȩ��authorityidɾ��������Դ
	 * @param authorityid
	 */
	void delAuthorOfResByAuthorityId(String authorityid);

	/**
	 * Ȩ�޹�����Դ
	 * @param list
	 */
	void addAuthorOfResource(List<AuthorityResources> list);
}
