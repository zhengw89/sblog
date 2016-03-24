package com.sblog.repositories;

import java.util.List;

import com.sblog.beans.PostTag;

public interface IPostTagRepository {

	boolean exists(String postId, String tagId);
	
	boolean create(PostTag postTag);
	
	boolean deleteByTag(String tagId);
	
	boolean deleteByPost(String postId);
	
	List<String> getPostIdsByTagId(String tagId);
	
	int getPostCountByTagId(String tagId);
}
