package com.sblog.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.sblog.beans.PostTag;

@Repository("postTagRepository")
public class PostTagRepository extends BaseRepository<PostTag> implements IPostTagRepository {

	@Autowired
	protected PostTagRepository(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public boolean exists(String postId, String tagId) {
		return DataAccessUtils.intResult(
					getHibernateTemplate()
						.find("select count(*) from PostTag where postId = ? and tagId = ?", 
								new Object[]{postId, tagId}) 
				) > 0;
	}

	public List<String> getPostIdsByTagId(String tagId) {
		return (List<String>)getHibernateTemplate().find("select postId from PostTag where tagId = ?", tagId);
	}

	public int getPostCountByTagId(String tagId) {
		return DataAccessUtils.intResult(
					getHibernateTemplate()
						.find("select count(*) from PostTag where tagId = ?", tagId)
				);
	}

}
