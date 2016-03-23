package com.sblog.beans;

import java.util.UUID;

public class PostTag extends BaseBean {

	private String id;
	
	private String postId;
	
	private String tagId;
	
	public PostTag(){
		this(null,null);
	}
	
	public PostTag(String postId,String tagId){
		this(UUID.randomUUID().toString(), postId, tagId);
	}
	
	public PostTag(String id,String postId,String tagId){
		this.id = id;
		this.postId = postId;
		this.tagId = tagId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	
}