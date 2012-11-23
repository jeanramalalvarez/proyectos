package macrosoft.crexsa.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import macrosoft.crexsa.dao.PedidoDao;
import macrosoft.crexsa.domain.Pedido;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoDao pedidoDao;

	@Override
	public void grabarPedido(Pedido pedido) {
		pedidoDao.grabarPedido(pedido);
	}
	

	@Override
	public void grabarOModificarPedido(Pedido pedido) {
		pedidoDao.grabarOModificarPedido(pedido);
	}

	@Override
	public int anularPedido(Pedido pedido) {
		return pedidoDao.modificarPedido("update Pedido p set p.inRegiActi = '0' where p.nuPedi = " + pedido.getNuPedi(), null);
	}

	@Override
	public Pedido obtenerPedidoPorId(Pedido pedido) {
		return pedidoDao.obtenerPedidoPorId(pedido);
	}

	@Override
	public List<Pedido> buscarPedidos(Map<String, Object> parametros) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select p.nu_pedi as nuPedi,");
		sql.append("        p.fe_pedi       fePedi, ");
		sql.append("        p.de_prof_invo  deProfInvo, ");
		sql.append("        h.de_hldo       deHldo, ");
		sql.append("        b.no_bnco       noBnco, ");
		sql.append("        p.no_carg       noCarg, ");
		sql.append("        p.nu_cost_cif   nuCostCif, ");
		sql.append("        p.nu_cost_tota  nuCostTota, ");
		sql.append("        p.nu_prec_vent  nuPrecVent ");
		sql.append("        from pedido p, ");
		sql.append("        tipo_hilado h, ");
		sql.append("        banco b ");
		sql.append("  where p.id_tipo_hldo = h.id_tipo_hldo ");
		sql.append("    and p.id_bnco = b.id_bnco "); 
		sql.append("    and p.in_regi_acti = '1' ");
		if(parametros != null){
			if(parametros.get("nu_pedi") != null){	
		       sql.append("    and p.nu_pedi = " + parametros.get("nu_pedi"));
			}
			if(parametros.get("fec_ini") != null){
			   sql.append("    and p.fe_pedi between '" + parametros.get("fec_ini") + "' and '" + parametros.get("fec_fin") + "'");
			   //sql.append("    and p.fe_pedi between DATE_FORMAT(" + parametros.get("fec_ini") + ", '%Y-%m-%e') and " + "DATE_FORMAT(" + parametros.get("fec_fin") + ", '%Y-%m-%e')");
			}
		}
		sql.append(" order by p.nu_pedi desc ");
		return pedidoDao.listarPedidosPorSQL(sql.toString());
	}

}
