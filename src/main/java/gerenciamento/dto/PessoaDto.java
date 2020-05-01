package gerenciamento.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import gerenciamento.entity.Pessoa;

public class PessoaDto {	

	private Long id;
	private String nome;
	private String documento;	
	private String nomeMae;	
	private String nomePai;
	private String loginOperador;
	private Integer tipoPessoa;
	private String dataNascimento;
	private List<TelefoneListagemDto> telefones;
	

	public PessoaDto(Pessoa pessoa, List<TelefoneListagemDto> telefones) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.documento = pessoa.getDocumento();	
		this.nomeMae = pessoa.getNomeMae();	
		this.nomePai = pessoa.getNomePai();
		this.loginOperador = pessoa.getLoginOperador();
		this.tipoPessoa = pessoa.getTipoPessoa();
		this.dataNascimento = formataData(pessoa.getDataNascimento());
		this.telefones = telefones;
	}

	public static PessoaDto converter(Pessoa pessoa, List<TelefoneListagemDto> telefones) {
		return new PessoaDto(pessoa, telefones);
	}
	
	private String formataData(LocalDateTime data) {
		return DateTimeFormatter.ofPattern("MM/dd/yyyy").format(data);
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

	public List<TelefoneListagemDto> getTelefones() {
		return telefones;
	}
}
