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

}
