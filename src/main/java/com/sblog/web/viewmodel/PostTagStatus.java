package com.sblog.web.viewmodel;

public class PostTagStatus {

	private String tagId;
	
	private String tagName;
	
	private boolean isChecked;
	
	public PostTagStatus(){
		this(null, null);
	}
	
	public PostTagStatus(String tagId, String tagName){
		this(tagId, tagName, false);
	}
	
	public PostTagStatus(String tagId, String tagName, boolean isChecked){
		this.tagId = tagId;
		this.tagName = tagName;
		this.isChecked = isChecked;
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

	public boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
}
