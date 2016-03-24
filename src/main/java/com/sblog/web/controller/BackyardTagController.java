package com.sblog.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sblog.web.viewmodel.CreateTagModel;
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
	
	@RequestMapping(value = "/tag/create", method = RequestMethod.GET)
	public ModelAndView getCreateTagView() {
		ModelAndView mv = super.getModelAndViewWithAuthentication("/backyard/createTag");
		mv.addObject("tag", new CreateTagModel());
		return mv;
	}
	
	@RequestMapping(value = "/tag/create", method = RequestMethod.POST)
	public ModelAndView createTag(@Valid @ModelAttribute("tag") CreateTagModel model,
			BindingResult bindingResult) {
		
		ModelAndView mv = super.getModelAndViewWithAuthentication();
		if(bindingResult.hasErrors()){
			mv.setViewName("/backyard/createTag");
		} else {
			this.tagService.createTag(model.getTag());
			mv.setViewName("redirect:/backyard/tags");
		}
		return mv;
		
	}
}
