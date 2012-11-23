package macrosoft.crexsa.test;

import macrosoft.crexsa.domain.Pedido;
import macrosoft.crexsa.domain.TipoHilado;
import macrosoft.crexsa.domain.Usuario;
import macrosoft.crexsa.service.BancoService;
import macrosoft.crexsa.service.MarcaService;
import macrosoft.crexsa.service.PedidoService;
import macrosoft.crexsa.service.TipoHiladoService;
import macrosoft.crexsa.service.TipoTransaccionService;
import macrosoft.crexsa.service.UnidadMedidaService;
import macrosoft.crexsa.service.UsuarioService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Prueba extends AbstractBaseUnitTest {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	BancoService bancoService;

	@Autowired
	TipoHiladoService hiladoService;

	@Autowired
	PedidoService pedidoService;

	@Autowired
	TipoTransaccionService tipoTransaccionService;
	
	@Autowired
	MarcaService marcaService;
	
	@Autowired
	UnidadMedidaService unidadMedidaService;
	
	//@Test
	public void probarUnidadMedida() throws Exception {
	    TipoHilado tipoHilado = new TipoHilado();
	    tipoHilado.setIdTipoHldo(1);
		unidadMedidaService.listarUnidadMedidaPorTipoHilado(tipoHilado);
	}
	
	//@Test
	public void probarMarca() throws Exception {
	    TipoHilado tipoHilado = new TipoHilado();
	    tipoHilado.setIdTipoHldo(1);
		//marcaService.listarMarcaPorTipoHilado(tipoHilado);
	}
	//@Test //@Transactional
	public void probarTipoTransaccion() throws Exception {
		tipoTransaccionService.listarTipoTransaccionActivos();
	}

	// @Test //@Transactional
	public void probarPedido() throws Exception {

		Pedido pedido = new Pedido();
		pedido.setNuPedi(1);
		// pedido = pedidoDao.obtenerPedidoPorId(pedido);
		pedido.setInRegiActi("0");
		// pedidoDao.anularPedido(pedido);

		System.out.println(pedido);

		Object[] arg1 = new Object[1];
		arg1[0] = 1;
		// arg1[1] = 1;
		// pedidoDao.modificarPedido("update Pedido p set p.inRegiActi = '0' where p.nuPedi = 1",
		// null);

		// List<Pedido> lista = pedidoDao.listarPedidos();
		/*
		 * List<Pedido> lista = pedidoService.listarPedidosParaRegistro(); for
		 * (Pedido pedido2 : lista) {
		 * 
		 * }
		 */
		pedido.setNuPedi(70);
		pedido = pedidoService.obtenerPedidoPorId(pedido);
		System.out.println(pedido);

	}

	// @Test
	public void probarHilado() throws Exception {
		hiladoService.listarTipoHilados();
	}

	@Test
	public void probarBanco() throws Exception {
		bancoService.listarBancos();
	}

	//@Test
	// @Transactional
	public void probarCorreo() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setCoUsua("1");
		usuario.setDePassUsua("1");
		usuario = usuarioService.buscarUsuarioLogin(usuario);
		System.out.println(usuario);
		// usuarioService.grabarUsuario(usuario);
		/*
		 * Usuario usuario2 = new Usuario(); usuario2.setCoUsua("13");
		 * usuario2.setDePassUsua("7"); usuarioService.grabarUsuario(usuario2);
		 */
		// usuario.setDePassUsua("jean");
		// usuarioService.modificarUsuario(null);

		// usuarioDao.eliminarUsuario(usuario);
		// usuarioService.buscarPorId("1");
		// usuarioDao.eliminarPorIdUsuario("2");

		// System.out.println(usuarioService.buscarTodosUsuario().size());

		/*
		 * Session session = sessionFactory.getCurrentSession(); List<Usuario>
		 * lista = session.createQuery("from Usuario").list();
		 * System.out.println(lista.get(0).getCoUsua()); //session.close();
		 */
	}

}
