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
	
	public void editarOperador(Integer id, Operador operador) {
		
		Operador op = entityManager.createQuery("SELECT o FROM Operador o WHERE o.id = " + id, Operador.class).getSingleResult();
		System.out.println(op);
		
		op.setDataCadastro(LocalDateTime.now());
		op.setNome("Mudei o nome mas o ID ainda é 7!");
		entityManager.merge(op);
	}
	
	public void excluirOperador(Integer id) {
		
		Operador op = entityManager.createQuery("SELECT o FROM Operador o WHERE o.id = " + id, Operador.class).getSingleResult();
		entityManager.remove(op);
	}
	
}
