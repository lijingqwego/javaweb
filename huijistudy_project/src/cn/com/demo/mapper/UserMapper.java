package cn.com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.demo.po.Authority;
import cn.com.demo.po.User;
import cn.com.demo.po.UserCustom;
import cn.com.demo.utils.PageBeanVO;

public interface UserMapper {
	
    int delUserByUserid(String userid);
    
    String getUserId();

    int addUser(User user);

    User findUserById(String userid);

    void updUser(User user);
    
    int getUserCount(PageBeanVO pageBean);
    
    List<User> findUserListByPage(PageBeanVO pageBean);

	User loginCheckUser(@Param("username")String username, @Param("password")String password);
	
	void updLoginInfo(String username);
	
	UserCustom findUserByUsername(String username);
	
	List<Authority> findAuthorListByUserId(String userid);

	void userEnable(User user);

}