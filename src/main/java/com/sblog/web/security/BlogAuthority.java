package com.sblog.web.security;

import org.springframework.security.core.GrantedAuthority;

public class BlogAuthority implements GrantedAuthority {
	
	private final String authority;
	
	public BlogAuthority(String authority){
		this.authority = authority;
	}

	public String getAuthority() {
		return this.authority;
	}

}
