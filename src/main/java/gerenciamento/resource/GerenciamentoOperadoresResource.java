package gerenciamento.resource;

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

import gerenciamento.business.GerenciamentoOperadoresBusiness;
import gerenciamento.dto.OperadorDto;
import gerenciamento.dto.OperadorListagemDto;
import gerenciamento.entity.Operador;

@Path("/operadores")
public class GerenciamentoOperadoresResource {
	
	@Inject
	private GerenciamentoOperadoresBusiness gerenciamentoOperadoresBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarOperadores() {
		
		List<Operador> operadores = gerenciamentoOperadoresBusiness.listarOperadores();
		List<OperadorListagemDto> operadorListagemDto = OperadorListagemDto.converter(operadores);
		
		return Response.ok(operadorListagemDto).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarOperador(@PathParam("id") Integer id) {
		
		Operador operador = gerenciamentoOperadoresBusiness.buscarOperador(id);
		OperadorDto operadorDto = OperadorDto.converter(operador);
		
		return Response.ok(operadorDto).header("Access-Control-Allow-Origin", "*").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SalvarOperador(Operador operador) {
		
		gerenciamentoOperadoresBusiness.salvarOperador(operador);
		return Response.status(201).header("Access-Control-Allow-Origin", "*").build();		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response EditarOperador(@PathParam("id") Integer id, Operador operador) {
		
		gerenciamentoOperadoresBusiness.editarOperador(id, operador);
		return Response.status(200).header("Access-Control-Allow-Origin", "*").build();		
	}
	
	@DELETE
	@Path("/{id}")
	public Response ExcluirOperador(@PathParam("id") Integer id) {
		
		gerenciamentoOperadoresBusiness.excluirOperador(id);
		return Response.status(200).header("Access-Control-Allow-Origin", "*").build();		
	}	
}