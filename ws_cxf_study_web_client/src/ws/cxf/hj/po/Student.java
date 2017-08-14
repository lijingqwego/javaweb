package ws.cxf.hj.po;

public class Student {

	private String username;
	private int userid;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "Student [username=" + username + ", userid=" + userid + "]";
	}
}
