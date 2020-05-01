package gerenciamento.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import gerenciamento.dao.PessoaDao;
import gerenciamento.entity.Pessoa;

@Stateless
public class GerenciamentoPessoasBusiness {
	
	@Inject
	private PessoaDao pessoaDao;

	public List<Pessoa> listarPessoas() {
		return pessoaDao.listarPessoas();
	}
	
	public Pessoa buscarPessoa(Integer id) {
		return pessoaDao.buscarPessoa(id);
	}

}
