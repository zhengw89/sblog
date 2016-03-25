package com.sblog.services;

import java.util.List;

import com.sblog.beans.Post;

public interface IPostService {
	
	public static final String POST_CACHE_NAME = "post.cache";

	List<Post> getLatestPublishedPosts(int count);
	
	List<Post> getAll();
	
	List<Post> getAllPublishedPosts();
	
	Post getPostById(String postId);
	
	List<Post> getPublishedPostsByTag(String tagId);
	
	boolean createPost(String title, String content, String[] tagIds);
	
	boolean editPost(String id, String title, String content, String[] tagIds);
	
	boolean deletePost(String postId);
}
