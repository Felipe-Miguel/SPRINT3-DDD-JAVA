package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidaturaDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public CandidaturaDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Jogador jogador, Campanha campanha) {
		String sql = "insert into t_rpj_candidatura(id_jogador, id_campanha) values (?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(2, jogador.getId());
			ps.setInt(1, campanha.getIdCampanha());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {	
			return e.getMessage();
		}
	}

	public String excluir(Jogador jogador) {
		String sql = "delete from t_rpj_candidatura where id_usuario = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, jogador.getId());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

}