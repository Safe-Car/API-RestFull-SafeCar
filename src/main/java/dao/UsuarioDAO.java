package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import factory.ConnectionFactory;
import to.ChamadoTO;
import to.ContatoTO;
import to.EnderecoTO;
import to.UsuarioTO;
import to.VeiculoTO;

/**Classe de conexão do banco de dados SAafe Car
 * 
 * @author Jhonatas Oliveira
 * @version 1.0
 *
 */
public class UsuarioDAO {
	private ArrayList<UsuarioTO> listaUsers;
	private UsuarioTO usuario;
	private EnderecoTO endereco;
	private ContatoTO contato;
	
	private Connection con = null;

	public UsuarioDAO() {

		this.con = new ConnectionFactory().getConnection();

	}
	
	/** Metodo responsavel por validar o login do usuario no banco de dados
	 * 
	 * @param login
	 * @return objeto usuario
	 */
	
	public UsuarioTO loginDAO(UsuarioTO login) {
		PreparedStatement ps = null;
		try {
			String sql = "select * from t_sc_usuario where ds_login = ? and ds_senha = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, login.getLogin());
			ps.setString(2, login.getSenha());
			
			ResultSet rs = ps.executeQuery();
			UsuarioTO ut = null;
			
			while (rs.next()) {
				ut = new UsuarioTO();
				
				ut.setVeiculo(rs.getLong("id_veiculo"));
				ut.setNome(rs.getString("nm_usuario"));
				ut.setIdade(rs.getInt("ds_idade_usuario"));
				ut.setProfissao(rs.getString("ds_profissao_usuario"));
				ut.setSalario(rs.getDouble("ds_salario_usuario"));
				ut.setRaca(rs.getString("ds_raca_usuario"));
				ut.setGenero(rs.getString("ds_genero"));
				ut.setNacionalidade(rs.getString("ds_nacionalidade"));
				ut.setTpSanguineo(rs.getString("tp_sanguinio"));
				
				ut.setLogin(rs.getNString("ds_login"));
				ut.setSenha(null);
				
			}
			rs.close();
			ps.close();
			con.close();
			
			System.out.println("o usuario: " + ut.getLogin() + " logou !");
			return ut;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/** Metodo responsavel por exibir um usuario com base no seu login.
	 * 
	 * @param login
	 * @return arraylist do objeto usuario com todas suas informacoes.
	 */
	public ArrayList<UsuarioTO> getUserByLogin(String login) {
		String sql = "select * from t_sc_usuario where ds_login = ?";
		ArrayList<UsuarioTO> listaUsuarios = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login);
			ResultSet rs= ps.executeQuery();
			
			if (rs.next()) {
				usuario = new UsuarioTO();
				endereco = new EnderecoTO();
				usuario.setId(rs.getLong(1));
				usuario.setVeiculo(rs.getLong(2));
				usuario.setNome(rs.getString(3));
				usuario.setIdade(rs.getInt(4));
				usuario.setProfissao(rs.getString(5));
				usuario.setSalario(rs.getDouble(6));
				usuario.setRaca(rs.getString(7));
				usuario.setGenero(rs.getString(8));
				usuario.setNacionalidade(rs.getString(9));
				usuario.setTpSanguineo(rs.getString(10));
				usuario.setLogin(rs.getString(11));
				usuario.setSenha(rs.getString(12));
				listaUsuarios.add(usuario);
				return listaUsuarios;
			}
			con.close();
			ps.close();
			rs.close();
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	/** Metodo responsavel por exibir um usuario com base no seu id.
	 * 
	 * @param login
	 * @return arraylist do objeto usuario com todas suas informacoes.
	 */
	public ArrayList<UsuarioTO> getUserById(int id) {
		String sql = "select * from t_sc_usuario where id_usuario = ?";
		ArrayList<UsuarioTO> listaUsuarios = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			if (rs.next()) {
				usuario = new UsuarioTO();
				endereco = new EnderecoTO();
				usuario.setId(rs.getLong(1));
				usuario.setVeiculo(rs.getLong(2));
				usuario.setNome(rs.getString(3));
				usuario.setIdade(rs.getInt(4));
				usuario.setProfissao(rs.getString(5));
				usuario.setSalario(rs.getDouble(6));
				usuario.setRaca(rs.getString(7));
				usuario.setGenero(rs.getString(8));
				usuario.setNacionalidade(rs.getString(9));
				usuario.setTpSanguineo(rs.getString(10));
				usuario.setLogin(rs.getString(11));
				usuario.setSenha(rs.getString(12));
				listaUsuarios.add(usuario);
				return listaUsuarios;
			}
			con.close();
			ps.close();
			rs.close();
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/** Metodo responsavel por exibir um endereco com base no id do usuario.
	 * 
	 * @param login
	 * @return arraylist do objeto contato com todas suas informacoes.
	 */
	public List<EnderecoTO> getEndById(int id) {
		String sqlEnd = "SELECT * FROM T_SC_ENDERECO WHERE ID_USUARIO = ?";
		ArrayList<EnderecoTO> listaEnd = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sqlEnd);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			if (rs.next()) {
				endereco = new EnderecoTO();
				endereco.setId(rs.getLong(1));
				endereco.setIdUsuario(rs.getLong(2));
				endereco.setEstado(rs.getString(3));
				endereco.setCep(rs.getInt(4));
				endereco.setCidade(rs.getString(5));
				endereco.setLogradouro(rs.getString(6));
				endereco.setPais(rs.getString(7));
				endereco.setNumero(rs.getString(8));
				listaEnd.add(endereco);
				return listaEnd;
			}
			con.close();
			ps.close();
			rs.close();
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** Metodo responsavel por exibir um contato do usuario com base no id do usuario.
	 * 
	 * @param login
	 * @return arraylist do objeto contato com todas suas informacoes.
	 */
	public List<ContatoTO> getContatoById(int id) {
		String sql = "select * from t_sc_contato WHERE ID_USUARIO = ?";
		ArrayList<ContatoTO> listaContato = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			if (rs.next()) {
				contato.setDdd(rs.getInt(1));
				contato.setDdi(rs.getInt(2));
				contato.setTelefone(rs.getInt(3));
				contato.setEmail(rs.getString(4));
				contato.setContato(rs.getString(5));
				contato.setId(rs.getLong(6));
				//contato.setUsuario(rs.getString(11));
				listaContato.add(contato);	
				return listaContato;
			}
			con.close();
			ps.close();
			rs.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}		
	}
	/** Metodo responsavel por exibir todos os usuarios cadastrados.
	 * 
	 * @param login
	 * @return arraylist do objeto usuario com todas suas informacoes.
	 */

	public ArrayList<UsuarioTO> getAllUsers() {
		
		PreparedStatement ps = null;
		listaUsers = new ArrayList<UsuarioTO>();
		String sql = "SELECT * FROM T_SC_USUARIO";

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					usuario = new UsuarioTO();
					usuario.setId(rs.getLong(1));
					usuario.setNome(rs.getString(3));
					usuario.setIdade(rs.getInt(4));
					usuario.setProfissao(rs.getString(5));
					usuario.setSalario(rs.getDouble(6));
					usuario.setRaca(rs.getString(7));
					usuario.setGenero(rs.getString(8));
					usuario.setNacionalidade(rs.getString(9));
					usuario.setTpSanguineo(rs.getString(10));
					usuario.setLogin(rs.getString(11));
					usuario.setSenha(rs.getString(12));
					listaUsers.add(usuario);
			}

			}
			con.close();
			ps.close();
			rs.close();
			return listaUsers;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/** Metodo responsavel por inserir um usuario no sistema..
	 * 
	 * @param login
	 * @return String validando se foi bem sucedido ou nao.
	 */

	public String insert(UsuarioTO user) {
		PreparedStatement ps = null;

		String sqlUser = "insert into t_sc_usuario (id_usuario," + "id_veiculo," + "nm_usuario," + "ds_idade_usuario,"
				+ "ds_profissao_usuario," + "ds_salario_usuario," + "ds_raca_usuario," + "ds_genero,"
				+ "ds_nacionalidade," + "tp_sanguinio," + "ds_login,"
				+ "ds_senha) values (sq_sc_usuario_sequence.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// User insert
			ps = con.prepareStatement(sqlUser);
			ps.setLong(1, user.getVeiculo());
			ps.setString(2, user.getNome());
			ps.setInt(3, user.getIdade());
			ps.setString(4, user.getProfissao());
			ps.setDouble(5, user.getSalario());
			ps.setString(6, user.getRaca());
			ps.setString(7, user.getGenero());
			ps.setString(8, user.getNacionalidade());
			ps.setString(9, user.getTpSanguineo());
			ps.setString(10, user.getLogin());
			ps.setString(11, user.getSenha());
			
			return "ok";
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/** Metodo responsavel por atualizar um usuario no sistema..
	 * 
	 * @param login
	 * @return String validando se foi bem sucedido ou nao.
	 */


	public String update(UsuarioTO user) {
		PreparedStatement ps = null;
		String sql = "update t_sc_usuario set " + " nm_usuario = ?," + "ds_idade_usuario = ?,"
				+ "ds_profissao_usuario = ?," + "ds_salario_usuario = ?," + "ds_raca_usuario = ?," + "ds_genero = ?,"
				+ "ds_nacionalidade = ?," + "tp_sanguinio = ?," + "ds_login = ?," + "ds_senha = ? "
				+ "where id_usuario = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setInt(2, user.getIdade());
			ps.setString(3, user.getProfissao());
			ps.setDouble(4, user.getSalario());
			ps.setString(5, user.getRaca());
			ps.setString(6, user.getGenero());
			ps.setString(7, user.getNacionalidade());
			ps.setString(8, user.getTpSanguineo());
			ps.setString(9, user.getLogin());
			ps.setString(10, user.getSenha());
			ps.setLong(11, user.getId());

			
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";

			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/** Metodo responsavel por deletar um usuario no sistema..
	 * 
	 * @param login
	 * @return String validando se foi bem sucedido ou nao.
	 */

	public String deleteUser(long id) {

		String sqlEnd = "delete t_sc_endereco where id_usuario = ?";
		String sqlCon = "delete t_sc_contato where id_usuario = ?";
		String sqlPlan = "delete from t_sc_plano_saude where id_usuario = ?";
		String sql = "delete  t_sc_usuario where id_usuario = ?";

		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps = null;

		try {
			ps1 = con.prepareStatement(sqlEnd);
			ps1.setLong(1, id);
			
			ps2 = con.prepareStatement(sqlCon);
			ps2.setLong(1, id);
			
			ps3 = con.prepareStatement(sqlPlan);
			ps3.setLong(1, id);
		
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			
			ps2.executeUpdate();
			ps3.executeUpdate();
			ps1.executeUpdate();
			ps.executeUpdate();
			
			con.close();
			ps.close();
			ps2.close();
			ps3.close();
			return "ok";



		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	


}
