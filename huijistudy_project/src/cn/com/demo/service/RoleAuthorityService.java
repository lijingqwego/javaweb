package cn.com.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.RoleAuthorityMapper;
import cn.com.demo.po.RoleAuthority;
import cn.com.demo.po.RoleOfAuthority;

@Service
public class RoleAuthorityService {
	
	@Resource
	RoleAuthorityMapper roleAuthorityMapper;
	
	/**
	 * ����roleid ��������Ȩ��
	 * @param roleid
	 * @return
	 */
	public List<RoleOfAuthority> findRoleOfAuthorByRoleId(String roleid){
		return roleAuthorityMapper.findRoleOfAuthorByRoleId(roleid);
	}
	/**
	 * ����roleidɾ����ɫ��Ȩ��
	 * @param roleid
	 */
	public void delRoleOfAuthorByRoleId(String roleid) {
		roleAuthorityMapper.delRoleOfAuthorByRoleId(roleid);
	}
	
	/**
	 * ��ӽ�ɫ��Ȩ��
	 * @param roleAuthorList
	 */
	public void addRoleOfAuthor(List<RoleAuthority> roleAuthorList) {
		roleAuthorityMapper.addRoleOfAuthor(roleAuthorList);
	}
}
