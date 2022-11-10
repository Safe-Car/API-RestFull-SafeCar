package teste;

import bo.UsuarioBO;
import dao.UsuarioDAO;
import to.ContatoTO;
import to.EnderecoTO;
import to.UsuarioTO;
import to.VeiculoTO;

public class teste {

	public static void main(String[] args) {
		
		UsuarioDAO udao = new UsuarioDAO();
		
		UsuarioTO uto = new UsuarioTO();
		uto.setId(3);
		
		
		System.out.println(udao.deleteUser(8));
		


		

		
	}
}


		


		
		
		
		
		
		
		


		

		
		
		

