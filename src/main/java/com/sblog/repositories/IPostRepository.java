package com.sblog.repositories;

import java.util.List;

import com.sblog.beans.Post;
import com.sblog.beans.PostStatus;

public interface IPostRepository {
	
	boolean exists(String id);

	boolean create(Post post);
	
	boolean update(Post post);
	
	boolean delete(String id);
	
	Post getByPostId(String postId);
	
	List<Post> get();
	
	List<Post> get(PostStatus status);
	
	List<Post> getLatest(PostStatus status, int count);
	
	List<Post> getByTag(String tagId, PostStatus status);
}
