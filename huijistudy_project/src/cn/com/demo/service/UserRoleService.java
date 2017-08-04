package cn.com.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.UserRoleMapper;
import cn.com.demo.po.UserOfRole;
import cn.com.demo.po.UserRole;

@Service
public class UserRoleService {
	
	@Resource
	private UserRoleMapper userRoleMapper;
	/**
     * 查找用户关联角色
     * @param userid
     * @return
     */
	public List<UserOfRole> findUserOfRoleListByUserId(String userid){
		
		return userRoleMapper.findUserOfRoleListByUserId(userid);
		
	}
	/**
	 * 根据userid删除用户角色
	 * @param userid
	 */
	public void delUserOfRoleByUserId(String userid) {
		userRoleMapper.delUserOfRoleByUserId(userid);
		
	}
	/**
	 * 添加用户角色
	 * @param userRoleList
	 */
	public void addUserOfRole(List<UserRole> userRoleList) {
		userRoleMapper.addUserOfRole(userRoleList);
	}
}
