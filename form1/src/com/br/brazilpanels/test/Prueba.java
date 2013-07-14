package com.br.brazilpanels.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.br.brazilpanels.bean.ResultBean;
import com.br.brazilpanels.service.ResultBeanService;

public class Prueba extends AbstractBaseUnitTest {

	@Autowired
	ResultBeanService resultBeanService;
	
	@Test
	public void insrerta() throws Exception {
		ResultBean resultBean = new ResultBean();
		resultBean.setName("jean");
		/*
		List<ResultBean> resultBeans = new ArrayList<ResultBean>();
		for (int i = 1; i <= 1000000000; i++) {
			ResultBean resultBean = new ResultBean();
			resultBean.setName("jean"+i);
			resultBeans.add(resultBean);
				
		}
		resultBeanService.saveOrUpdateBatch(resultBeans);
		*/
		//resultBeanService.saveOrUpdate(resultBean);
		resultBeanService.findAll();
		
		
	}
}
