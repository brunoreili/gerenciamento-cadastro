package gerenciamento.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gerenciamento.business.GerenciamentoOperadoresBusiness;
import gerenciamento.entity.Operador;

@Path("/operadores")
public class GerenciamentoOperadoresResource {
	
	@Inject
	private GerenciamentoOperadoresBusiness gerenciamentoOperadoresBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarOperadores() {
		
		List<Operador> operadores = gerenciamentoOperadoresBusiness.listarOperadores();
		return Response.ok(operadores).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SalvarOperador(Operador operador) {
		
		gerenciamentoOperadoresBusiness.salvarOperador(operador);
		return Response.status(201).build();
		
	}

}
