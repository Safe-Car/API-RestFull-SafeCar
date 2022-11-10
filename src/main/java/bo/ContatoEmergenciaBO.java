package bo;

import dao.ContatoEmergenciaDAO;
import to.ContatoEmergenciaTO;

public class ContatoEmergenciaBO {
	
	private ContatoEmergenciaDAO contato;
	
	public String cadastrar(ContatoEmergenciaTO cto) {
		contato = new ContatoEmergenciaDAO();
		return contato.insertContatoEmergencia(cto);
	}
	
	public String alterar(ContatoEmergenciaTO cto) {
		contato = new ContatoEmergenciaDAO();
		return contato.updateContatoEmergencia(cto);
		
	}
	public String delete(int id) {
		contato = new ContatoEmergenciaDAO();
		return contato.deleteContatoEmergencia(id);
	}


}
