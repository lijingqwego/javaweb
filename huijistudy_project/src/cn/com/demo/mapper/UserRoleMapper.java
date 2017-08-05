package cn.com.demo.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.demo.po.UserOfRole;
import cn.com.demo.po.UserRole;

public interface UserRoleMapper {

    /**
     * 查找用户关联角色
     * @param userid
     * @return
     */
	List<UserOfRole> findUserOfRoleListByUserId(@Param("userid")String userid);

	/**
	 * 根据id删除用户关联角色
	 * @param userid
	 */
	void delUserOfRoleByUserId(String userid);

	/**
	 * 添加用户角色
	 * @param userRoleList
	 */
	void addUserOfRole(List<UserRole> userRoleList);

	/**
	 * 根据角色id删除用户关联角色
	 * @param roleid
	 */
	void delUserOfRoleByRoleId(String roleid);
}