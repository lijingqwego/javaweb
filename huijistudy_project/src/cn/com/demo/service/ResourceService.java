package cn.com.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.AuthorityResourceMapper;
import cn.com.demo.mapper.ResourcesMapper;
import cn.com.demo.po.Resources;

@Service
public class ResourceService {
	
	@Resource
	private ResourcesMapper resourcesMapper;
	@Resource
	private AuthorityResourceMapper authorityResourceMapper;

	/**
	 * 查找资源列表
	 * @return
	 */
	public List<Resources> findResourceList() {
		
		return resourcesMapper.findResourceList();
	}

	/**
	 * 获取资源id
	 * @return
	 */
	public String getResourceId() {
		return resourcesMapper.getResourceId();
	}

	/**
	 * 添加资源
	 * @param resource
	 */
	public void addResource(Resources resource) {
		resourcesMapper.addResource(resource);
	}

	/**
	 * 删除资源
	 * @param resource_id
	 */
	public void delResource(String resource_id) {
		//根据资源id删除权限关联资源表
		authorityResourceMapper.delAuthorOfResByResourceId(resource_id);
		//删除资源
		resourcesMapper.delResource(resource_id);
	}

	/**
	 * 查找资源
	 * @param resource_id
	 * @return
	 */
	public Resources findResource(String resource_id) {
		return resourcesMapper.findResourceById(resource_id);
	}

	/**
	 * 修改资源
	 * @param resource
	 */
	public void updResource(Resources resource) {
		resourcesMapper.updResource(resource);
	}
	
	
}
