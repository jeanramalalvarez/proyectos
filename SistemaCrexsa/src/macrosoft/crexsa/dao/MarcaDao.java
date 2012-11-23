package macrosoft.crexsa.dao;

import java.util.List;

import macrosoft.crexsa.domain.Marca;

public interface MarcaDao {

	void grabarOModificar(Marca marca);
	Marca obtenerPorId(Marca marca);
	List<Marca> listarMarcasPorSQL(String queryString);

}
