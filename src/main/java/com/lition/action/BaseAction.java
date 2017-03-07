package com.lition.action;

import com.lition.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	protected int currentPage = 1;
	
	protected int pageSize = 5;
	
	protected PageModel pageModel;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

}
