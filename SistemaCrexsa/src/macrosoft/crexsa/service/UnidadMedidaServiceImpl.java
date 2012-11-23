package macrosoft.crexsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import macrosoft.crexsa.dao.UnidadMedidaDao;
import macrosoft.crexsa.domain.TipoHilado;
import macrosoft.crexsa.domain.UnidadMedida;

@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService {
	
	@Autowired
	UnidadMedidaDao unidadMedidaDao;

	@Override
	public List<UnidadMedida> listarUnidadMedidaPorTipoHilado(TipoHilado tipoHilado) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT um.id_unid_medi idUnidMedi,");
		sql.append("       um.co_unid_medi coUnidMedi,");
		sql.append("       um.de_unid_medi deUnidMedi");
		sql.append("  FROM unidad_medida um, ");
		sql.append("       unidad_medida_tipo_hilado umth");
		sql.append(" WHERE um.id_unid_medi = umth.id_unid_medi");
		sql.append("   AND um.in_regi_acti = '1' ");
		sql.append("   AND umth.id_tipo_hldo = " + tipoHilado.getIdTipoHldo());
		return unidadMedidaDao.listarUnidadMedidaPorSQL(sql.toString());
	}

	@Override
	public List<UnidadMedida> listarUnidadMedidaPorInTipoProd(String inTipoProducto) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT um.id_unid_medi idUnidMedi,");
		sql.append("       um.co_unid_medi coUnidMedi,");
		sql.append("       um.de_unid_medi deUnidMedi ");
		sql.append("  FROM unidad_medida um ");
		sql.append(" WHERE um.in_regi_acti = '1' ");
		sql.append("   AND um.in_tipo_prod = '" + inTipoProducto + "'");
		return unidadMedidaDao.listarUnidadMedidaPorSQL(sql.toString());
	}

}
