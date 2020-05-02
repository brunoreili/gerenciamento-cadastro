package gerenciamento.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/resources/*")
public class AutenticacaoTokenFilter implements Filter{

	JWTTokenService jwtTokenService = new JWTTokenService();
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		System.out.println(request.getRequestURI());
		if(!request.getRequestURI().equals("/resources/autenticacao")) {
			String token = recuperarToken((HttpServletRequest) request);
			boolean valido = this.jwtTokenService.isTokenValido(token);
			System.out.println(valido);
			
			if(token == null) {
//				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
		
		chain.doFilter(request, response);		
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {		
			return null;
		}		
		return token;
	}

}
