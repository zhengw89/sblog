package com.sblog.repositories;

import java.util.List;

import com.sblog.beans.Tag;

public interface ITagRepository {
	
	boolean existsById(String id);

	boolean exists(String name);
	
	boolean create(Tag tag);
	
	boolean delete(String id);
	
	List<Tag> getAllTag();
	
	Tag getByName(String name);
}
