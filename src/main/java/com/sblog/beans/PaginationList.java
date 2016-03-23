package com.sblog.beans;

import java.util.ArrayList;

import com.sblog.beans.IPaginationList;

public class PaginationList<T> extends ArrayList<T> implements IPaginationList {

	private int pageIndex;
	
	private int pageSize;
	
	private int startIndex;
	
	private int endIndex;
	
	private int totalItemCount;
	
	private int totalPageCount;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getTotalItemCount() {
		return totalItemCount;
	}

	public void setTotalItemCount(int totalItemCount) {
		this.totalItemCount = totalItemCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public void CopyPageInfo(IPaginationList paginationList) {
		this.pageIndex = paginationList.getPageIndex();
		this.pageSize = paginationList.getPageSize();
		this.startIndex = paginationList.getStartIndex();
		this.endIndex = paginationList.getEndIndex();
		this.totalItemCount = paginationList.getTotalItemCount();
		this.totalPageCount = paginationList.getTotalItemCount();
	}
	
	public String getPaginationInfo() {
		return String.format("PageIndex:%d  PageSize:%d  StartIndex:%d  EndIndex:%d  TotalItemCount:%d  TotalPageCount:%d", 
				this.pageIndex, this.pageSize, this.startIndex, this.endIndex, this.totalItemCount, this.totalPageCount);
	}

}
