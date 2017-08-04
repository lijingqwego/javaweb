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
	 * 查询角色列表
	 * @return
	 */
	public List<Role> findRoleList(){
		
		return roleMapper.findRoleList();
		
	}
	
	/**
	 * 根据id删除角色
	 * @param roleid
	 */
	public void delRoleById(String roleid) {
		roleAuthorityMapper.delRoleOfAuthorByRoleId(roleid);
		roleMapper.delRoleById(roleid);
	}

	/**
	 * 根据id查找角色
	 * @param roleid
	 * @return
	 */
	public Role findRoleById(String roleid) {
		
		return roleMapper.findRoleById(roleid);
	}

	/**
	 * 修改角色
	 * @param role
	 */
	public void updRole(Role role) {
		roleMapper.updRole(role);
	}
}
