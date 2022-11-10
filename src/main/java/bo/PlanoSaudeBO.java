package bo;

import java.util.ArrayList;

import dao.PlanoSaudeDAO;
import to.PlanoSaudeTO;
import to.UnidadeHospitalarTO;

public class PlanoSaudeBO {
	
	private PlanoSaudeDAO pdao;
	
	public ArrayList<PlanoSaudeTO> exibirPlano() {
		pdao = new PlanoSaudeDAO();
		return pdao.getPlano();
		
	}
	
	public ArrayList<PlanoSaudeTO> exibirPlanos() {
		pdao = new PlanoSaudeDAO();
		return pdao.getAll();
		
	}
	
	public ArrayList<PlanoSaudeTO> exibirUmPlano(int id) {
		pdao = new PlanoSaudeDAO();
		return pdao.getPlanById(id);
		
	}
	
	public ArrayList<UnidadeHospitalarTO> exibirUmUnidade(int id) {
		pdao = new PlanoSaudeDAO();
		return pdao.getUndById(id);
		
	}
	
	public String cadastrar(PlanoSaudeTO plano) {
		pdao = new PlanoSaudeDAO();
		return pdao.insertPlano(plano);
	}
	
	public String alterar(PlanoSaudeTO plano) {
		pdao = new PlanoSaudeDAO();
		return pdao.updatePlano(plano);
		
	}
	public String delete(int id) {
		pdao = new PlanoSaudeDAO();
		return pdao.deletePlano(id);
	}

}
