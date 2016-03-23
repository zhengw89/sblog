package com.sblog.web.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.sblog.beans.User;

public abstract class PrivateController extends BaseController {

	protected UsernamePasswordAuthenticationToken getCurrent() {
		return (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	}
	
	protected ModelAndView getModelAndViewWithAuthentication(){
		return this.getModelAndViewWithAuthentication(null);
	}
	
	protected ModelAndView getModelAndViewWithAuthentication(String viewName){
		ModelAndView mv = new ModelAndView(viewName);
		return this.setAuthentication(mv);
	}
	
	protected ModelAndView setAuthentication(ModelAndView mv) {
		User user = (User)this.getCurrent().getDetails();
		mv.addObject("userDisplayName", user.getDisplayName());
		return mv;
	}
}
