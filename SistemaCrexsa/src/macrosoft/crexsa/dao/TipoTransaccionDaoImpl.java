package macrosoft.crexsa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import macrosoft.crexsa.domain.TipoTransaccion;
import macrosoft.crexsa.util.hibernate.HibernateBaseDaoImpl;

@Repository
public class TipoTransaccionDaoImpl extends HibernateBaseDaoImpl implements TipoTransaccionDao {

	@Override
	public List<TipoTransaccion> listarTipoTransaccion(String queryString, Object[] arg1) {
		return super.buscar(queryString, arg1);
	}

}
