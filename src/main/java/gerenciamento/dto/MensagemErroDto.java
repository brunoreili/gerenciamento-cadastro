package gerenciamento.dto;

import java.util.Date;
import java.util.List;

public class MensagemErroDto {

	private List<String> mensagens;
	private Date dataErro;
	
	public static MensagemErroDto build(List<String> mensagem) {
		MensagemErroDto mensagemErroDto = new MensagemErroDto();
		mensagemErroDto.setMensagens(mensagem);
		mensagemErroDto.setDataErro(new Date());
		
		return mensagemErroDto;
	}
	
	public List<String> getMensagens() {
		return mensagens;
	}
	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}
	public Date getDataErro() {
		return dataErro;
	}
	public void setDataErro(Date dataErro) {
		this.dataErro = dataErro;
	}
}
