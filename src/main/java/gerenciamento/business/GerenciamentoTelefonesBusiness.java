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

	public void salvarTelefone(@Valid Telefone telefone) {
		telefoneDao.savarTelefone(telefone);
	}
}
