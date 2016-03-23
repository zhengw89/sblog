package com.sblog.beans;

public class TagSummary {

	private String tagId;
	
	private String tagName;
	
	private int postCount;
	
	public TagSummary(){
		
	}
	
	public TagSummary(String tagId, String tagName, int postCount){
		this.tagId = tagId;
		this.tagName = tagName;
		this.postCount = postCount;
	}

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

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	
}
