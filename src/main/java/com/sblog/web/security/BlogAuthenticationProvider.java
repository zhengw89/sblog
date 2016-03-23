package com.sblog.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.sblog.beans.User;
import com.sblog.services.IUserService;
import com.sblog.web.security.BlogAuthority;

public class BlogAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private IUserService userService;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		
		if(username == null || password == null){
			throw new BadCredentialsException("Bad Credentials");
		}
		
		User user = userService.getByUserId(username);
		if(user == null){
			throw new BadCredentialsException("User not exist");
		}
		
		if(user.getPassword().equals(password)){
			
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					authentication.getPrincipal(), 
					authentication.getCredentials(), 
					this.getAdminAuthorities());
			authenticationToken.setDetails(user);
			return authenticationToken;
		} else {
			throw new BadCredentialsException("Bad Credentials");
		}
	}

	public boolean supports(Class<?> authentication) {
		return true;
	}

	private List<BlogAuthority> getAdminAuthorities() {
		List<BlogAuthority> authorities = new ArrayList<BlogAuthority>();
		
		authorities.add(new BlogAuthority("ROLE_ADMIN"));
		
		return authorities;
	}
}