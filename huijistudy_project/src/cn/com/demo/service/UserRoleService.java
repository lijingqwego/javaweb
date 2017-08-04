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
     * �����û�������ɫ
     * @param userid
     * @return
     */
	public List<UserOfRole> findUserOfRoleListByUserId(String userid){
		
		return userRoleMapper.findUserOfRoleListByUserId(userid);
		
	}
	/**
	 * ����useridɾ���û���ɫ
	 * @param userid
	 */
	public void delUserOfRoleByUserId(String userid) {
		userRoleMapper.delUserOfRoleByUserId(userid);
		
	}
	/**
	 * ����û���ɫ
	 * @param userRoleList
	 */
	public void addUserOfRole(List<UserRole> userRoleList) {
		userRoleMapper.addUserOfRole(userRoleList);
	}
}
