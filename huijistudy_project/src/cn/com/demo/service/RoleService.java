package cn.com.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.RoleAuthorityMapper;
import cn.com.demo.mapper.RoleMapper;
import cn.com.demo.po.Role;

@Service
public class RoleService {
	@Resource
	RoleMapper roleMapper;
	
	@Resource
	RoleAuthorityMapper roleAuthorityMapper;
	/**
	 * ��ѯ��ɫ�б�
	 * @return
	 */
	public List<Role> findRoleList(){
		
		return roleMapper.findRoleList();
		
	}
	
	/**
	 * ����idɾ����ɫ
	 * @param roleid
	 */
	public void delRoleById(String roleid) {
		roleAuthorityMapper.delRoleOfAuthorByRoleId(roleid);
		roleMapper.delRoleById(roleid);
	}

	/**
	 * ����id���ҽ�ɫ
	 * @param roleid
	 * @return
	 */
	public Role findRoleById(String roleid) {
		
		return roleMapper.findRoleById(roleid);
	}

	/**
	 * �޸Ľ�ɫ
	 * @param role
	 */
	public void updRole(Role role) {
		roleMapper.updRole(role);
	}
}
