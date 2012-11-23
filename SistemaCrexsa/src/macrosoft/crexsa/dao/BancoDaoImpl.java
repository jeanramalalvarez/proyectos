package macrosoft.crexsa.dao;

import java.util.List;

import macrosoft.crexsa.domain.Banco;
import macrosoft.crexsa.util.hibernate.HibernateBaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class BancoDaoImpl extends HibernateBaseDaoImpl implements BancoDao {

	@Override
	public List<Banco> listarBancos(){
		return super.buscarTodos(Banco.class);
	}

}
