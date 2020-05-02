package gerenciamento.security;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtilitarios {

	public static Date gerarDataExpiracao() {

		Calendar dataExpiracao = Calendar.getInstance();
		dataExpiracao.add(Calendar.HOUR_OF_DAY, 1);

		return dataExpiracao.getTime();
	}

	public static SecretKeySpec gerarChaveCriptografada() {

		String chaveRandomica = gerarChaveRandomica(100);
		byte[] chaveEmBytes = DatatypeConverter.parseBase64Binary(chaveRandomica);
		SignatureAlgorithm algoritimoAssinatura = SignatureAlgorithm.HS512;

		SecretKeySpec chave = new SecretKeySpec(chaveEmBytes, algoritimoAssinatura.getJcaName());
		return chave;
	}

	static String gerarChaveRandomica(int comprimento) {
		char[] cenario = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z' };
		char[] senha = new char[comprimento];
		
		int comprimentoDoCenario = cenario.length;
		Random randomico = new Random();

		for (int indice = 0; indice < comprimento; indice++) {
			senha[indice] = cenario[randomico.nextInt(comprimentoDoCenario)];	
		}
		
		System.out.println(new String(senha));
		//A ideia é guardar a chave dandomica numa sessão ou algo do tipo, para efeito de teste foi gerada uma chave fixa.
		return new String("zxrW2UPG0sZRp5YLeX2jMAYIOAQ0wnfZfJcBFmdpb2sVuYEacshbbNTCtiAXnhFJufP4soRYLPm96sFld2HCj9u3Z3K3F54D2I18");
	}
}
