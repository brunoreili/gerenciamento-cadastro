package gerenciamento.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import gerenciamento.business.GerenciamentoOperadoresBusiness;
import gerenciamento.dto.OperadorLoginDto;
import gerenciamento.dto.TokenDto;
import gerenciamento.entity.Operador;
import gerenciamento.security.JWTTokenService;

@Path("/autenticacao")
public class GerenciamentoAutenticacaoResource {

	@Inject
	private GerenciamentoOperadoresBusiness gerenciamentoOperadoresBusiness;

	@Inject
	private JWTTokenService gerenciamentoTokenBusiness;	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response autenticar(OperadorLoginDto operadorLoginDto) {		
		
		Operador operador = gerenciamentoOperadoresBusiness.buscarOperador(operadorLoginDto);
		if(operador.getId() == null) {	
			return Response.status(Status.UNAUTHORIZED).header("Access-Control-Allow-Origin", "*").build();
		}

		String token = gerenciamentoTokenBusiness.gerarToken(operador);
		return Response.ok(new TokenDto(token, "Bearer")).header("Access-Control-Allow-Origin", "*").build();	

	}
	
}
