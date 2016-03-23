package com.sblog.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sblog.beans.Tag;
import com.sblog.services.ITagService;

@Controller
@RequestMapping("/backyard")
public class BackyardTagController extends PrivateController {

	@Autowired
	ITagService tagService;

	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public ModelAndView backyardTagsView(){
		ModelAndView mv = super.getModelAndViewWithAuthentication("/backyard/tags");
		
		List<Tag> allTags = this.tagService.getAllTags();
		mv.addObject("tags", allTags);
		
		return mv;
	}
}
