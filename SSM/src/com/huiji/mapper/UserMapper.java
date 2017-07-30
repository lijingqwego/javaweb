package com.huiji.mapper;

import java.util.List;

import com.huiji.po.PageBean;
import com.huiji.po.User;
import com.huiji.po.UserinfoPage;

public interface UserMapper {
	
	//��ҳ��ѯ
	List<User> findUserListByPage(UserinfoPage userinfoPage);
	
	List<User> findUserList(PageBean pageBean);
	
	//��ȡ��¼����
	int getUserCount();
	
	//�û���¼
	User login(User user);
}
