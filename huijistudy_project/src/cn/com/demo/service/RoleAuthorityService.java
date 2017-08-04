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
	 * 根据roleid 查找所有权限
	 * @param roleid
	 * @return
	 */
	public List<RoleOfAuthority> findRoleOfAuthorByRoleId(String roleid){
		return roleAuthorityMapper.findRoleOfAuthorByRoleId(roleid);
	}
	/**
	 * 跟据roleid删除角色的权限
	 * @param roleid
	 */
	public void delRoleOfAuthorByRoleId(String roleid) {
		roleAuthorityMapper.delRoleOfAuthorByRoleId(roleid);
	}
	
	/**
	 * 添加角色的权限
	 * @param roleAuthorList
	 */
	public void addRoleOfAuthor(List<RoleAuthority> roleAuthorList) {
		roleAuthorityMapper.addRoleOfAuthor(roleAuthorList);
	}
}
