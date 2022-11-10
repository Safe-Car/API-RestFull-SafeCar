package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.loader.ParallelWebappClassLoader;

import factory.ConnectionFactory;
import to.EnderecoTO;
import to.PlanoSaudeTO;
import to.UnidadeHospitalarTO;
import to.UsuarioTO;
/**Classe de conexão do banco de dados SAafe Car
 * 
 * @author Jhonatas Oliveira
 * @version 1.0
 *
 */
public class PlanoSaudeDAO {

	private Connection con;
	private PlanoSaudeTO plano = null;
	private UnidadeHospitalarTO uto = null;

	public PlanoSaudeDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	
	/** Metodo responsavel por exibir plano de saude 
	 * 
	 * 
	 * @return objeto arraylist plano de saude
	 */
	
	public ArrayList<PlanoSaudeTO> getPlano() {
		ArrayList<PlanoSaudeTO> listaPlanos = new ArrayList<>();
		String sql = "select * from t_sc_plano_saude";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if (rs != null) {
				
		
			while (rs.next()) {
			plano = new PlanoSaudeTO();
			plano.setId(rs.getLong("id_plano_saude"));
			plano.setUsuario(rs.getLong("id_usuario"));
			plano.setEmpresa(rs.getString("ds_empresa_plano_saude"));
			plano.setNome(rs.getString("nm_plano_saude"));
			plano.setTipo(rs.getString("tp_plano_saude"));
			plano.setDescricao(rs.getString("ds_descricao_plano"));
			listaPlanos.add(plano);

			}
			
			}
			con.close();
			ps.close();
			rs.close();
			return listaPlanos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

		
	}
	
	/** Metodo responsavel por exibir plano de saude e und hospitalar
	 * 
	 * 
	 * @return objeto arraylist plano de saude
	 */ 
	
	public ArrayList<PlanoSaudeTO> getAll() {
		ArrayList<PlanoSaudeTO> listaPlanos = new ArrayList<>();
		String sql = "select p.id_plano_saude,"
				+ "p.ds_empresa_plano_saude,"
				+ "p.nm_plano_saude,"
				+ "p.tp_plano_saude,"
				+ "u.nm_und_hospitalar,"
				+ "u.ds_endereco_unidade,"
				+ "u.ds_cidade"
				+ " from t_sc_plano_saude p right join t_sc_und_hospitalar u "
				+ "on (u.id_plano_saude = p.id_plano_saude) "
				+ " order by p.id_plano_saude";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
		
			while (rs.next()) {
				plano = new PlanoSaudeTO();
				plano.setId(rs.getLong("id_plano_saude"));
				plano.setEmpresa(rs.getString("ds_empresa_plano_saude"));
				plano.setNome(rs.getString("nm_plano_saude"));
				plano.setTipo(rs.getString("tp_plano_saude"));
				plano.setUnidade(rs.getString("nm_und_hospitalar"));
				plano.setEndereco(rs.getString("ds_endereco_unidade"));
				plano.setCidade(rs.getString("ds_cidade"));
				listaPlanos.add(plano);
	
			}
			con.close();
			ps.close();
			rs.close();
			return listaPlanos;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/** Metodo responsavel por exibir plano de saude com base no id
	 * 
	 * @param int id
	 * @return objeto arraylist plano de saude
	 */ 
	
	public ArrayList<PlanoSaudeTO> getPlanById(int id) {
		String sql = "select * from t_sc_plano_saude where id_plano_saude = ?";
		ArrayList<PlanoSaudeTO> listaPlano= new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			if (rs.next()) {
				plano = new PlanoSaudeTO();
				plano.setId(rs.getLong(1));
				plano.setEmpresa(rs.getString(1));
				plano.setNome(rs.getString(3));
				plano.setTipo(rs.getString(4));
				plano.setDescricao(rs.getString(5));
				listaPlano.add(plano);
				return listaPlano;
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
	
	/** Metodo responsavel por exibir plano de saude com base no id
	 * 
	 * @param int id
	 * @return objeto arraylist plano de saude
	 */ 
	
	public ArrayList<UnidadeHospitalarTO> getUndById(int id) {
		String sql = "select * from t_sc_und_hospitalar where id_plano_saude = ?";
		ArrayList<UnidadeHospitalarTO> listaUnd= new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			if (rs.next()) {
				uto = new UnidadeHospitalarTO();
				uto.setId(rs.getLong(1));
				uto.setUnidade(rs.getString(1));
				uto.setEndereco(rs.getString(3));
				uto.setCep(rs.getInt(4));
				uto.setCidade(rs.getString(5));
				uto.setLogradouro(rs.getString(6));
				uto.setNumero(rs.getString(7));
				uto.setEstado(rs.getString(8));
				listaUnd.add(uto);
				return listaUnd;
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
	
	/** Metodo responsavel por inserir plano de saude
	 * 
	 * @param planoSaudeTO
	 * @return STRING de validacao
	 */ 
	public String insertPlano(PlanoSaudeTO pse) {
		String sql = "insert into t_sc_plano_saude (id_plano_saude,"
				+ "id_usuario,"
				+ "ds_empresa_plano_saude,"
				+ "nm_plano_saude,"
				+ "tp_plano_saude,"
				+ "ds_descricao_plano) values(sq_sc_plano_saude.nextval, ?,?,?,?,?)";
		
		
		PreparedStatement ps = null;
		try {
			//plan saude
			ps = con.prepareStatement(sql);
			ps.setString(2, pse.getEmpresa());
			ps.setString(3, pse.getNome());
			ps.setString(4, pse.getTipo());
			ps.setString(5, pse.getDescricao());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";

			} else {
				return "erro ao inserir!";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

	}
	
	/** Metodo responsavel por atualizar plano de saude
	 * 
	 * @param planoSaudeTO
	 * @return String de validacao
	 */ 

	public String updatePlano(PlanoSaudeTO pse) {
		String sql = "update t_sc_plano_saude set "
				+ "id_usuario =?,"
				+ "ds_empresa_plano_saude =?,"
				+ "nm_plano_saude =?,"
				+ "tp_plano_saude =?,"
				+ "ds_descricao_plano =? where id_plano_saude = ?";
		
		String sqlPlan = "update t_sc_und_hospitalar set "
				+ "id_plano_saude =?,"
				+ "nm_und_hospitalar=?,"
				+ "ds_endereco_unidade=?,"
				+ "ds_cep_unidade=?,"
				+ "ds_cidade=?,"
				+ "ds_logradouro=?,"
				+ "ds_numero=?,"
				+ "ds_estado=? where id_und_hospitalar = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			
			//plano saude
			ps.setString(2, pse.getEmpresa());
			ps.setString(3, pse.getNome());
			ps.setString(4, pse.getTipo());
			ps.setString(5, pse.getDescricao());
			ps.setLong(6, pse.getId());
			
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";

			} else {
				return "erro ao inserir!";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

	}
	
	/** Metodo responsavel por deletar plano de saude e  unidade hospitalar
	 * 
	 * @param String
	 * @return id
	 */ 

	public String deletePlano(int id) {
		String sql = "delete t_sc_plano_saude where id_planp_saude = ? ";
		String sqlPlan = "delete t_sc_und_hospitalar where id_und_hospitalar = ?";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			
			
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";

			} else {
				return "erro ao inserir!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}

}
