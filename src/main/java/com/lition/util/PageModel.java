package com.lition.util;

import java.util.List;

public class PageModel {
	
	private List result;

	/**
	 * 每页显示的条数
	 */
	private int pageSize=5;//
	
	/**
	 * 总体数
	 */
	private int totalCount;// 
	
	/**
	 * 当前页数
	 */
	private int currentPage = 1;
	
	/**
	 * 总页数
	 */
	private int pageCount;// 
	


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return (totalCount-1)/pageSize+1;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}

	

}
