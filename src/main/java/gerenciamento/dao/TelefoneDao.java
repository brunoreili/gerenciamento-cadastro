package gerenciamento.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import gerenciamento.entity.Telefone;

@Stateless
public class TelefoneDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Telefone buscarTelefone(Integer id) {
		return entityManager.createQuery("SELECT t FROM Telefone t WHERE t.id = " + id, Telefone.class).getSingleResult();
	}
	
	public List<Telefone> buscarTelefones(Integer idPessoa) {
		return entityManager.createQuery("SELECT t FROM Telefone t WHERE t.pessoa.id = " + idPessoa, Telefone.class).getResultList();
	}

	public void savarTelefone(Telefone telefone) {
		entityManager.persist(telefone);
	}

	public void editarTelefone(Integer id, @Valid Telefone telefone) {
		Telefone telefoneEdiado = buscarTelefone(id);
		
		telefoneEdiado.setDdd(telefone.getDdd());
		telefoneEdiado.setNumero(telefone.getNumero());
		telefoneEdiado.setTipo(telefone.getTipo());		
		entityManager.merge(telefoneEdiado);		
	}

	public void excluirTelefone(Integer id) {
		Telefone telefone = buscarTelefone(id);
		entityManager.remove(telefone);		
	}
}
