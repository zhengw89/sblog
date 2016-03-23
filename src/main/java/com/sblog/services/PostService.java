package com.sblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sblog.beans.Post;
import com.sblog.repositories.IPostRepository;

@Service("postService")
public class PostService extends BaseService implements IPostService {
	
	@Autowired
	private IPostRepository postRepository;

	public List<Post> getLatestPublishedPosts(int count) {
		return this.postRepository.getLatestPublished(count);
	}

	public List<Post> getAllPublishedPosts() {
		return this.postRepository.getAllPublishedPosts();
	}

	public Post getPostById(String postId) {
		if(postId == null) return null;
		return this.postRepository.getByPostId(postId);
	}

}
