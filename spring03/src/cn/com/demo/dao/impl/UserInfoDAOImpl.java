package cn.com.demo.dao.impl;

import cn.com.demo.dao.UserDAO;
import cn.com.demo.po.UserInfo;

public class UserInfoDAOImpl implements UserDAO {

	@Override
	public void addUserInfo(UserInfo ui) {
		System.out.println("add userinfo ");
	}

	@Override
	public void delUserInfo(Long id) {
		System.out.println("delete msg");
	}

}
