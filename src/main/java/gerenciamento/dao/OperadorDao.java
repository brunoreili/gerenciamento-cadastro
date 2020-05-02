package gerenciamento.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gerenciamento.dto.OperadorLoginDto;
import gerenciamento.entity.Operador;

@Stateless
public class OperadorDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Operador> listarOperadores() {
		return entityManager.createQuery("SELECT o FROM Operador o", Operador.class).getResultList();
	}
	
	public Operador buscarOperador(Integer id) {
		Operador operador = entityManager.createQuery("SELECT o FROM Operador o WHERE o.id = " + id, Operador.class).getSingleResult();;
		return operador;
	}
	
	public Operador buscarOperador(OperadorLoginDto operadorLoginDto) {
		
		Operador operador = new Operador();
		
		try {
			operador = entityManager.createQuery(
					"SELECT o FROM Operador o WHERE o.login = '" + operadorLoginDto.getLogin() + "'"
				  + "AND o.senha = '" + operadorLoginDto.getSenha() + "'", Operador.class).getSingleResult();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return operador;
	}
	
	public void salvarOperador(Operador operador) {
		entityManager.persist(operador);
	}
	
	public void editarOperador(Integer id, Operador operador) {
		
		Operador operadorEditado = buscarOperador(id);
		
		operadorEditado.setNome(operador.getNome());
		operadorEditado.setSenha(operador.getSenha());
		operadorEditado.setPerfil(operador.getPerfil());
		entityManager.merge(operadorEditado);
	}
	
	public void excluirOperador(Integer id) {
		
		Operador operador = buscarOperador( id);
		entityManager.remove(operador);
	}
}