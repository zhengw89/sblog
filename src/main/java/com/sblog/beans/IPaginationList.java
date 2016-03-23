package com.sblog.beans;

import com.sblog.beans.IPaginationList;

public interface IPaginationList {

	int getPageIndex();
	
	void setPageIndex(int pageIndex);
	
	int getPageSize();
	
	void setPageSize(int pageSize);
	
	int getStartIndex();
	
	void setStartIndex(int startIndex);
	
	int getEndIndex();
	
	void setEndIndex(int endIndex);
	
	int getTotalItemCount();
	
	void setTotalItemCount(int totalItemCount);
	
	int getTotalPageCount();
	
	void setTotalPageCount(int totalPageCount);
	
	void CopyPageInfo(IPaginationList paginationList);
}
