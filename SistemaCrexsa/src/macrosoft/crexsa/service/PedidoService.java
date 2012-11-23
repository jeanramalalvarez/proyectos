package macrosoft.crexsa.service;

import java.util.List;
import java.util.Map;

import macrosoft.crexsa.domain.Pedido;

public interface PedidoService {
	
	void grabarPedido(Pedido pedido);
	void grabarOModificarPedido(Pedido pedido);
	int anularPedido(Pedido pedido);
	Pedido obtenerPedidoPorId(Pedido pedido);
	List<Pedido> buscarPedidos(Map<String, Object> parametros);

}
