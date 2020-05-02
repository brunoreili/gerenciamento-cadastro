package gerenciamento.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import gerenciamento.business.GerenciamentoAutenticacaoBusiness;
import gerenciamento.dto.TokenDto;
import gerenciamento.entity.Usuario;
import gerenciamento.form.UsuarioForm;
import gerenciamento.security.JWTTokenService;

@Path("/auth")
public class GerenciamentoAutenticacaoResource {

	@Inject
	private GerenciamentoAutenticacaoBusiness gerenciamentoAutenticacaoBusiness;

	@Inject
	private JWTTokenService gerenciamentoTokenBusiness;	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response autenticar(UsuarioForm usuarioForm) {		
		
		Usuario usuario = gerenciamentoAutenticacaoBusiness.buscarUsuario(usuarioForm);
		if(usuario.getId() == null) {	
			return Response.status(Status.UNAUTHORIZED).header("Access-Control-Allow-Origin", "*").build();
		}

		String token = gerenciamentoTokenBusiness.gerarToken(usuario);
		return Response.ok(new TokenDto(token, "Bearer")).header("Access-Control-Allow-Origin", "*").build();	

	}
	
}
