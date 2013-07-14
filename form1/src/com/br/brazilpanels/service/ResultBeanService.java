package com.br.brazilpanels.service;

import java.util.List;

import com.br.brazilpanels.bean.ResultBean;

public interface ResultBeanService {
	
	void saveOrUpdate(ResultBean resultBean);
	void saveOrUpdateBatch(List<ResultBean> resultBeans);
	List<ResultBean> findAll();

}
