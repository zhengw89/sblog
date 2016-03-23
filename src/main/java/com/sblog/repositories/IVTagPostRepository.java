package com.sblog.repositories;

import com.sblog.beans.PaginationList;
import com.sblog.beans.PostStatus;
import com.sblog.beans.VTagPost;

public interface IVTagPostRepository {
	
	int getCount(String tagName, PostStatus status);
	
	PaginationList<VTagPost> getPagination(String tagName, PostStatus status, int pageIndex, int pageSize);
}