package com.huiji.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiji.mapper.UserMapper;
import com.huiji.po.PageBean;
import com.huiji.po.User;
import com.huiji.po.UserinfoPage;
@Service
public class UserService {
	
	@Resource
	private UserMapper userMapper;
	
	public List<User> findUserListByPage(UserinfoPage userinfoPage){
		return userMapper.findUserListByPage(userinfoPage);
	}
	
	public List<User> findUserList(PageBean pageBean){
		return userMapper.findUserList(pageBean);
	}
	
	public int getUserCount(){
		return userMapper.getUserCount();
	}
	
	public User login(User user){
		return userMapper.login(user);
	}
}
