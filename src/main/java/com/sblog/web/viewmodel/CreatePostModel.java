package com.sblog.web.viewmodel;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CreatePostModel {

	@NotNull
	@NotEmpty(message ="title not null")
	private String title;
	
	@NotNull
	@NotEmpty(message = "content not null")
	private String content;
	
	private String[] tags;
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}
}
