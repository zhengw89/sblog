package com.sblog.repositories;

import java.util.List;

import com.sblog.beans.Post;
import com.sblog.beans.PostStatus;

public interface IPostRepository {

	boolean create(Post post);
	
	Post getByPostId(String postId);
	
	List<Post> getLatestPublished(int count);
	
	List<Post> getAllPublishedPosts();
	
	List<Post> getByTag(String tagId, PostStatus status);
}
