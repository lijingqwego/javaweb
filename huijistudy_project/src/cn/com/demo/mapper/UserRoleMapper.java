package cn.com.demo.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.demo.po.UserOfRole;
import cn.com.demo.po.UserRole;

public interface UserRoleMapper {

    /**
     * �����û�������ɫ
     * @param userid
     * @return
     */
	List<UserOfRole> findUserOfRoleListByUserId(@Param("userid")String userid);

	/**
	 * ����idɾ���û�������ɫ
	 * @param userid
	 */
	void delUserOfRoleByUserId(String userid);

	/**
	 * ����û���ɫ
	 * @param userRoleList
	 */
	void addUserOfRole(List<UserRole> userRoleList);

	/**
	 * ���ݽ�ɫidɾ���û�������ɫ
	 * @param roleid
	 */
	void delUserOfRoleByRoleId(String roleid);
}