package gerenciamento.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class GerenciamentoOperadoresBusiness {
	
	public List<String> listarOperadores() {
		
		List<String> listaOperadores = new ArrayList<>();
		listaOperadores.add("Operador_01");
		listaOperadores.add("Operador_02");
		
		return listaOperadores;
	}

}
