package com.br.brazilpanels.dao;

import java.util.List;

import com.br.brazilpanels.bean.ResultBean;

public interface ResultBeanDao {
	
	void saveOrUpdate(ResultBean resultBean);
	void saveOrUpdateBatch(List<ResultBean> resultBeans);
	List<ResultBean> findAll();

}
