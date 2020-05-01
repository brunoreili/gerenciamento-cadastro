package gerenciamento.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gerenciamento.business.GerenciamentoPessoasBusiness;
import gerenciamento.dto.PessoaDto;
import gerenciamento.dto.PessoaListagemDto;
import gerenciamento.dto.TelefoneListagemDto;
import gerenciamento.entity.Pessoa;
import gerenciamento.entity.Telefone;

@Path("/pessoas")
public class GerenciamentoPessoasResource {
	
	@Inject
	private GerenciamentoPessoasBusiness gerenciamentoPessoasBusiness;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListarPessoas() {
		
		List<Pessoa> pessoas = gerenciamentoPessoasBusiness.listarPessoas();
		List<PessoaListagemDto> pessoaListagem = PessoaListagemDto.converter(pessoas);
		
		return Response.ok(pessoaListagem).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPessoa(@PathParam("id") Integer id) {
		
		Pessoa pessoa = gerenciamentoPessoasBusiness.buscarPessoa(id);
		List<Telefone> telefones = pessoa.getTelefone();
		
		List<TelefoneListagemDto> telefonesDto = TelefoneListagemDto.converter(telefones);
		PessoaDto pessoaDto = PessoaDto.converter(pessoa, telefonesDto);
		
		return Response.ok(pessoaDto).header("Access-Control-Allow-Origin", "*").build();	
	}
}
