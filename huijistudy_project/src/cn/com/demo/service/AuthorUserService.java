package cn.com.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.com.demo.mapper.UserMapper;
import cn.com.demo.po.Authority;
import cn.com.demo.po.UserCustom;

@Service
public class AuthorUserService implements UserDetailsService{

	@Resource
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println("=======================username==========="+username);
		//����username��ȡUser
		try {
			username=new String(username.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		UserCustom userCustom = userMapper.findUserByUsername(username);
		//ȡ��userid
		String userid = userCustom.getUserid();
//		System.out.println("=======================userid================="+userid);
		//��ȡ�û���Ȩ��
		List<Authority> authorList = userMapper.findAuthorListByUserId(userid);
		for(Authority a:authorList){
		System.out.println("======================code==============="+a.getCode());
		}
		//����û�Ȩ��
		userCustom.setAuthorityList(authorList);
		
		return userCustom;
	}
	
}
