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
	 * ������Դ�б�
	 * @return
	 */
	public List<Resources> findResourceList() {
		
		return resourcesMapper.findResourceList();
	}

	/**
	 * ��ȡ��Դid
	 * @return
	 */
	public String getResourceId() {
		return resourcesMapper.getResourceId();
	}

	/**
	 * �����Դ
	 * @param resource
	 */
	public void addResource(Resources resource) {
		resourcesMapper.addResource(resource);
	}

	/**
	 * ɾ����Դ
	 * @param resource_id
	 */
	public void delResource(String resource_id) {
		//������Դidɾ��Ȩ�޹�����Դ��
		authorityResourceMapper.delAuthorOfResByResourceId(resource_id);
		//ɾ����Դ
		resourcesMapper.delResource(resource_id);
	}

	/**
	 * ������Դ
	 * @param resource_id
	 * @return
	 */
	public Resources findResource(String resource_id) {
		return resourcesMapper.findResourceById(resource_id);
	}

	/**
	 * �޸���Դ
	 * @param resource
	 */
	public void updResource(Resources resource) {
		resourcesMapper.updResource(resource);
	}
	
	
}
