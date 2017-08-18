package cn.com.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.UserMapper;
import cn.com.demo.mapper.UserRoleMapper;
import cn.com.demo.po.User;
import cn.com.demo.utils.MD5Config;
import cn.com.demo.utils.PageBeanVO;

@Service
public class UserService {
	
	@Resource
	UserMapper userMapper;
	@Resource
	UserRoleMapper userRoleMapper;
	
	/**
	 * 跟据id删除用户
	 * @param userid
	 */
	public void delUserById(String userid) {
		//删除用户和角色关联
		userRoleMapper.delUserOfRoleByUserId(userid);
		//删除用户
		userMapper.delUserByUserid(userid);
	}

	/**
	 * 根据id查找用户
	 * @param userid
	 * @return
	 */
	public User findUserById(String userid) {
		return userMapper.findUserById(userid);
	}
	
	/**
	 * 获取用户的id
	 * @return
	 */
	public String getUserId(){
		return userMapper.getUserId();
	}

	/**
	 * 修改用户信息
	 * @param user-
	 */
	public void updUser(User user) {
		//System.out.println("===========user==========="+user);
		String md5Password = MD5Config.md5_SystemWideSaltSource(user.getPassword(),user.getLoginid());
		user.setPassword(md5Password);
		userMapper.updUser(user);
	}

	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user) {
		String md5Password = MD5Config.md5_SystemWideSaltSource(user.getPassword(),user.getLoginid());
		user.setPassword(md5Password);
		userMapper.addUser(user);
	}
	
	/**
	 * 分页和搜索查询用户列表
	 * @param currPage
	 * @param userid
	 * @param username
	 * @return
	 */
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
	
	/**
	 * 用户登录成功后修改登录时间和登录次数
	 * @param username
	 */
	public void updLoginInfo(String username){
		userMapper.updLoginInfo(username);
	}

	/**
	 * 禁用
	 * @param userid
	 */
	public void userEnable(User user) {
		userMapper.userEnable(user);
	}
		
}
