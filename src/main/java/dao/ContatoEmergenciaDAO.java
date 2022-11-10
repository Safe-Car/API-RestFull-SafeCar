package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;
import to.ContatoEmergenciaTO;

/**Classe de conexão do banco de dados SAafe Car
 * 
 * @author Jhonatas Oliveira
 * @version 1.0
 *
 */
public class ContatoEmergenciaDAO {

	private Connection con;

	public ContatoEmergenciaDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	
	/** Metodo responsavel por inserir contato de emergencia
	 * 
	 * @param contatoEmergenciaTO
	 * @return String validacao
	 */

	public String insertContatoEmergencia(ContatoEmergenciaTO ce) {
		String sql = "insert into t_sc_contato_emergencia (id_contato_emergencia," + "tp_contato_emergencia,"
				+ "nr_telefone," + "ds_ddd," + "ds_ddi) values(sq_sc_contato_emergencia.nextval,?,?,?,?) ";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ce.getTipoContato());
			ps.setInt(2, ce.getTelefone());
			ps.setInt(3, ce.getDdd());
			ps.setInt(4, ce.getDdi());

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
	
	/** Metodo responsavel por atualizar contato de emergencia
	 * 
	 * @param contatoEmergenciaTO
	 * @return String validacao
	 */


	public String updateContatoEmergencia(ContatoEmergenciaTO ce) {
		String sql = "update t_sc_contato_emergencia set "
				+ "tp_contato_emergencia = ?,"
				+ "nr_telefone = ?,"
				+ "ds_ddd = ?,"
				+ "ds_ddi = ? where id_contato_emergencia = ?";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ce.getTipoContato());
			ps.setInt(2, ce.getTelefone());
			ps.setInt(3, ce.getDdd());
			ps.setInt(4, ce.getDdi());
			ps.setLong(5, ce.getId());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";

			} else {
				return "Erro ao inserir";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

	}
	
	/** Metodo responsavel por deletar contato de emergencia
	 * 
	 * @param id
	 * @return String validacao
	 */
	
	public String deleteContatoEmergencia(int id) {
		String sql = "delete t_sc_contato_emergencia where id_contato_emergencia = ? ";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";

			} else {
				return "Erro ao inserir";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

	}

}
