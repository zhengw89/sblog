package com.sblog.web.viewmodel;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.sblog.beans.Post;
import com.sblog.beans.PostTag;
import com.sblog.beans.Tag;

public class EditPostModel {

	@NotNull
	@NotEmpty(message = "title not null")
	private String title;
	
	@NotNull
	@NotEmpty(message = "content not null")
	private String content;
	
	private String[] tags;
	
	private List<PostTagStatus> tagStatus;
	
	public EditPostModel(){
		this(null);
	}
	
	public EditPostModel(Post post){
		this(post, null);
	}
	
	public EditPostModel(Post post, List<Tag> allTags){
		if(post == null) return;
		
		this.title = post.getTitle();
		this.content = post.getContent();
		
		this.tagStatus = new ArrayList<PostTagStatus>();
		List<Tag> postTags = post.getTags();
		if(allTags != null && postTags != null){
			for (Tag tag : allTags) {
				PostTagStatus tagStatus = new PostTagStatus(tag.getId(), tag.getName());
				this.tagStatus.add(tagStatus);
				for (Tag postTag : postTags) {
					if(postTag.getId().equals(tag.getId())){
						tagStatus.setIsChecked(true);
						break;
					}
				}
			}
		}
		
	}
	
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

	
	public List<PostTagStatus> getTagStatus() {
		return tagStatus;
	}

	public void setTagStatus(List<PostTagStatus> tagStatus) {
		this.tagStatus = tagStatus;
	}
}
