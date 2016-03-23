package com.sblog.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.sblog.beans.Tag;

@Repository("tagRepository")
public class TagRepository extends BaseRepository<Tag> implements ITagRepository {

	@Autowired
	protected TagRepository(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public boolean exists(String name) {
		return DataAccessUtils.intResult(
					getHibernateTemplate().find("select count(*) from Tag where name = ?", name)
				) > 0;
	}

	public List<Tag> getAllTag() {
		return super.createHibernateQuery("from Tag order by name").list();
	}

	public Tag getByName(String name) {
		Query query = super.createHibernateQuery("from Tag where name = :name")
							.setParameter("name", name);
		
		List<Tag> tags = query.list();
		if(tags.isEmpty()) return null;
		return tags.get(0);
	}

}
