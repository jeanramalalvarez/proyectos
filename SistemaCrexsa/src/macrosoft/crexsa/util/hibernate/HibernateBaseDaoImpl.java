package macrosoft.crexsa.util.hibernate;

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

	public <T> void grabar(T entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public <T> void grabarOModificar(T entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public <T> void modificar(T entity) {
		this.getCurrentSession().update(entity);
		//this.getCurrentSession().merge(entity);
	}
	
	public int modificar(String queryString, Object[] arg1) {
		Query query = this.getCurrentSession().createQuery(queryString);
		if(arg1 != null) for (int i = 0; i < arg1.length; i++) {query.setParameter(i, arg1[i]);}		
		return query.executeUpdate();
	}
	
	public <T> void eliminar(T entity) {
		this.getCurrentSession().delete(entity);
	}
	
	public <T> void eliminarPorId(Class entity, Object id) {
		this.eliminar(this.buscarPorId(entity, id));
	}
	
	public <T> T buscarPorId(Class entity, Object id) {
		return (T) this.getCurrentSession().get(entity, (Serializable) id);
	}
	
	public <T> List<T> buscar(String queryString) {
		return this.getCurrentSession().createQuery(queryString).list();
	}
	
	public <T> List<T> buscarTodos(Class entity) {
		return this.getCurrentSession().createQuery("from " + entity.getName()).list();
	}
	
	public <T> List<T> buscarPorSQL(String queryString, Class entity) {
		return this.getCurrentSession().createSQLQuery(queryString).setResultTransformer(Transformers.aliasToBean(entity)).list();
	}
	
	public <T> List<T> buscar(String queryString, Object[] arg1) {
		Query query = this.getCurrentSession().createQuery(queryString);
		if(arg1 != null) for (int i = 0; i < arg1.length; i++) {query.setParameter(i, arg1[i]);}			
		return query.list();
	}
	
	protected final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
   }

}
