package gerenciamento.business;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import gerenciamento.dao.UsuarioDao;
import gerenciamento.entity.Usuario;
import gerenciamento.form.UsuarioForm;

@Stateless
public class GerenciamentoAutenticacaoBusiness {
	
	@Inject
	private UsuarioDao usuarioDao;

	public Usuario buscarUsuario(@Valid UsuarioForm usuarioForm) {
		return usuarioDao.buscarUsuario(usuarioForm);
	}

}
