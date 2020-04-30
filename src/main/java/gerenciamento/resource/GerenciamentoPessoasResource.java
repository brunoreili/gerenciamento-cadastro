package gerenciamento.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gerenciamento.business.GerenciamentoPessoasBusiness;
import gerenciamento.entity.Pessoa;

@Path("/pessoas")
public class GerenciamentoPessoasResource {
	
	@Inject
	private GerenciamentoPessoasBusiness gerenciamentoPessoasBusiness;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListarPessoas() {
		
		List<Pessoa> pessoas = gerenciamentoPessoasBusiness.listarPessoas();
		return Response.ok(pessoas).header("Access-Control-Allow-Origin", "*").build();
	}
}
