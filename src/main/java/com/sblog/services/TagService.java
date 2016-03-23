package com.sblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sblog.beans.PostStatus;
import com.sblog.beans.Tag;
import com.sblog.beans.TagSummary;
import com.sblog.repositories.ITagRepository;
import com.sblog.repositories.IVTagPostRepository;

@Service("tagService")
@Transactional
public class TagService extends BaseService implements ITagService {

	@Autowired
	private ITagRepository tagRepository;
	
	@Autowired
	private IVTagPostRepository vTagPostRepository;
	
	public List<TagSummary> getAllTagSummarys() {
		return this.vTagPostRepository.getTagSummarys(PostStatus.Published);
	}

	public List<Tag> getAllTags() {
		return this.tagRepository.getAllTag();
	}
	
}
