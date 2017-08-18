package cn.com.demo.po;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserCustom implements UserDetails{
	
	private static final long serialVersionUID = 3129223776015843119L;

	private String userid;
	private String loginid;
    private String username; 
    private String password; 
	
	private List<Authority> authorityList;
	
	
	public List<Authority> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorList=new ArrayList<>();
		for(Authority a : authorityList){
			GrantedAuthority author = new SimpleGrantedAuthority(a.getCode());
			authorList.add(author);
		}
		return authorList;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCustom [userid=" + userid + ", loginid=" + loginid + ", username=" + username + ", password="
				+ password + ", authorityList=" + authorityList + "]";
	}
	
}
