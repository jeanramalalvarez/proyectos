package com.br.brazilpanels.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.br.brazilpanels.bean.ResultBean;
import com.br.brazilpanels.util.HibernateBaseDaoImpl;

@Repository
@Scope("prototype")
public class ResultBeanDaoImpl extends HibernateBaseDaoImpl implements ResultBeanDao {

	@Override
	public void saveOrUpdate(ResultBean resultBean) {
		super.saveOrUpdate(resultBean);
	}
	
	@Override
	public void saveOrUpdateBatch(List<ResultBean> resultBeans) {
		//Session session = super.getCurrentSession();
		
		for (int i = 0; i < resultBeans.size(); i++) {
			super.saveOrUpdate(resultBeans.get(i));
			/*
			if(i%2==0){
				session.flush();
				session.clear();	
			}
			*/
		}
		//session.close();
		
	}

	@Override
	public List<ResultBean> findAll() {
		return super.findAll(ResultBean.class);
	}
}
