package cn.com.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.UserMapper;
import cn.com.demo.mapper.UserRoleMapper;
import cn.com.demo.po.User;
import cn.com.demo.utils.PageBeanVO;

@Service
public class UserService {
	
	@Resource
	UserMapper userMapper;
	@Resource
	UserRoleMapper userRoleMapper;
	
	/**
	 * ����idɾ���û�
	 * @param userid
	 */
	public void delUserById(String userid) {
		userRoleMapper.delUserOfRoleByUserId(userid);
		userMapper.delUserByUserid(userid);
	}

	/**
	 * ����id�����û�
	 * @param userid
	 * @return
	 */
	public User findUserById(String userid) {
		return userMapper.findUserById(userid);
	}

	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	public void updUser(User user) {
		userMapper.updUser(user);
	}

	/**
	 * �����û�
	 * @param user
	 */
	public void addUser(User user) {
		userMapper.addUser(user);
	}
	
	public PageBeanVO findUserListByPage(int currPage,String userid,String username){
		PageBeanVO vo = new PageBeanVO();
		vo.setPageSize(3);
		vo.setCurrPage(currPage);
		vo.setUsername(username);
		vo.setUserid(userid);
		int count = userMapper.getUserCount(vo);
		int totalPage = (int) Math.ceil(count * 1.0 / 3);
		vo.setTotalPage(totalPage);
		List<User> list = userMapper.findUserListByPage(vo);
		vo.setList(list);
		return vo;
	}
		
}