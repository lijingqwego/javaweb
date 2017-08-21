package cn.com.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.RoleAuthorityMapper;
import cn.com.demo.mapper.RoleMapper;
import cn.com.demo.mapper.UserRoleMapper;
import cn.com.demo.po.Role;
import cn.com.demo.utils.PageBean;

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
	public PageBean findRoleListByPage(int currPage,int pageSize,Role role){
		int count=roleMapper.getRoleCount(role);
		PageBean pageBean = new PageBean(currPage,pageSize,count);
		Map<String,Object> map=new HashMap<>();
		map.put("currPage", currPage);
		map.put("pageSize", pageSize);
		map.put("role", role);
		List<Role> list = roleMapper.findRoleListByPage(map);
		pageBean.setList(list);
		return pageBean;
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
	
	
	/**
	 * ��ȡ��ɫID
	 * @return
	 */
	public String getRoleId(){
		return roleMapper.getRoleId();
	}
}
