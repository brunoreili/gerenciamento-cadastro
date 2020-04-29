package gerenciamento.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import gerenciamento.dao.OperadorDao;
import gerenciamento.entity.Operador;

@Stateless
public class GerenciamentoOperadoresBusiness {
	
	@Inject
	private OperadorDao operadorDao;
	
	public List<Operador> listarOperadores() {		
		return operadorDao.listarOperadores();
	}
	
	public void salvarOperador(Operador operador) {
		
		operadorDao.salvarOperador(operador);
		
	}

}
