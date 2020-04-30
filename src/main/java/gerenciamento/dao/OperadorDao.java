package gerenciamento.dao;

import java.time.LocalDateTime;
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
		
		operador.setDataCadastro(LocalDateTime.now());
		entityManager.persist(operador);
	}
	
}
