package com.sblog.repositories;

import java.util.List;

import com.sblog.beans.Post;

public interface IPostRepository {

boolean create(Post post);
	
	Post getByPostId(String postId);
	
	List<Post> getLatest(int count);
	
	List<Post> getPosts();
}
