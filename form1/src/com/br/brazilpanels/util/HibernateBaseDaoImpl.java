package com.br.brazilpanels.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings({"unchecked","rawtypes"})
public class HibernateBaseDaoImpl {
	
	@Autowired
	SessionFactory sessionFactory;

	public <T> void save(T entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public <T> void saveOrUpdate(T entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public <T> void update(T entity) {
		this.getCurrentSession().update(entity);
	}
	
	public int update(String queryString, Object[] arg1) {
		Query query = this.getCurrentSession().createQuery(queryString);
		if(arg1 != null) for (int i = 0; i < arg1.length; i++) {query.setParameter(i, arg1[i]);}		
		return query.executeUpdate();
	}
	
	public <T> void delete(T entity) {
		this.getCurrentSession().delete(entity);
	}
	
	public <T> void deleteById(Class entity, Object id) {
		this.delete(this.findById(entity, id));
	}
	
	public <T> T findById(Class entity, Object id) {
		return (T) this.getCurrentSession().get(entity, (Serializable) id);
	}
	
	public <T> List<T> findList(String queryString) {
		return this.getCurrentSession().createQuery(queryString).list();
	}
	
	public <T> T findObject(String queryString) {
		return (T) this.getCurrentSession().createQuery(queryString).uniqueResult();
	}
	
	public <T> List<T> findAll(Class entity) {
		return this.getCurrentSession().createQuery("from " + entity.getName()).list();
	}
	
	public <T> List<T> findBySQL(String queryString, Class entity) {
		return this.getCurrentSession().createSQLQuery(queryString).setResultTransformer(Transformers.aliasToBean(entity)).list();
	}
	
	public <T> T findObjectPorSQL(String queryString, Class entity) {
		return (T) this.getCurrentSession().createSQLQuery(queryString).setResultTransformer(Transformers.aliasToBean(entity)).uniqueResult();
	}
	
	public <T> List<T> findList(String queryString, List<Object> params) {
		Query query = this.getCurrentSession().createQuery(queryString);
		if(params != null) for (int i = 0; i < params.size(); i++) {query.setParameter(i, params.get(i));}			
		return query.list();
	}
	
	public <T> T findObject(String queryString, List<Object> params) {
		Query query = this.getCurrentSession().createQuery(queryString);
		if(params != null) for (int i = 0; i < params.size(); i++) {query.setParameter(i, params.get(i));}			
		return (T) query.uniqueResult();
	}
	
	protected final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
   }

}