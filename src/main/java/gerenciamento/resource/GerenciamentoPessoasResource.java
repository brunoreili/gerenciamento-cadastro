package gerenciamento.resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
import gerenciamento.form.PessoaForm;

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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SalvarPessoa(PessoaForm pessoaForm) {
		
		Pessoa pessoa = PessoaForm.converter(pessoaForm);		
		gerenciamentoPessoasBusiness.salvarPessoa(pessoa);
		return Response.status(201).header("Access-Control-Allow-Origin", "*").build();		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response EditarPessoa(@PathParam("id") Integer id, PessoaForm pessoaForm) {
		
		Pessoa pessoa = PessoaForm.converter(pessoaForm);
		gerenciamentoPessoasBusiness.editarPessoa(id, pessoa);
		return Response.status(200).header("Access-Control-Allow-Origin", "*").build();		
	}
	
	@DELETE
	@Path("/{id}")
	public Response ExcluirPessoa(@PathParam("id") Integer id) {
		
		gerenciamentoPessoasBusiness.excluirPessoa(id);
		return Response.status(200).header("Access-Control-Allow-Origin", "*").build();		
	}	
}