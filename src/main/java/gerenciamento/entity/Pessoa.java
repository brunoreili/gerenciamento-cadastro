package gerenciamento.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import gerenciamento.form.PessoaForm;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Nome não pode estar vazio!")
	private String nome;
	
	@NotBlank(message="Documento não pode estar vazio!")
	private String documento;
	
	private String nomeMae;
	
	private String nomePai;
	
	@NotBlank(message="Login do Operador não pode estar vazio!")
	private String loginOperador;
	
	@NotNull(message="Tipo de pessoa não pode estar vazio!")
	private Integer tipoPessoa;
	
	@NotNull(message="Data de nascimento não pode estar vazia!")
	private LocalDateTime dataNascimento;
	
	@NotNull(message="Data do cadastro não pode estar vazia!")
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Telefone> telefones;
	
	public Pessoa() {
		
	}

	public Pessoa(PessoaForm pessoaForm) {
		this.id = pessoaForm.getId();
		this.nome = pessoaForm.getNome();		
		this.documento = pessoaForm.getDocumento();
		this.nomeMae = pessoaForm.getNomeMae();
		this.nomePai = pessoaForm.getNomePai();		
		this.loginOperador = pessoaForm.getLoginOperador();		
		this.tipoPessoa = pessoaForm.getTipoPessoa();		
		this.dataNascimento = LocalDateTime.parse(pessoaForm.getDataNascimento(),DateTimeFormatter.ISO_DATE_TIME);		
//		this.dataCadastro = LocalDateTime.now();		
//		this.telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getLoginOperador() {
		return loginOperador;
	}

	public void setLoginOperador(String loginOperador) {
		this.loginOperador = loginOperador;
	}
	
	public Integer getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(Integer tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Telefone> getTelefone() {
		return telefones;
	}

	public void setTelefone(List<Telefone> telefones) {
		this.telefones = telefones;
	}	
}
