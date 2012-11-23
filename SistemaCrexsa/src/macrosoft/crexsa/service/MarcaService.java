package macrosoft.crexsa.service;

import java.util.List;
import java.util.Map;

import macrosoft.crexsa.domain.Marca;

public interface MarcaService {
	
	void grabarOModificar(Marca marca);
	Marca obtenerPorId(Marca marca);
	List<Marca> listarMarcaPorInTipoProd(String inTipoProducto);
	List<Marca> buscarMarcas(Map<String, Object> parametros);

}
