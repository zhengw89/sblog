package com.sblog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sblog.services.ITagService;

@Controller
public class TagController extends PublicController {

	@Autowired
	private ITagService tagService;
	
	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public ModelAndView getTagsView() {
		ModelAndView mv = new ModelAndView("tags");
		
		mv.addObject("tagSummarys", tagService.getAllTagSummarys());
		
		return mv;
	}
}
