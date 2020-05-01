package gerenciamento.form;

import gerenciamento.entity.Pessoa;

public class PessoaForm {

	private Long id;
	private String nome;
	private String documento;
	private String nomeMae;
	private String nomePai;
	private String loginOperador;
	private Integer tipoPessoa;
	private String dataNascimento;
	
	public static Pessoa converter(PessoaForm pessoaForm) {
		return new Pessoa(pessoaForm);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public String getLoginOperador() {
		return loginOperador;
	}

	public Integer getTipoPessoa() {
		return tipoPessoa;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
}
