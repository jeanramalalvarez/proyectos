package macrosoft.crexsa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import macrosoft.crexsa.domain.TipoHilado;
import macrosoft.crexsa.util.hibernate.HibernateBaseDaoImpl;

@Repository
public class TipoHiladoDaoImpl extends HibernateBaseDaoImpl implements TipoHiladoDao {

	@Override
	public List<TipoHilado> listarTipoHilados() {
		return super.buscarTodos(TipoHilado.class);
	}

}
