package cn.com.demo.mapper;

import java.util.List;

import cn.com.demo.po.Role;
import cn.com.demo.utils.PageBeanVO;

public interface RoleMapper {

	List<Role> findRoleList();

	void delRoleById(String roleid);

	Role findRoleById(String roleid);

	void updRole(Role role);
	
	/**
	 * 获取所有的角色数量
	 * @return
	 */
	int getRoleCount(PageBeanVO pageBean);
	
	/**
	 * 分页按条件查询角色
	 * @param pageBean
	 * @return
	 */
	List<Role> findRoleListByPage(PageBeanVO pageBean);

	/**
	 * 添加角色
	 * @param role
	 */
	void addRole(Role role);

	/**
	 * 禁用/正常
	 * @param role
	 */
	void roleEnable(Role role);
	
	/**
	 * 获取角色ID
	 * @return
	 */
	String getRoleId();
	
    
}