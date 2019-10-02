package member.model;

import java.util.Date;
//model class (Data, VO)
public class Member {

	private String id;
	private String name;
	private String password;
	private Date regDate;
	
	private String newpwd;

	public Member(String id, String name, String password, Date regDate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
	}

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public String getNewpwd() {
		return newpwd;
	}

	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}
	
	public void comparePassword(String password) {
		this.newpwd = password;
	}
}
