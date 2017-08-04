package cn.com.demo.mapper;

import java.util.List;

import cn.com.demo.po.Role;

public interface RoleMapper {

	List<Role> findRoleList();

	void delRoleById(String roleid);

	Role findRoleById(String roleid);

	void updRole(Role role);
	
    
}