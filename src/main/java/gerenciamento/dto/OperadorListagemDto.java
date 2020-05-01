package gerenciamento.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import gerenciamento.entity.Operador;

public class OperadorListagemDto {

	private Long id;
	private String nome;
	private String perfil;
	private String dataCadastro;
	
	public OperadorListagemDto(Operador operador) {
		this.id = operador.getId();
		this.nome = operador.getNome();
		this.perfil = this.formatarPerfil(operador.getPerfil());
		this.dataCadastro = this.formataData(operador.getDataCadastro());
	}
	
	private String formatarPerfil(Integer perfil) {
		switch(perfil){
	        case 1:
	            return "GERENTE";
	        case 2:
	        	return "ANALISTA";                
	        default:
	        	return "";
	    }
	}
	
	private String formataData(LocalDateTime data) {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(data);
	}
	
	public static List<OperadorListagemDto> converter(List<Operador> operador) {
		return operador.stream().map(OperadorListagemDto::new).collect(Collectors.toList());		
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getPerfil() {
		return perfil;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
}
