package cn.com.demo.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import cn.com.demo.po.UserCustom;

public class UserSecurity {

	private UserSecurity(){}
	
	public static UserCustom getSecurityUser(){
		//��ȡ springSecurity��¼��ȫ����
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserCustom userCustom=null;
		
		if(principal instanceof UserDetails){
			userCustom=(UserCustom) principal;
			//�������   ����loginid
			String md5Password = MD5Config.md5_SystemWideSaltSource(userCustom.getPassword(),userCustom.getLoginid());
			userCustom.setPassword(md5Password);
			System.out.println("usercustom=========>"+userCustom);
		}else{
			userCustom=new UserCustom();
		}
		
		return userCustom;
	}
}
