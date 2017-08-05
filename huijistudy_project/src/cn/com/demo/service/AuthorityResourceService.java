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
	 * 根据authorityid查询所有资源
	 * @param authorityid
	 * @return
	 */
	public List<AuthorityOfResources> findAuthorityOfResourcesById(String authorityid){
		return authorityOfResourceMapper.findAuthorityOfResourcesById(authorityid);
	}
	
	/**
	 * 权限关联资源
	 * @param list
	 */
	public void addAuthorOfResources(List<AuthorityResources> list){
		//2.添加资源
		authorityOfResourceMapper.addAuthorOfResource(list);
		
	}
	/**
	 * 根据authorityid删除该权限所有的资源
	 * @param authorityid
	 */
	public void delAuthorOfResByAuthorityId(String authorityid){
		//1.先删除该权限关联的表
		authorityOfResourceMapper.delAuthorOfResByAuthorityId(authorityid);
	}

}
