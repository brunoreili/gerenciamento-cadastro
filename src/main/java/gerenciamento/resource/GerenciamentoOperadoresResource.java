package gerenciamento.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gerenciamento.business.GerenciamentoOperadoresBusiness;

@Path("/operadores")
public class GerenciamentoOperadoresResource {
	
	@Inject
	private GerenciamentoOperadoresBusiness gerenciamentoOperadoresBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarOperadores() {
		
		List<String> operadores = gerenciamentoOperadoresBusiness.listarOperadores();
		return Response.ok(operadores).build();
	}

}
