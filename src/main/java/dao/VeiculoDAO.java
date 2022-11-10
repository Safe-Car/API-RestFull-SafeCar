package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.VeiculoTO;

/**Classe de conexão do banco de dados SAafe Car
 * 
 * @author Jhonatas Oliveira
 * @version 1.0
 *
 */
public class VeiculoDAO {
	
	private Connection con ;
	private ArrayList<VeiculoTO> listaVeiculos;
	private VeiculoTO veiculo;
	
	public VeiculoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	
	/** Metodo responsavel por exibir os atributos do veiculo com base na placa
	 * 
	 * @param login
	 * @return objeto veiculoTO
	 */
	
	public ArrayList<VeiculoTO> getByPlaca(String placa) {
		PreparedStatement ps = null;
		String sql = "select * from t_sc_veiculo where ds_placa = ?";
		listaVeiculos = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, placa);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				veiculo = new VeiculoTO();
				veiculo.setId(rs.getLong(1));
				veiculo.setNmVeiculo(rs.getString(2));
				veiculo.setTipo(rs.getString(3));
				veiculo.setCor(rs.getString(4));
				veiculo.setPlaca(rs.getString(5));
				veiculo.setModelo(rs.getString(6));
				veiculo.setDsVeiculo(rs.getString(7));
				veiculo.setTripulantes(rs.getInt(8));
				listaVeiculos.add(veiculo);
			}
			con.close();
			rs.close();
			ps.close();
			return listaVeiculos;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
				
	}
	
	/** Metodo responsavel por exibir todos os veiculos
	 * 
	 * @param login
	 * @return objeto arraylist de veiculoTO
	 */
	
	@SuppressWarnings("unchecked")
	public ArrayList<VeiculoTO> getAllVehicle() {
		PreparedStatement ps = null;
		listaVeiculos = new ArrayList();
		String sql = "select * from t_sc_veiculo";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				veiculo = new VeiculoTO();
				veiculo.setId(rs.getLong(1));
				veiculo.setNmVeiculo(rs.getString(2));
				veiculo.setTipo(rs.getString(3));
				veiculo.setCor(rs.getString(4));
				veiculo.setPlaca(rs.getString(5));
				veiculo.setModelo(rs.getString(6));
				veiculo.setDsVeiculo(rs.getString(7));
				veiculo.setTripulantes(rs.getInt(8));
				
				listaVeiculos.add(veiculo);
				
			}
			con.close();
			rs.close();
			ps.close();
			return listaVeiculos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** Metodo responsavel por inserir veiculos e usuario simultaneamente
	 * 
	 * @param login
	 * @return String de resposta sucedida
	 */
	
	public String insertVehicle(VeiculoTO veiculo) {
		String sql = "insert into t_sc_veiculo (id_veiculo,"
				+ "nm_carro,"
				+ "tp_veiculo,"
				+ "ds_cor_veiculo,"
				+ "ds_placa,"
				+ "ds_modelo_veiculo,"
				+ "ds_veiculo,"
				+ "qt_tripulantes)"
				+ " values(SQ_SC_VEICULO_SEQUENCE.NEXTVAL,?,?,?,?,?,?,?)";
		
		String sqlUser = "insert into t_sc_usuario (id_usuario," + "id_veiculo," + "nm_usuario," + "ds_idade_usuario,"
				+ "ds_profissao_usuario," + "ds_salario_usuario," + "ds_raca_usuario," + "ds_genero,"
				+ "ds_nacionalidade," + "tp_sanguinio," + "ds_login,"
				+ "ds_senha) values (sq_sc_usuario_sequence.NEXTVAL,sq_sc_veiculo_sequence.CURRVAL,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, veiculo.getNmVeiculo());;
			ps.setString(2, veiculo.getTipo());;
			ps.setString(3, veiculo.getCor());;
			ps.setString(4, veiculo.getPlaca());;
			ps.setString(5, veiculo.getModelo());;
			ps.setString(6, veiculo.getDsVeiculo());;
			ps.setInt(7, veiculo.getTripulantes());;
			
			ps1 = con.prepareStatement(sqlUser);
			ps1.setString(1, veiculo.getUser().getNome());
			ps1.setInt(2, veiculo.getUser().getIdade());
			ps1.setString(3, veiculo.getUser().getProfissao());
			ps1.setDouble(4, veiculo.getUser().getSalario());
			ps1.setString(5, veiculo.getUser().getRaca());
			ps1.setString(6, veiculo.getUser().getGenero());
			ps1.setString(7, veiculo.getUser().getNacionalidade());
			ps1.setString(8, veiculo.getUser().getTpSanguineo());
			ps1.setString(9, veiculo.getUser().getLogin());
			ps1.setString(10, veiculo.getUser().getSenha());
			
			ps.executeUpdate();
			ps1.executeUpdate();
			
			return "ok";

			
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** Metodo responsavel por atualizar veiculos 
	 * 
	 * @param login
	 * @return String de resposta sucedida
	 */
	
	public String updateVehicle(VeiculoTO veiculo) {
		String sql = "update t_sc_veiculo set "
				+ "nm_carro = ?,"
				+ "tp_veiculo = ?,"
				+ "ds_cor_veiculo = ?,"
				+ "ds_placa = ?,"
				+ "ds_modelo_veiculo = ?,"
				+ "ds_veiculo = ?,"
				+ "qt_tripulantes = ?"
				+ " where id_veiculo = ?";
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, veiculo.getNmVeiculo());;
			ps.setString(2, veiculo.getTipo());;
			ps.setString(3, veiculo.getCor());;
			ps.setString(4, veiculo.getPlaca());;
			ps.setString(5, veiculo.getModelo());;
			ps.setString(6, veiculo.getDsVeiculo());;
			ps.setInt(7, veiculo.getTripulantes());;
			ps.setLong(8, veiculo.getId());
			
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
				
			} else {
				return "erro ao inserir!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/** Metodo responsavel por deletar veiculos 
	 * 
	 * @param login
	 * @return String de resposta sucedida
	 */
	
	public String deleteVehicle(int id) {
		String sql = "delete  from t_sc_veiculo v"
					+ " inner join t_sc_chamado c ON v.id_veiculo = c.id_chamado"
					+ " where v.id_veiculo = ? ";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
				
			} else {
				return "erro ao inserir!";
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
