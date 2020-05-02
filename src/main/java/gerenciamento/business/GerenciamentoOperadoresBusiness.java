package gerenciamento.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import gerenciamento.dao.OperadorDao;
import gerenciamento.dto.OperadorLoginDto;
import gerenciamento.entity.Operador;

@Stateless
public class GerenciamentoOperadoresBusiness {
	
	@Inject
	private OperadorDao operadorDao;
	
	public List<Operador> listarOperadores() {		
		return operadorDao.listarOperadores();
	}
	
	public Operador buscarOperador(Integer id) {
		return operadorDao.buscarOperador(id);
	}
	
	public Operador buscarOperador(OperadorLoginDto operador) {
		return operadorDao.buscarOperador(operador);
	}
	
	public void salvarOperador(@Valid Operador operador) {		
		operadorDao.salvarOperador(operador);		
	}
	
	public void editarOperador(Integer id, @Valid Operador operador) {		
		operadorDao.editarOperador(id, operador);		
	}
	
	public void excluirOperador(Integer id) {		
		operadorDao.excluirOperador(id);
	}
}