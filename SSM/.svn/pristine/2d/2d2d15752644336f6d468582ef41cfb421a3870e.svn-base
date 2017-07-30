package com.huiji.mapper;

import java.util.List;

import com.huiji.po.PageBean;
import com.huiji.po.User;
import com.huiji.po.UserinfoPage;

public interface UserMapper {
	
	//分页查询
	List<User> findUserListByPage(UserinfoPage userinfoPage);
	
	List<User> findUserList(PageBean pageBean);
	
	//获取记录总数
	int getUserCount();
	
	//用户登录
	User login(User user);
}
