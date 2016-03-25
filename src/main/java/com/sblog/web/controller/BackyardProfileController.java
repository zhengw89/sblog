package com.sblog.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sblog.services.IUserService;
import com.sblog.web.viewmodel.UpdatePasswordModel;

@Controller
@RequestMapping("/backyard")
public class BackyardProfileController extends PrivateController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView getChangePasswordView() {
		ModelAndView mv = super.getModelAndViewWithAuthentication("/backyard/changePassword");
		mv.addObject("model",new UpdatePasswordModel());
		return mv;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView changePassword(@Valid @ModelAttribute("model") UpdatePasswordModel model,
			BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()){
			super.setAuthentication(mv);
			mv.setViewName("/backyard/changePassword");
		} else {
			this.userService.updatePassword(super.getCurrentUser().getId(), model.getNewPassword());
			mv.setViewName("redirect:/backyard");
		}
		
		return mv;
	}
}
