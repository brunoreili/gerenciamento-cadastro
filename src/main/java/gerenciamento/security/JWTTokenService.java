package gerenciamento.security;

import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;

import gerenciamento.entity.Operador;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Stateless
public class JWTTokenService {
	
	

	public String gerarToken(@Valid Operador operador) {
		
		Date hoje = new Date();
		SignatureAlgorithm algoritimoAssinatura = SignatureAlgorithm.HS512;
		
		Date dataExpiracao = JWTUtilitarios.gerarDataExpiracao();
		SecretKeySpec chave = JWTUtilitarios.gerarChaveCriptografada();
		
		return Jwts.builder()
				.setIssuer("API do Gerenciamento de Cadastro de Pessoas - Avaliação Mirante")
				.setSubject(operador.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(algoritimoAssinatura, chave)
				.compact();
	}

	public boolean isTokenValido(String token) {		
		try {
			String chaveRandomica = JWTUtilitarios.gerarChaveRandomica(100);
			byte[] chave = DatatypeConverter.parseBase64Binary(chaveRandomica);
			
			@SuppressWarnings("unused")
			Claims claims = Jwts.parser().setSigningKey(chave.toString()).parseClaimsJws(token).getBody();
			return true;
		} catch (Exception e) {
			return false;
		}	
	}

}
