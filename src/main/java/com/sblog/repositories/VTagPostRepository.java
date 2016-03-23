package com.sblog.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.sblog.beans.PaginationList;
import com.sblog.beans.PostStatus;
import com.sblog.beans.VTagPost;

@Repository("vTagPostRepository")
public class VTagPostRepository extends BaseRepository<VTagPost> implements IVTagPostRepository {

	@Autowired
	protected VTagPostRepository(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public int getCount(String tagName, PostStatus status) {
		return DataAccessUtils.intResult(
				getHibernateTemplate().find("select count(*) from VTagPost where tagName = ? and postStatus = ?", tagName, status)
			);
	}

	public PaginationList<VTagPost> getPagination(String tagName, PostStatus status, int pageIndex, int pageSize) {
		int skip = (pageIndex - 1) * pageSize;
		Query query = super.createHibernateQuery("from VTagPost where tagName = :tagName and postStatus = :postStatus order by postPublishTime desc");
		query.setString("tagName", tagName);
		query.setInteger("postStatus", status.ordinal());
		query.setFirstResult(skip);
		query.setMaxResults(pageSize);
		
		List<VTagPost> posts = (List<VTagPost>)query.list();
		
		int totalCount = this.getCount(tagName, status);
		
		PaginationList<VTagPost> paginationList = new PaginationList<VTagPost>();
		paginationList.setPageSize(pageSize);
		paginationList.setEndIndex(totalCount > (skip + pageSize) ? (skip + pageSize) : totalCount);
		paginationList.setPageIndex(pageIndex);
		paginationList.setStartIndex(skip + 1);
		paginationList.setTotalItemCount(totalCount);
		paginationList.setTotalPageCount(totalCount%pageSize == 0 ? totalCount/pageSize : (totalCount/pageSize)+1);
		paginationList.addAll(posts);
		
		return paginationList;
	}
}
