package com.sblog.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sblog.web.viewmodel.CreatePostModel;
import com.sblog.web.viewmodel.EditPostModel;
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
	public ModelAndView createPost(@Valid @ModelAttribute("post") CreatePostModel model,
			BindingResult bindingResult){
		
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()){
			super.setAuthentication(mv);
			mv.setViewName("/backyard/createPost");
			mv.addObject("tags", this.tagService.getAllTags());
		} else {
			this.postService.createPost(model.getTitle(), model.getContent(), model.getTags());
			mv.setViewName("redirect:/backyard/posts");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/post/edit/{postId}", method = RequestMethod.GET)
	public ModelAndView getEditPostView(@PathVariable String postId){
		if(postId == null) return new ModelAndView("404");
		Post post = this.postService.getPostById(postId);
		if(post == null) return new ModelAndView("404");
		
		ModelAndView mv = super.getModelAndViewWithAuthentication("/backyard/editPost");
		
		mv.addObject("postId", postId);
		mv.addObject("post", new EditPostModel(post, this.tagService.getAllTags()));
		mv.addObject("tags", this.tagService.getAllTags());
		
		return mv;
	}
	
	@RequestMapping(value = "/post/edit/{postId}", method = RequestMethod.POST)
	public ModelAndView editPost(@PathVariable String postId,
									@Valid @ModelAttribute("post") EditPostModel model,
									BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()){
			System.out.println("hasError");
			super.setAuthentication(mv);
			mv.setViewName("/backyard/editPost");
		} else {
			this.postService.editPost(postId, model.getTitle(), model.getContent(), model.getTags());
			mv.setViewName("redirect:/backyard/posts");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/post/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam("postId") String postId) {
		this.postService.deletePost(postId);
		return new ModelAndView("redirect:/backyard/posts");
	}
}
