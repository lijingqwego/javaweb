package com.imooc.service.impl;

import com.imooc.dao.UserDao;
import com.imooc.dao.impl.UserDaoImpl;
import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.utils.MailUtil;

public class UserServiceImpl implements UserService {

	
	private UserDao userDao;
	public UserServiceImpl() {
		userDao=new UserDaoImpl();
	}
	@Override
	public void regist(User user) throws Exception{
		//将数据存入数据库
		userDao.regist(user);
		
		//发送一封激活邮件
		MailUtil.sendMail(user.getEmail(), user.getCode());
	}
	@Override
	public User findUserByCode(String code) throws Exception {
		return userDao.findUserByCode(code);
	}
	@Override
	public void update(User user) throws Exception {
		userDao.update(user);
	}

}
