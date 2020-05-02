package gerenciamento.security;

import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.validation.Valid;

import gerenciamento.entity.Operador;
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

}
