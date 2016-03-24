package com.sblog.services;

import java.util.List;

import com.sblog.beans.Tag;
import com.sblog.beans.TagSummary;

public interface ITagService {
	
	Tag getByTagName(String name);
	
	List<TagSummary> getAllTagSummarys();

	List<Tag> getAllTags();
	
	boolean createTag(String name);
}
