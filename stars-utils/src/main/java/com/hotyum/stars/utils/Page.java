package com.hotyum.stars.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = 8166807604629706390L;

	private int pageNum = 1;// 页码

	private int pageSize = 10;// 每页数

	private int startRow = 0;// 起始数

	private int pages = 0;// 总页数

	private int total = 0;// 总记录数

	private List<T> list = new ArrayList<T>();

	private boolean hasPrePage = false;

	private boolean hasNextPage = false;

	public Page() {
	}

	public Page(int total, List<T> list) {
		super();
		this.total = total;
		this.list = list;
	}

	public Page(int pageSize, int pageNum, int total, List<T> list) {
		this.pageSize = pageSize;
		this.pageNum = (pageNum == 0 ? 1 : pageNum);
		this.total = total;
		this.list = list;
		this.startRow = Page.calstartRow(pageNum, pageSize);
		this.pages = Page.calpages(total, pageSize);
		this.hasPrePage = Page.calHasPrePage(pageNum);
		this.hasNextPage = Page.calHasNextPage(pageNum, pages);
	}

	public int getpageNum() {
		return pageNum;
	}

	public void setpageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getstartRow() {
		return startRow;
	}

	public void setstartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getpages() {
		return pages;
	}

	public void setpages(int pages) {
		this.pages = pages;
	}

	public int gettotal() {
		return total;
	}

	public void settotal(int total) {
		this.total = total;
	}

	public List<T> getlist() {
		return list;
	}

	public void setlist(List<T> list) {
		this.list = list;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public static Integer calstartRow(Integer pageNum, Integer pageSize) {
		return (pageNum - 1) * pageSize;
	}

	public static Integer calpages(Integer total, Integer pageSize) {
		if (total % pageSize == 0) {
			return total / pageSize;
		} else {
			return total / pageSize + 1;
		}
	}

	public static boolean calHasPrePage(Integer pageNum) {
		return pageNum == 1 ? false : true;
	}

	public static boolean calHasNextPage(Integer pageNum, Integer pages) {
		return pageNum == pages || pages == 0 ? false : true;
	}

}
