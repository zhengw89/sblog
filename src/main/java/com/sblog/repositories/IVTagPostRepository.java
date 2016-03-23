package com.sblog.repositories;

import java.util.List;

import com.sblog.beans.PaginationList;
import com.sblog.beans.PostStatus;
import com.sblog.beans.TagSummary;
import com.sblog.beans.VTagPost;

public interface IVTagPostRepository {
	
	int getCount(String tagName, PostStatus status);
	
	List<TagSummary> getTagSummarys(PostStatus status);
	
	PaginationList<VTagPost> getPagination(String tagName, PostStatus status, int pageIndex, int pageSize);
}