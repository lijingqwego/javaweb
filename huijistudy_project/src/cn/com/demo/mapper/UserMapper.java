package cn.com.demo.mapper;

import java.util.List;
import java.util.Map;

import cn.com.demo.po.Authority;
import cn.com.demo.po.User;
import cn.com.demo.po.UserCustom;

public interface UserMapper {
	
    int delUserByUserid(String userid);
    
    String getUserId();

    int addUser(User user);
    
    void registUser(User user);

    User findUserById(String userid);

    void updUser(User user);
    
    int getUserCount(User user);
    
    List<User> findUserListByPage(Map<String, Object> map);

	void updLoginInfo(String loginid);
	
	UserCustom findUserByLoginid(String loginid);
	
	List<Authority> findAuthorListByUserId(String userid);

	void userEnable(User user);

	int findUserByLoginid2(String loginid);

}