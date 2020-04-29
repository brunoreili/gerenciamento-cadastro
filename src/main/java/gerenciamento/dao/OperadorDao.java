package gerenciamento.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gerenciamento.entity.Operador;

@Stateless
public class OperadorDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Operador> listarOperadores() {
		return entityManager.createQuery("SELECT o FROM Operador o", Operador.class).getResultList();
	}	
	
	public void salvarOperador(Operador operador) {
		entityManager.persist(operador);
	}
	
}
