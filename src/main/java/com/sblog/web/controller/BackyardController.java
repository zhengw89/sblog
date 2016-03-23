package com.sblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/backyard")
public class BackyardController extends PrivateController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getBackyardHomeView() {
		ModelAndView mv = super.getModelAndViewWithAuthentication("/backyard/home");
		return mv;
	}
}
