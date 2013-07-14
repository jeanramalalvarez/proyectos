package com.br.brazilpanels.bean;

import java.util.List;

public class DataBean {
	
	private String status;
	
	private List<ResultBean> results;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<ResultBean> getResults() {
		return results;
	}
	
	public void setResults(List<ResultBean> results) {
		this.results = results;
	}

}
