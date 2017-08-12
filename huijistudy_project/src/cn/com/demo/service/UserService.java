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
	 * �޸��û���Ϣ
	 * @param user-
	 */
	public void updUser(User user) {
		System.out.println("===========user==========="+user);
		userMapper.updUser(user);
	}

	/**
	 * ����û�
	 * @param user
	 */
	public void addUser(User user) {
		userMapper.addUser(user);
	}
	
	/**
	 * ��ҳ��������ѯ�û��б�
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
	 * �û���¼����������û������������ƥ�ԣ�������Բ鵽���ݾ�˵���ȳɹ��������¼ʧ�ܣ�
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password) {
		return userMapper.loginCheckUser(username,password);
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
