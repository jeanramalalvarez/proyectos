package macrosoft.crexsa.dao;

import java.util.List;

import macrosoft.crexsa.domain.Marca;
import macrosoft.crexsa.util.hibernate.HibernateBaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class MarcaDaoImpl extends HibernateBaseDaoImpl implements MarcaDao {
	
	@Override
	public void grabarOModificar(Marca marca) {
		super.grabarOModificar(marca);
	}

	@Override
	public Marca obtenerPorId(Marca marca) {
		return super.buscarPorId(marca.getClass(), marca.getIdMrca());
	}

	@Override
	public List<Marca> listarMarcasPorSQL(String queryString) {
		return super.buscarPorSQL(queryString, Marca.class);
	}

}
