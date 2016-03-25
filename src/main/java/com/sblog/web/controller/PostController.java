package com.sblog.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sblog.beans.Post;
import com.sblog.services.IPostService;

@Controller
public class PostController extends PublicController {
	
	private final int DEFAULT_LATEST_COUNT = 10;
	
	@Autowired
	private IPostService postService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getIndexView() {
		ModelAndView mv = new ModelAndView("index");
		
		List<Post> posts = this.postService.getLatestPublishedPosts(DEFAULT_LATEST_COUNT);
		mv.addObject("posts", posts);
		
		return mv;
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPostsView() {
		ModelAndView mv = new ModelAndView("posts");
		
		List<Post> posts = this.postService.getAllPublishedPosts();
		mv.addObject("posts", posts);
		
		return mv;
	}
	
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
	public ModelAndView getPostView(@PathVariable String postId) {
		ModelAndView mv = new ModelAndView();
		
		Post post = this.postService.getPostById(postId);
		if(post == null){
			mv.setViewName("404");
		}else {
			mv.setViewName("post");
			
			mv.addObject("title", post.getTitle());
			mv.addObject("publishTime", post.getPublishTime());
			mv.addObject("content", post.getRenderedContent());
			mv.addObject("tags", post.getTags());
		}
		
		return mv;
	}
}
