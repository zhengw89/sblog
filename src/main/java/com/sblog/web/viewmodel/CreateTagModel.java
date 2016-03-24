package com.sblog.web.viewmodel;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateTagModel {

	@NotNull
	@NotEmpty(message = "Tag not empty")
	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
