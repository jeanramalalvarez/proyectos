package macrosoft.crexsa.service;

import java.util.List;

import macrosoft.crexsa.domain.TipoHilado;
import macrosoft.crexsa.domain.UnidadMedida;

public interface UnidadMedidaService {
	
	List<UnidadMedida> listarUnidadMedidaPorTipoHilado(TipoHilado tipoHilado);
	List<UnidadMedida> listarUnidadMedidaPorInTipoProd(String inTipoProducto);

}
