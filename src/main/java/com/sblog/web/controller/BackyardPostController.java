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

import com.sblog.web.viewmodel.CreatePostModel;
import com.sblog.beans.Post;
import com.sblog.services.IPostService;
import com.sblog.services.ITagService;

@Controller
@RequestMapping("/backyard")
public class BackyardPostController extends PrivateController {
	
	@Autowired
	private IPostService postService;
	
	@Autowired
	private ITagService tagService;

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPostsView() {
		ModelAndView mv = super.getModelAndViewWithAuthentication("/backyard/posts");
		
		List<Post> posts = postService.getAll();
		mv.addObject("posts", posts);
		
		return mv;
	}
	
	@RequestMapping(value = "/post/create", method = RequestMethod.GET)
	public ModelAndView getCreatePostView() {
		ModelAndView mv = super.getModelAndViewWithAuthentication("/backyard/createPost");
		mv.addObject("post", new CreatePostModel());
		mv.addObject("tags", this.tagService.getAllTags());
		return mv;
	}
	
	@RequestMapping(value = "/post/create", method = RequestMethod.POST)
	public ModelAndView createBlog(@Valid @ModelAttribute("post") CreatePostModel model,
			BindingResult bindingResult){
		
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()){
			super.setAuthentication(mv);
			mv.setViewName("/backyard/createPost");
		} else {
			this.postService.CreatePost(model.getTitle(), model.getContent(), model.getTags());
			mv.setViewName("redirect:/backyard/posts");
		}
		
		return mv;
	}
}
