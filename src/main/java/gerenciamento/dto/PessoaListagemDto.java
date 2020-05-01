package gerenciamento.dto;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.MaskFormatter;

import gerenciamento.entity.Pessoa;

public class PessoaListagemDto {

	private Long id;
	private String nome;
	private String loginOperador;
	private String documento;
	private String tipoPessoa;
	private String dataNascimento;
	private String dataCadastro;
	
	PessoaListagemDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.loginOperador = pessoa.getLoginOperador();
		this.documento = this.formatarDocumento(pessoa.getDocumento(), pessoa.getTipoPessoa());		
		this.tipoPessoa = this.formatarTipoPessoa(pessoa.getTipoPessoa());
		this.dataNascimento = this.formatarData(pessoa.getDataNascimento());
		this.dataCadastro = this.formatarData(pessoa.getDataCadastro());
	}
	
	public String formatarDocumento(String documento, Integer tipoPessoa) {
		try {
			MaskFormatter mask;
			String cpfMask = "###.###.###-##";
			String cnpjMask = "###.###.###/####-##";
			
			mask = tipoPessoa == 1 ? new MaskFormatter(cpfMask) : new MaskFormatter(cnpjMask);
			mask.setValueContainsLiteralCharacters(false);

			return mask.valueToString(documento);
		} catch (ParseException e) {
			e.printStackTrace();
			return documento;
		}
	}
	
	public String formatarTipoPessoa(Integer tipoPessoa) {
		switch(tipoPessoa){
            case 1:
                return "FÍSICA";
            case 2:
            	return "JURÍDICA";                
            default:
            	return "";
        }
    }
	
	public String formatarData(LocalDateTime data) {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(data);
	}	

	public static List<PessoaListagemDto> converter(List<Pessoa> pessoas) {
		return pessoas.stream().map(PessoaListagemDto::new).collect(Collectors.toList());		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}	
	
	public String getLoginOperador() {
		return loginOperador;
	}
	
	public String getDocumento() {
		return documento;
	}
	
	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}	
}
