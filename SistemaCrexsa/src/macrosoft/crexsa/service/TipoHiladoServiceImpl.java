package macrosoft.crexsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import macrosoft.crexsa.dao.TipoHiladoDao;
import macrosoft.crexsa.domain.TipoHilado;

@Service
public class TipoHiladoServiceImpl implements TipoHiladoService {
	
	@Autowired
	TipoHiladoDao hiladoDao;

	@Override
	public List<TipoHilado> listarTipoHilados() {
		return hiladoDao.listarTipoHilados();
	}

}
