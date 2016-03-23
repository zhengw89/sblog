package com.sblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sblog.beans.Tag;
import com.sblog.repositories.ITagRepository;

@Service("tagService")
public class TagService extends BaseService implements ITagService {

	@Autowired
	private ITagRepository tagRepository;

	public List<Tag> getAllTags() {
		return this.tagRepository.getAllTag();
	}
	
	
}
