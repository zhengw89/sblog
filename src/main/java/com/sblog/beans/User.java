package com.sblog.beans;

public class User extends BaseBean {
	
	private String id;

	private String displayName;
	
	private String password;
	
	public User(){
		
	}
	
	public User(String displayName, String password){
		this.displayName = displayName;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}