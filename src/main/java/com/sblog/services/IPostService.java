package com.sblog.services;

import java.util.List;

import com.sblog.beans.Post;

public interface IPostService {

	List<Post> getLatestPublishedPosts(int count);
	
	List<Post> getAllPublishedPosts();
	
	Post getPostById(String postId);
}
