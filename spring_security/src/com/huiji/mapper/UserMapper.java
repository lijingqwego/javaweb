package com.huiji.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiji.po.RoleInfo;
import com.huiji.po.UserinfoCustom;

public interface UserMapper {
	
	UserinfoCustom getUser(@Param("username")String username);
	
	List<RoleInfo> getUserAndRole(int id);
	
}
