package com.jd.helper;

import java.util.List;

public class Page<T> {

	private int currentPage;
	private int pageSize;
	
	private int totleRecord;
	private List<T> list;
	
	public Page(int currentPage, int pageSize){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	
	// 获得总页码---------------------------
	public int getTotlePage(){
		return (totleRecord+pageSize - 1) / pageSize;
	}
	
	// 上一页---------------------------
	public int getUpPage(){
		if(currentPage > 1){
			return currentPage-1;
		}
		return currentPage;
	}
	
	// 下一页---------------------------
	public int getDownPage(){
		if(currentPage < getTotlePage()){
			return currentPage+1;
		}
		return currentPage;
	}

	
	// get set----------------------------
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

	public int getTotleRecord() {
		return totleRecord;
	}

	public void setTotleRecord(int totleRecord) {
		this.totleRecord = totleRecord;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
