package macrosoft.crexsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import macrosoft.crexsa.dao.TipoTransaccionDao;
import macrosoft.crexsa.domain.TipoTransaccion;

@Service
public class TipoTransaccionServiceImpl implements TipoTransaccionService {
	
	@Autowired
	TipoTransaccionDao tipoTransaccionDao;

	@Override
	public List<TipoTransaccion> listarTipoTransaccionActivos() {
		return tipoTransaccionDao.listarTipoTransaccion("from TipoTransaccion t where t.inRegiActi = '1'", null);
	}

}
