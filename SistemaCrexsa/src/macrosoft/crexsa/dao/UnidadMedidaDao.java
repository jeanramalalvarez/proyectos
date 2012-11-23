package macrosoft.crexsa.dao;

import java.util.List;

import macrosoft.crexsa.domain.UnidadMedida;

public interface UnidadMedidaDao {
	
	List<UnidadMedida> listarUnidadMedidaPorSQL(String queryString);

}
