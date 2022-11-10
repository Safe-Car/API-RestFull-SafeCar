package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;
import to.ChamadoTO;

public class ChamadoDAO {

	private Connection con;

	public ChamadoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public String insert(ChamadoTO c) {
		PreparedStatement ps = null;
		String sql = "insert into t_sc_chamado (id_chamado," + "id_veiculo," + "id_contato_emergencia,"
				+ "tp_ocorrencia," + "ds_grau_ocorrencia," + "loc_ocorrencia," + "ds_cordenadas,"
				+ "dt_chamado) values(sq_sc_chamado_sequence.nextval,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, c.getVeiculo().getId());
			ps.setLong(2, c.getEmergencia().getId());
			ps.setString(3, c.getTipoOcorrencia());
			ps.setString(4, c.getGrau());
			ps.setString(5, c.getLocalizacao());
			ps.setString(6, c.getCordenadas());
			ps.setDate(7, c.getData());

			if (ps.executeUpdate() > 0) {
				return "inserido com sucesso";

			} else {
				return "erro ao inserir";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

	}

	public String update(ChamadoTO c) {
		PreparedStatement ps = null;
		String sql = "update t_sc_chamado set " + "id_veiculo =?," + "id_contato_emergencia =?,"
				+ "tp_ocorrencia =?," + "ds_grau_ocorrencia =?," + "loc_ocorrencia =?," + "ds_cordenadas =?,"
				+ "dt_chamado=? where id_chamado = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, c.getVeiculo().getId());
			ps.setLong(2, c.getEmergencia().getId());
			ps.setString(3, c.getTipoOcorrencia());
			ps.setString(4, c.getGrau());
			ps.setString(5, c.getLocalizacao());
			ps.setString(6, c.getCordenadas());
			ps.setDate(7, c.getData());
			ps.setLong(8, c.getId());

			if (ps.executeUpdate() > 0) {
				return "inserido com sucesso";

			} else {
				return "erro ao inserir";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

	}

	public String delete(int id) {
		PreparedStatement ps = null;
		String sql = "delete t_sc_chamado where id_chamado =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);

			if (ps.executeUpdate() > 0) {
				return "inserido com sucesso";

			} else {
				return "erro ao inserir";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

	}

}
