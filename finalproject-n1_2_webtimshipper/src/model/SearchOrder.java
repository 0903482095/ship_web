package model;

import java.io.Serializable;

public class SearchOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	private String keyWord;
	private Integer page;
	private Integer pageSize;
	private Integer totalPage;
	private Integer total;
	private Integer userOrderId;

	public SearchOrder() {
		super();
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getUserOrderId() {
		return userOrderId;
	}

	public void setUserOrderId(Integer userOrderId) {
		this.userOrderId = userOrderId;
	}

}
