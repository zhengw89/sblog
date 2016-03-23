package com.sblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BackyardAuthController extends PublicController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView BackyardLogin() {
		ModelAndView mv = new ModelAndView("/backyard/login");
		return mv;
	}
}
