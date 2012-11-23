package macrosoft.crexsa.dao;

import java.util.List;

import macrosoft.crexsa.domain.TipoTransaccion;

public interface TipoTransaccionDao {
	
	List<TipoTransaccion> listarTipoTransaccion(String queryString, Object[] arg1);

}
