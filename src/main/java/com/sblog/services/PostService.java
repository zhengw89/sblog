package com.sblog.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sblog.beans.Post;
import com.sblog.beans.PostStatus;
import com.sblog.repositories.IPostRepository;

@Service("postService")
@Transactional
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

	public List<Post> getPublishedPostsByTag(String tagId) {
		if(tagId == null) return null;
		return this.postRepository.getByTag(tagId, PostStatus.Published);
	}

}
