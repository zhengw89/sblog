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

	public List<Post> getLatest(PostStatus status, int count) {
		
		Query query = super.createHibernateQuery("from Post where status = :status order by publishTime desc")
							.setParameter("status", status);
		query.setFirstResult(0); 
		query.setMaxResults(count);
		
		return query.list();
	}

	public List<Post> getByTag(String tagId, PostStatus status) {
		StringBuilder hqSb = new StringBuilder();
		hqSb.append("select p from Post p, PostTag pt ");
		hqSb.append("where pt.tagId = :tagId ");
		hqSb.append("and p.status = :status ");
		hqSb.append("and p.id = pt.postId ");
		hqSb.append("order by p.publishTime, p.createTime");
		
		Query query = super.createHibernateQuery(hqSb.toString())
							.setParameter("tagId", tagId)
							.setParameter("status", status);
		
		return query.list();
	}

	public List<Post> get() {
		return this.get(null);
	}
	
	public List<Post> get(PostStatus status) {
		StringBuilder hqSb = new StringBuilder();
		hqSb.append("from Post ");
		if(status != null){
			hqSb.append("where status = :status ");
		}
		hqSb.append("order by publishTime, createTime");
		
		Query query = super.createHibernateQuery(hqSb.toString());
		if(status != null){
			query = query.setParameter("status", status);
		}
		
		return query.list();
	}

}
