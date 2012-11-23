package macrosoft.crexsa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import macrosoft.crexsa.domain.UnidadMedida;
import macrosoft.crexsa.util.hibernate.HibernateBaseDaoImpl;

@Repository
public class UnidadMedidaDaoImpl extends HibernateBaseDaoImpl implements UnidadMedidaDao {

	@Override
	public List<UnidadMedida> listarUnidadMedidaPorSQL(String queryString) {
		return super.buscarPorSQL(queryString, UnidadMedida.class);
	}

}
