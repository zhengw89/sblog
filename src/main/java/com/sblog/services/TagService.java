package com.sblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sblog.beans.PostStatus;
import com.sblog.beans.Tag;
import com.sblog.beans.TagSummary;
import com.sblog.repositories.IPostTagRepository;
import com.sblog.repositories.ITagRepository;
import com.sblog.repositories.IVTagPostRepository;

@Service("tagService")
@Transactional
public class TagService extends BaseService implements ITagService {

	@Autowired
	private ITagRepository tagRepository;
	
	@Autowired
	private IPostTagRepository postTagRepository;
	
	@Autowired
	private IVTagPostRepository vTagPostRepository;
	
	public List<TagSummary> getAllTagSummarys() {
		return this.vTagPostRepository.getTagSummarys(PostStatus.Published);
	}

	public List<Tag> getAllTags() {
		return this.tagRepository.getAllTag();
	}

	public Tag getByTagName(String name) {
		if(name == null) return null;
		return this.tagRepository.getByName(name);
	}

	public boolean createTag(String name) {
		if(name == null) return false;
		if(this.tagRepository.exists(name)) return true;
		return this.tagRepository.create(new Tag(name));
	}

	public boolean deleteTag(String tagId) {
		if(tagId == null) return false;
		if(!this.tagRepository.existsById(tagId)) return true;
		
		this.tagRepository.delete(tagId);
		this.postTagRepository.deleteByTag(tagId);
		
		return true;
	}
	
}
