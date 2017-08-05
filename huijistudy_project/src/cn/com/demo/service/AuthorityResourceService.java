package cn.com.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.AuthorityResourceMapper;
import cn.com.demo.po.AuthorityOfResources;
import cn.com.demo.po.AuthorityResources;

@Service
public class AuthorityResourceService {
	@Resource
	private AuthorityResourceMapper authorityOfResourceMapper;
	/**
	 * ����authorityid��ѯ������Դ
	 * @param authorityid
	 * @return
	 */
	public List<AuthorityOfResources> findAuthorityOfResourcesById(String authorityid){
		return authorityOfResourceMapper.findAuthorityOfResourcesById(authorityid);
	}
	
	/**
	 * Ȩ�޹�����Դ
	 * @param list
	 */
	public void addAuthorOfResources(List<AuthorityResources> list){
		//2.�����Դ
		authorityOfResourceMapper.addAuthorOfResource(list);
		
	}
	/**
	 * ����authorityidɾ����Ȩ�����е���Դ
	 * @param authorityid
	 */
	public void delAuthorOfResByAuthorityId(String authorityid){
		//1.��ɾ����Ȩ�޹����ı�
		authorityOfResourceMapper.delAuthorOfResByAuthorityId(authorityid);
	}

}
