package gerenciamento.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

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

	public void salvarPessoa(@Valid Pessoa pessoa) {
		pessoaDao.salvarPessoa(pessoa);		
	}

	public void editarPessoa(Integer id, @Valid Pessoa pessoa) {
		pessoaDao.editarPessoa(id, pessoa);			
	}

	public void excluirPessoa(Integer id) {
		pessoaDao.excluirPessoa(id);		
	}	
}