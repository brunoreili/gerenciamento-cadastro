package gerenciamento.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import gerenciamento.entity.Telefone;

public class TelefoneListagemDto {
	
	private Long id;
	private String loginOperador;
	private Integer ddd;
	private Integer numero;
	private String tipo;
	private String dataCadastro;
	
	public TelefoneListagemDto(Telefone telefone) {
		this.id = telefone.getId();
		this.loginOperador = telefone.getLoginOperador();
		this.ddd = telefone.getDdd();
		this.numero = telefone.getNumero();
		this.tipo = this.formatarTipo(telefone.getTipo());
		this.dataCadastro = this.formataData(telefone.getDataCadastro());
	}
	
	private String formatarTipo(Integer tipo) {
		switch(tipo){
	        case 1:
	            return "CELULAR";
	        case 2:
	        	return "FIXO";
	        case 3:
	        	return "COMERCIAL"; 
	        default:
	        	return "";
	    }
	}
	
	private String formataData(LocalDateTime data) {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(data);
	}

	public static List<TelefoneListagemDto> converter(List<Telefone> telefones) {
		return telefones.stream().map(TelefoneListagemDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getLoginOperador() {
		return loginOperador;
	}

	public Integer getDdd() {
		return ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

}
