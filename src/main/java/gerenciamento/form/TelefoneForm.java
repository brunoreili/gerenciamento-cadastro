package gerenciamento.form;

import gerenciamento.entity.Pessoa;
import gerenciamento.entity.Telefone;

public class TelefoneForm {

	private Long id;
	private String loginOperador;
	private String ddd;
	private Integer numero;
	private Integer tipo;
	private Integer pessoaId;

	public static Telefone converter(TelefoneForm telefoneForm, Pessoa pessoa) {
		return new Telefone(telefoneForm, pessoa);
	}

	public Long getId() {
		return id;
	}

	public String getLoginOperador() {
		return loginOperador;
	}

	public String getDdd() {
		return ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public Integer getTipo() {
		return tipo;
	}

	public Integer getPessoaId() {
		return pessoaId;
	}
}
