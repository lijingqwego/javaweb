package com.huiji.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huiji.mapper.UserMapper;
import com.huiji.po.RoleInfo;
import com.huiji.po.UserinfoCustom;

@Service
public class AuthUserInfoService implements UserDetailsService{
	@Resource
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserinfoCustom user = userMapper.getUser(username);
		int id = user.getId();
		List<RoleInfo> rolelist = userMapper.getUserAndRole(id);
		user.setRoleList(rolelist);
		return user;
	}
}
