package gerenciamento.security;

import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.validation.Valid;

import gerenciamento.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Stateless
public class JWTTokenService {

	public String gerarToken(@Valid Usuario usuario) {
		
		Date hoje = new Date();
		SignatureAlgorithm algoritimoAssinatura = SignatureAlgorithm.HS512;
		
		Date dataExpiracao = JWTUtilitarios.gerarDataExpiracao();
		SecretKeySpec chave = JWTUtilitarios.gerarChaveCriptografada();		
		
		return Jwts.builder()
				.setIssuer("API do Gerenciamento de Cadastro de Pessoas - Avaliação Mirante")
				.setSubject(usuario.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(algoritimoAssinatura, chave)
				.compact();
	}

}
