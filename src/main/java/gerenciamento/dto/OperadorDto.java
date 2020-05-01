package gerenciamento.dto;

import java.util.List;
import java.util.stream.Collectors;

import gerenciamento.entity.Operador;

public class OperadorDto {

	private Long id;
	private String nome;
	private String login;
	private String senha;
	private String confirmarSenha;
	private Integer perfil;
	
	public OperadorDto(Operador operador) {
		this.id = operador.getId();
		this.nome = operador.getNome();
		this.login = operador.getLogin();
		this.senha = operador.getSenha();
		this.confirmarSenha = operador.getSenha();
		this.perfil = operador.getPerfil();
	}
	
	public static OperadorDto converter(Operador operador) {
		return new OperadorDto(operador);	
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public Integer getPerfil() {
		return perfil;
	}
}
