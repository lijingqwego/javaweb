package cn.com.demo.utils;

public class PageBeanVO extends PageBean{
	
	private String userid;
	
	private String username;
	
	private String roleid;
	
	private String rolename;
	
	private String authorityid; 
	
	private String authorityname;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getAuthorityid() {
		return authorityid;
	}

	public void setAuthorityid(String authorityid) {
		this.authorityid = authorityid;
	}

	public String getAuthorityname() {
		return authorityname;
	}

	public void setAuthorityname(String authorityname) {
		this.authorityname = authorityname;
	}
}
