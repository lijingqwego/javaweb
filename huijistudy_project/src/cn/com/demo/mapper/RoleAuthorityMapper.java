package cn.com.demo.mapper;

import java.util.List;

import cn.com.demo.po.RoleAuthority;
import cn.com.demo.po.RoleOfAuthority;

public interface RoleAuthorityMapper {
	
    /**
	 * 根据roleid 查找所有权限
	 * @param roleid
	 * @return
	 */
	List<RoleOfAuthority> findRoleOfAuthorByRoleId(String roleid);

	/**
	 * 跟据roleid删除角色的权限
	 * @param roleid
	 */
	void delRoleOfAuthorByRoleId(String roleid);
	/**
	 * 跟据authorityid删除角色的权限
	 * @param authorityid
	 */
	void delRoleOfAuthorByAuthorityId(String authorityid);

	/**
	 * 添加角色的权限
	 * @param roleAuthorList
	 */
	void addRoleOfAuthor(List<RoleAuthority> roleAuthorList);
}