package macrosoft.crexsa.dao;

import java.util.List;

import macrosoft.crexsa.domain.Pedido;


public interface PedidoDao{
	
	void grabarPedido(Pedido pedido);
	void grabarOModificarPedido(Pedido pedido);
	int modificarPedido(String queryString, Object[] arg1);
	Pedido obtenerPedidoPorId(Pedido pedido);
	List<Pedido> listarPedidos();
	List<Pedido> listarPedidosPorSQL(String queryString);
	List<Pedido> listarPedidos(String queryString, Object[] arg1);
}
