package cn.com.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.RoleAuthorityMapper;
import cn.com.demo.mapper.RoleMapper;
import cn.com.demo.mapper.UserRoleMapper;
import cn.com.demo.po.Role;
import cn.com.demo.utils.PageBeanVO;

@Service
public class RoleService {
	@Resource
	RoleMapper roleMapper;
	
	@Resource
	RoleAuthorityMapper roleAuthorityMapper;
	@Resource
	UserRoleMapper userRoleMapper;
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
		//ɾ���û��ͽ�ɫ����
		userRoleMapper.delUserOfRoleByRoleId(roleid);
		//ɾ����ɫ��Ȩ�޹���
		roleAuthorityMapper.delRoleOfAuthorByRoleId(roleid);
		//ɾ����ɫ
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
	
	/**
	 * ��ҳ��ѯ��ɫ
	 * @param currPage
	 * @param roleid
	 * @param rolename
	 * @return
	 */
	public PageBeanVO findRoleListByPage(int currPage,String roleid,String rolename){
		PageBeanVO vo = new PageBeanVO();
		vo.setPageSize(3);
		vo.setCurrPage(currPage);
		vo.setRoleid(roleid);
		vo.setRolename(rolename);
		int roleCount = roleMapper.getRoleCount(vo);
		int totalPage=(int) Math.ceil(roleCount*1.0/3);
		vo.setTotalPage(totalPage);
		List<Role> list = roleMapper.findRoleListByPage(vo);
		vo.setList(list);
		return vo;
	}

	/**
	 * ��ӽ�ɫ
	 * @param role
	 */
	public void addRole(Role role) {
		roleMapper.addRole(role);
	}

	public void roleEnable(Role role) {
		roleMapper.roleEnable(role);
	}
}
