package cn.com.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.UserMapper;
import cn.com.demo.mapper.UserRoleMapper;
import cn.com.demo.po.User;
import cn.com.demo.utils.MD5Config;
import cn.com.demo.utils.PageBean;

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
		//ɾ���û��ͽ�ɫ����
		userRoleMapper.delUserOfRoleByUserId(userid);
		//ɾ���û�
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
	 * ��ȡ�û���id
	 * @return
	 */
	public String getUserId(){
		return userMapper.getUserId();
	}

	/**
	 * �޸��û���Ϣ
	 * @param user-
	 */
	public void updUser(User user) {
		//System.out.println("===========user==========="+user);
		String md5Password = MD5Config.md5_SystemWideSaltSource(user.getPassword(),user.getLoginid());
		user.setPassword(md5Password);
		userMapper.updUser(user);
	}

	/**
	 * ����û�
	 * @param user
	 */
	public void addUser(User user) {
		String md5Password = MD5Config.md5_SystemWideSaltSource(user.getPassword(),user.getLoginid());
		user.setPassword(md5Password);
		userMapper.addUser(user);
	}
	
	/**
	 * ��ҳ��������ѯ�û��б�
	 * @param currPage
	 * @param userid
	 * @param username
	 * @return
	 */
	public PageBean findUserListByPage(int currPage,int pageSize,User user){
		int count=userMapper.getUserCount(user);
		PageBean pageBean = new PageBean(currPage,pageSize,count);
		Map<String,Object> map=new HashMap<>();
		map.put("currPage", currPage);
		map.put("pageSize", pageSize);
		map.put("user", user);
		List<User> list = userMapper.findUserListByPage(map);
		pageBean.setList(list);
		return pageBean;
	}
	
	/**
	 * �û���¼�ɹ����޸ĵ�¼ʱ��͵�¼����
	 * @param username
	 */
	public void updLoginInfo(String username){
		userMapper.updLoginInfo(username);
	}

	/**
	 * ����
	 * @param userid
	 */
	public void userEnable(User user) {
		userMapper.userEnable(user);
	}
		
}
