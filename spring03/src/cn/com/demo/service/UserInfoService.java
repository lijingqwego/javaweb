package cn.com.demo.service;

import cn.com.demo.dao.UserDAO;
import cn.com.demo.po.UserInfo;

public class UserInfoService {
	private UserDAO userDAO ;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	} 
	
	
	public void addUserInfo(UserInfo ui){
		userDAO.addUserInfo(ui);
	}
	
	public void deluserInfo(Long id){
		userDAO.delUserInfo(id);
	}
	
}
