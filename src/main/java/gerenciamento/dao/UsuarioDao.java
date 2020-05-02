package gerenciamento.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import gerenciamento.entity.Usuario;
import gerenciamento.form.UsuarioForm;

@Stateless
public class UsuarioDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Usuario buscarUsuario(@Valid UsuarioForm usuarioForm) {
		
		Usuario usuario = new Usuario();
		try {
			usuario = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.login = '" + usuarioForm.getLogin() + "'"
					+ "AND u.senha = '" + usuarioForm.getSenha() + "'", Usuario.class).getSingleResult();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

}
