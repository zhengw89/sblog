package com.sblog.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sblog.beans.Post;

@Repository("postRepository")
public class PostRepository extends BaseRepository<Post> implements IPostRepository{

	@Autowired
	protected PostRepository(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Post getByPostId(String postId) {
		return super.getByKey(postId);
	}

	public List<Post> getLatest(final int count) {
		
		Query query = super.createHibernateQuery("from Post order by publishTime desc");
		query.setFirstResult(0); 
		query.setMaxResults(count);
		
		return (List<Post>)query.list();
	}

	public List<Post> getPosts() {
		Query query = super.createHibernateQuery("from Post order by createTime desc");
		return query.list();
	}

}
