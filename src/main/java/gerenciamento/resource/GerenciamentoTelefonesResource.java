package gerenciamento.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gerenciamento.business.GerenciamentoPessoasBusiness;
import gerenciamento.business.GerenciamentoTelefonesBusiness;
import gerenciamento.dto.TelefoneListagemDto;
import gerenciamento.entity.Pessoa;
import gerenciamento.entity.Telefone;
import gerenciamento.form.TelefoneForm;

@Path("/telefones")
public class GerenciamentoTelefonesResource {

	@Inject
	private GerenciamentoTelefonesBusiness gerenciamentoTelefonesBusiness;
	
	@Inject
	private GerenciamentoPessoasBusiness gerenciamentoPessoasBusiness;

	@GET
	@Path("/{idPessoa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTelefones(@PathParam("idPessoa") Integer idPessoa) {

		List<Telefone> telefones = gerenciamentoTelefonesBusiness.buscarTelefones(idPessoa);
		List<TelefoneListagemDto> telefoneListagemDto = TelefoneListagemDto.converter(telefones);

		return Response.ok(telefoneListagemDto).header("Access-Control-Allow-Origin", "*").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SalvarTelefone(TelefoneForm telefoneForm) {

		Pessoa pessoa = gerenciamentoPessoasBusiness.buscarPessoa(telefoneForm.getPessoaId());
		Telefone telefone = TelefoneForm.converter(telefoneForm, pessoa);
		
		gerenciamentoTelefonesBusiness.salvarTelefone(telefone);
		return Response.status(201).header("Access-Control-Allow-Origin", "*").build();
	}
}