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
	 * ��ȡ���еĽ�ɫ����
	 * @return
	 */
	int getRoleCount(PageBeanVO pageBean);
	
	/**
	 * ��ҳ��������ѯ��ɫ
	 * @param pageBean
	 * @return
	 */
	List<Role> findRoleListByPage(PageBeanVO pageBean);

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