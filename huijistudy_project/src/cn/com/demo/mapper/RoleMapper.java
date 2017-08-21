package cn.com.demo.mapper;

import java.util.List;
import java.util.Map;

import cn.com.demo.po.Role;

public interface RoleMapper {

	List<Role> findRoleList();

	void delRoleById(String roleid);

	Role findRoleById(String roleid);

	void updRole(Role role);
	
	/**
	 * ��ȡ���еĽ�ɫ����
	 * @return
	 */
	int getRoleCount(Role role);
	
	/**
	 * ��ҳ��������ѯ��ɫ
	 * @param pageBean
	 * @return
	 */
	List<Role> findRoleListByPage(Map<String, Object> map);

	/**
	 * ��ӽ�ɫ
	 * @param role
	 */
	void addRole(Role role);

	/**
	 * ����/����
	 * @param role
	 */
	void roleEnable(Role role);
	
	/**
	 * ��ȡ��ɫID
	 * @return
	 */
	String getRoleId();
	
    
}