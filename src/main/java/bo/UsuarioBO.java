package bo;

import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import to.ContatoTO;
import to.EnderecoTO;
import to.UsuarioTO;

public class UsuarioBO {
	
	private UsuarioDAO userDAO;
	
	public UsuarioTO login(UsuarioTO user) {
		userDAO = new UsuarioDAO();
		return userDAO.loginDAO(user);
		
	}
	
	public ArrayList<UsuarioTO> listarTodos() {
		userDAO = new UsuarioDAO();
		return userDAO.getAllUsers();
		
	}
	public List<UsuarioTO> listarUmUser(int id) {
		userDAO = new UsuarioDAO();
		return userDAO.getUserById(id);
		
	}
	
	public List<UsuarioTO> listarUmUserLogin(String login) {
		userDAO = new UsuarioDAO();
		return userDAO.getUserByLogin(login);
		
	}
	
	public List<EnderecoTO> listarUmEnd(int id) {
		userDAO = new UsuarioDAO();
		return userDAO.getEndById(id);
		
	}
	
	public List<ContatoTO> listarUmCont(int id) {
		userDAO = new UsuarioDAO();
		return userDAO.getContatoById(id);
		
	}
	
	public String cadastrar(UsuarioTO user) {
		userDAO = new UsuarioDAO();
		return userDAO.insert(user);
	}
	
	public String alterar(UsuarioTO user) {
		userDAO = new UsuarioDAO();
		return userDAO.update(user);
		
	}
	public String delete(int id) {
		userDAO = new UsuarioDAO();
		return userDAO.deleteUser(id);
	}

	
	
	

	

}
