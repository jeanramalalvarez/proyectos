package com.br.brazilpanels.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.br.brazilpanels.bean.ResultBean;
import com.br.brazilpanels.dao.ResultBeanDao;

@Service
@Scope("singleton")
public class ResultBeanServiceImpl implements ResultBeanService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	ResultBeanDao resultBeanDao;

	@Override
	public void saveOrUpdate(ResultBean resultBean) {
		logger.debug("");
		resultBeanDao.saveOrUpdate(resultBean);
	}
	
	@Override
	public void saveOrUpdateBatch(List<ResultBean> resultBeans) {
		logger.debug("");
		resultBeanDao.saveOrUpdateBatch(resultBeans);
	}

	@Override
	public List<ResultBean> findAll() {
		logger.debug("");
		return resultBeanDao.findAll();
	}

}
