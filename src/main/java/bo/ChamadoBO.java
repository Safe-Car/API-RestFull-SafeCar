package bo;

import dao.ChamadoDAO;
import to.ChamadoTO;

public class ChamadoBO {
	
	private ChamadoDAO chamado;
	
	public String cadastrar(ChamadoTO cto) {
		chamado = new ChamadoDAO();
		return chamado.insert(cto);
	}
	
	public String alterar(ChamadoTO cto) {
		chamado = new ChamadoDAO();
		return chamado.update(cto);
		
	}
	public String delete(int id) {
		chamado = new ChamadoDAO();
		return chamado.delete(id);
	}

}
