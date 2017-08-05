package cn.com.demo.mapper;

import java.util.List;

import cn.com.demo.po.RoleAuthority;
import cn.com.demo.po.RoleOfAuthority;

public interface RoleAuthorityMapper {
	
    /**
	 * ����roleid ��������Ȩ��
	 * @param roleid
	 * @return
	 */
	List<RoleOfAuthority> findRoleOfAuthorByRoleId(String roleid);

	/**
	 * ����roleidɾ����ɫ��Ȩ��
	 * @param roleid
	 */
	void delRoleOfAuthorByRoleId(String roleid);
	/**
	 * ����authorityidɾ����ɫ��Ȩ��
	 * @param authorityid
	 */
	void delRoleOfAuthorByAuthorityId(String authorityid);

	/**
	 * ��ӽ�ɫ��Ȩ��
	 * @param roleAuthorList
	 */
	void addRoleOfAuthor(List<RoleAuthority> roleAuthorList);
}