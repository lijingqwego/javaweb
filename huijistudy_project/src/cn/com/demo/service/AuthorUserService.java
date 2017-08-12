package cn.com.demo.service;

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
		//根据username获取User
		UserCustom userCustom = userMapper.findUserByUsername(username);
		//取出userid
		String userid = userCustom.getUserid();
//		System.out.println("=======================userid================="+userid);
		//获取用户的权限
		List<Authority> authorList = userMapper.findAuthorListByUserId(userid);
//		System.out.println("======================code==============="+authorList.get(0).getCode());
		//添加用户权限
		userCustom.setAuthorityList(authorList);
		
		return userCustom;
	}
	
}
