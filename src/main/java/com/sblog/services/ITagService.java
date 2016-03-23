package com.sblog.services;

import java.util.List;

import com.sblog.beans.Tag;
import com.sblog.beans.TagSummary;

public interface ITagService {
	
	List<TagSummary> getAllTagSummarys();

	List<Tag> getAllTags();
}
