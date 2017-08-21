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
		//删除用户和角色关联
		userRoleMapper.delUserOfRoleByRoleId(roleid);
		//删除角色和权限关联
		roleAuthorityMapper.delRoleOfAuthorByRoleId(roleid);
		//删除角色
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
	
	/**
	 * 分页查询角色
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
	 * 添加角色
	 * @param role
	 */
	public void addRole(Role role) {
		roleMapper.addRole(role);
	}

	public void roleEnable(Role role) {
		roleMapper.roleEnable(role);
	}
	
	
	/**
	 * 获取角色ID
	 * @return
	 */
	public String getRoleId(){
		return roleMapper.getRoleId();
	}
}
