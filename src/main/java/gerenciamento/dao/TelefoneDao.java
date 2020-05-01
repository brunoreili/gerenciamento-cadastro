package gerenciamento.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gerenciamento.entity.Telefone;

@Stateless
public class TelefoneDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Telefone> buscarTelefones(Integer idPessoa) {
		return entityManager.createQuery("SELECT t FROM Telefone t WHERE t.pessoa.id = " + idPessoa, Telefone.class).getResultList();
	}

	public void savarTelefone(Telefone telefone) {
		entityManager.persist(telefone);
	}
}
