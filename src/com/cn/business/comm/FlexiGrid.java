package com.cn.business.comm;

import java.util.List;

/**
 * FlexGrid 表格组件
 * @author changjun
 */
public class FlexiGrid {
	//页码，第几页
	private int page;			
	//初始化的每页记录大小
	private int rp;				
	//动态改变的每页记录大小
	private int rpOptions;		
	//总记录数
	private int total;			
	//排序的字段名称
	private String sortname;	
	//排序的方式
	private String sortorder;	
	//记录，数据行
	private List rows;
	 
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public int getRpOptions() {
		return rpOptions;
	}
	public void setRpOptions(int rpOptions) {
		this.rpOptions = rpOptions;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	public String getSortorder() {
		return sortorder;
	}
	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
 
	
	

}
