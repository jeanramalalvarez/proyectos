package macrosoft.crexsa.service;

import java.util.List;
import java.util.Map;

import macrosoft.crexsa.dao.MarcaDao;
import macrosoft.crexsa.domain.Marca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements MarcaService {
	
	@Autowired
	MarcaDao marcaDao;
	
	@Override
	public void grabarOModificar(Marca marca) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Marca obtenerPorId(Marca marca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marca> listarMarcaPorInTipoProd(String inTipoProducto) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT m.id_mrca idMrca, ");
		sql.append("       m.de_mrca deMrca ");
		sql.append("  FROM marca m ");
		sql.append(" WHERE m.in_regi_acti = '1' ");
		sql.append(   "AND m.in_tipo_prod = '" + inTipoProducto + "'");
		return marcaDao.listarMarcasPorSQL(sql.toString());
	}

	@Override
	public List<Marca> buscarMarcas(Map<String, Object> parametros) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT m.id_mrca idMrca, ");
		sql.append("       m.de_mrca deMrca, ");
		sql.append("       CASE m.in_tipo_prod WHEN 'H' THEN 'HILO' ELSE 'TELA' END inTipoProd, ");
		sql.append("       CASE m.in_regi_acti WHEN '1' THEN 'HABILITADO' ELSE 'DESHABILITADO' END inRegiActi ");
		sql.append("  FROM marca m ");
		if(parametros != null){
			sql.append("  WHERE ");	
			if(parametros.get("de_mrca") != null){	
			   sql.append(" m.de_mrca like '%" + parametros.get("de_mrca") + "%' ");
			}
		}
		return marcaDao.listarMarcasPorSQL(sql.toString());
	}

}
