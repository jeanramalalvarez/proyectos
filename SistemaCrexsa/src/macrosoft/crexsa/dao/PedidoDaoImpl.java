package macrosoft.crexsa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import macrosoft.crexsa.domain.Pedido;
import macrosoft.crexsa.util.hibernate.HibernateBaseDaoImpl;

@Repository
public class PedidoDaoImpl extends HibernateBaseDaoImpl implements PedidoDao {


	@Override
	public void grabarPedido(Pedido pedido) {
		super.grabar(pedido);
	}
	
	@Override
	public void grabarOModificarPedido(Pedido pedido) {
		super.grabarOModificar(pedido);
	}
	
	@Override
	public int modificarPedido(String queryString, Object[] arg1) {
		return super.modificar(queryString, arg1);
	}

	@Override
	public Pedido obtenerPedidoPorId(Pedido pedido) {
		return super.buscarPorId(pedido.getClass(), pedido.getNuPedi());
	}
	
	@Override
	public List<Pedido> listarPedidos() {
		return super.buscarTodos(Pedido.class);
	}

	@Override
	public List<Pedido> listarPedidosPorSQL(String queryString) {
		return super.buscarPorSQL(queryString, Pedido.class);
	}

	@Override
	public List<Pedido> listarPedidos(String queryString, Object[] arg1) {
		return super.buscar(queryString, arg1);
	}

}
