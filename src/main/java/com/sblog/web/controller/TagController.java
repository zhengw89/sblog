package com.sblog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sblog.beans.Tag;
import com.sblog.services.IPostService;
import com.sblog.services.ITagService;
import com.sun.org.apache.xpath.internal.operations.Mod;

@Controller
public class TagController extends PublicController {

	@Autowired
	private ITagService tagService;
	
	@Autowired
	private IPostService postService;
	
	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public ModelAndView getTagsView() {
		ModelAndView mv = new ModelAndView("tags");
		
		mv.addObject("tagSummarys", tagService.getAllTagSummarys());
		
		return mv;
	}
	
	@RequestMapping(value = "tag/{tagName}", method = RequestMethod.GET)
	public ModelAndView getTagView(@PathVariable String tagName) {
		if(tagName == null){
			return new ModelAndView("404");
		}
		
		Tag tag = this.tagService.getByTagName(tagName);
		if(tag == null){
			return new ModelAndView("404");
		}
		
		ModelAndView mv = new ModelAndView("tag");
		mv.addObject("tagId", tag.getId());
		mv.addObject("tagName", tag.getName());
		mv.addObject("posts", this.postService.getPublishedPostsByTag(tag.getId()));
		
		return mv;
	}
}
