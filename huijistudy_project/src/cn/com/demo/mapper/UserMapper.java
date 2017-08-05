package cn.com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.demo.po.User;
import cn.com.demo.utils.PageBeanVO;

public interface UserMapper {
	
    int delUserByUserid(String userid);

    int addUser(User user);

    User findUserById(String userid);

    int updUser(User user);
    
    int getUserCount(PageBeanVO pageBean);
    
    List<User> findUserListByPage(PageBeanVO pageBean);

	User loginCheckUser(@Param("username")String username, @Param("password")String password);

}