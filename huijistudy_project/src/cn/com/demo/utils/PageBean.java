package cn.com.demo.utils;

import java.util.List;

public class PageBean {
	private int currPage;
	private int pageSize;
	private int totalPage;
	private int totalCount;
	private List<?> list;

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	
	public PageBean() {
		super();
	}
	
	public PageBean(int currPage,int pageSize,int totalCount){
		this.currPage=currPage;
		this.pageSize=pageSize;
		if(totalCount==0){
			totalPage=1;
		}else{
			this.totalPage=(int) Math.ceil(totalCount*1.0/pageSize);
		}
	}

}
