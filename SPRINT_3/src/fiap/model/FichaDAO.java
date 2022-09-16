package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FichaDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public FichaDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Ficha ficha) {
		String sql = "insert into t_rpj_ficha_jogador(id_ficha) values (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, ficha.getId_ficha());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String excluir(Ficha ficha) {
		String sql = "delete from t_rpj_ficha_jogador where id_ficha = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, ficha.getId_ficha());
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