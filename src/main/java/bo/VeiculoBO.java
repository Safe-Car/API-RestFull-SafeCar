package bo;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import dao.VeiculoDAO;
import to.VeiculoTO;

public class VeiculoBO {
	
	private VeiculoDAO veiculo;
	

	
	public ArrayList<VeiculoTO> listarPelaPlaca(String placa) {
		veiculo = new VeiculoDAO();
		return veiculo.getByPlaca(placa);
	}
	
	public ArrayList<VeiculoTO> listarTodos() {
		veiculo = new VeiculoDAO();
		return veiculo.getAllVehicle();
	}
	
	public String cadastrar(VeiculoTO cto) {
		veiculo = new VeiculoDAO();
		return veiculo.insertVehicle(cto);
	}
	
	public String alterar(VeiculoTO cto) {
		veiculo = new VeiculoDAO();
		return veiculo.updateVehicle(cto);
		
	}
	public String delete(int id) {
		veiculo = new VeiculoDAO();
		return veiculo.deleteVehicle(id);
	}

}
