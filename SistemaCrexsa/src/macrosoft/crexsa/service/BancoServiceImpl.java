package macrosoft.crexsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import macrosoft.crexsa.dao.BancoDao;
import macrosoft.crexsa.domain.Banco;

@Service
public class BancoServiceImpl implements BancoService {
	
	@Autowired
	BancoDao bancoDao;

	@Override
	public List<Banco> listarBancos() {
		return bancoDao.listarBancos();
	}

}
