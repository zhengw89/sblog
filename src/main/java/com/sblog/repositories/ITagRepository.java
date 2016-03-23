package com.sblog.repositories;

import java.util.List;

import com.sblog.beans.Tag;

public interface ITagRepository {

	boolean exists(String name);
	
	boolean create(Tag tag);
	
	List<Tag> getAllTag();
	
	Tag getByName(String name);
}
