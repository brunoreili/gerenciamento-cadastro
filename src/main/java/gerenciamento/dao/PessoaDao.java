package gerenciamento.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gerenciamento.entity.Pessoa;

@Stateless
public class PessoaDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Pessoa> listarPessoas() {
		return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
	}
	
	public Pessoa buscarPessoa(Integer id) {
		Pessoa pessoa = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.id = " + id, Pessoa.class).getSingleResult();
		return pessoa;
	}

	public void salvarPessoa(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}

	public void editarPessoa(Integer id, Pessoa pessoa) {
		Pessoa pessoaEditada = buscarPessoa(id);
		
		pessoaEditada.setNome(pessoa.getNome());
		pessoaEditada.setNomeMae(pessoa.getNomeMae());
		pessoaEditada.setNomePai(pessoa.getNomePai());
		pessoaEditada.setTipoPessoa(pessoa.getTipoPessoa());
		pessoaEditada.setDataNascimento(pessoa.getDataNascimento());		
		entityManager.merge(pessoaEditada);		
	}

	public void excluirPessoa(Integer id) {
		Pessoa pessoa = buscarPessoa(id);
		entityManager.remove(pessoa);
	}
}