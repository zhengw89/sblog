package com.sblog.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sblog.beans.Post;
import com.sblog.beans.PostStatus;

@Repository("postRepository")
public class PostRepository extends BaseRepository<Post> implements IPostRepository{

	@Autowired
	protected PostRepository(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Post getByPostId(String postId) {
		return super.getByKey(postId);
	}

	public List<Post> getLatestPublished(int count) {
		
		Query query = super.createHibernateQuery("from Post where status = :status order by publishTime desc")
							.setParameter("status", PostStatus.Published);
		query.setFirstResult(0); 
		query.setMaxResults(count);
		
		return query.list();
	}

	public List<Post> getAllPublishedPosts() {
		Query query = super.createHibernateQuery("from Post where status = :status order by publishTime desc")
							.setParameter("status", PostStatus.Published);
		return query.list();
	}

}
