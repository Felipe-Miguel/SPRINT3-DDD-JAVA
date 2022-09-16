package fiap.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CampanhaDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public CampanhaDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Campanha campanha) {
		String sql = "insert into t_rpj_campanha (id_campanha, nm_campanha, ds_area_atuacao, ds_campanha, ds_local, tp_contrato, ds_joranada, dt_criacao, ds_periodo, ds_feedback_neg, ds_feedback_apr) values (?,?,?,?,?,?,?,?,?)";
		LocalDateTime localDate = LocalDateTime.now();
		Date dataCriacao = (Date) Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, campanha.getIdCampanha());
			ps.setString(2, campanha.getNomeCampanha());
			ps.setString(3, campanha.getAreaAtuacao());
			ps.setString(4, campanha.getDescCampanha());
			ps.setString(5, campanha.getLocal());
			ps.setString(6, campanha.getTipoContrato());
			ps.setString(7, campanha.getTipoJornada());
			ps.setDate(8, dataCriacao);
			ps.setString(9, campanha.getPeriodo());
			ps.setString(10, campanha.getFeedNeg());
			ps.setString(11, campanha.getFeedApr());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterar(Campanha campanha) {
		String sql = "update t_rpj_campanha set nm_campanha = ?, ds_area_atuacao = ?, ds_campanha = ?, ds_local = ?, tp_contrato =?, ds_joranada = ?, dt_criacao = ?, ds_periodo = ?, ds_feedback_neg = ?,ds_feedback_apr = ?  where idCampanha = ?";
		try {
			LocalDateTime localDate = LocalDateTime.now();
			Date dataCriacao = (Date) Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, campanha.getNomeCampanha());
			ps.setString(2, campanha.getAreaAtuacao());
			ps.setString(3, campanha.getDescCampanha());
			ps.setString(4, campanha.getLocal());
			ps.setString(5, campanha.getTipoContrato());
			ps.setString(6, campanha.getTipoJornada());
			ps.setDate(7, dataCriacao);
			ps.setString(8, campanha.getPeriodo());
			ps.setString(9, campanha.getFeedNeg());
			ps.setString(10, campanha.getFeedApr());
			ps.setInt(11, campanha.getIdCampanha());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(Campanha campanha) {
		String sql = "delete from t_rpj_campanha where id_campanha = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, campanha.getIdCampanha());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String listarTodos() {
		String sql = "select * from t_rpj_campanha";
		String listaCampanha = "Lista das campanhas \n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaCampanha += "\nNome da campanha: " + rs.getString(2) + "\nÁrea atuação: " + rs.getString(3)
							+ "\nTipo de contrato: " + rs.getString(4) + "\nLocal: " + rs.getString(5)
							+ "\nTipo de jornada: " + rs.getString(6) + "\nPeríodo: " + rs.getString(7);
				}
				return listaCampanha;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}