package com.sblog.beans;

import java.util.UUID;

public class Tag extends BaseBean {

	private String id;
	
	private String name;
	
	public Tag(){
		this(null);
	}
	
	public Tag(String name){
		this(UUID.randomUUID().toString(),name);
	}
	
	public Tag(String id, String name){
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}