package com.sblog.beans;

import java.util.Date;

public class VTagPost {

	private String tagId;
	
	private String tagName;
	
	private String postId;
	
	private String postTitle;
	
	private PostStatus postStatus;
	
	private Date postPublishTime;

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public PostStatus getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(PostStatus postStatus) {
		this.postStatus = postStatus;
	}

	public Date getPostPublishTime() {
		return postPublishTime;
	}

	public void setPostPublishTime(Date postPublishTime) {
		this.postPublishTime = postPublishTime;
	}
	
	public Post toPost() {
		Post post = new Post();
		
		post.setId(this.postId);
		post.setPublishTime(this.postPublishTime);
		post.setStatus(this.postStatus);
		post.setTitle(this.postTitle);
		
		return post;
	}
}
