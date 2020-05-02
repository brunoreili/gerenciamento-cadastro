package gerenciamento.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import gerenciamento.dao.TelefoneDao;
import gerenciamento.entity.Telefone;

@Stateless
public class GerenciamentoTelefonesBusiness {

	@Inject
	private TelefoneDao telefoneDao;
	
	public List<Telefone> buscarTelefones(Integer idPessoa) {
		return telefoneDao.buscarTelefones(idPessoa);
	}

	public Long salvarTelefone(@Valid Telefone telefone) {
		return telefoneDao.savarTelefone(telefone);
	}

	public void editarTelefone(Integer id, @Valid Telefone telefone) {
		telefoneDao.editarTelefone(id, telefone);	
	}

	public void excluirTelefone(Integer id) {
		telefoneDao.excluirTelefone(id);	
	}
}
