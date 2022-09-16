package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConhecimentoDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public ConhecimentoDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Conhecimento conhecimento) {
		String sql = "insert into t_rpj_conhecimento(id_conhecimento, nm_conhecimento) values (?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, conhecimento.getIdConhecimento());
			ps.setString(2, conhecimento.getNomeConhecimento());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterar(Conhecimento conhecimento) {
		String sql = "update t_rpj_conhecimento set nm_conhecimento = ? where id_conhecimento = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, conhecimento.getNomeConhecimento());
			ps.setInt(2, conhecimento.getIdConhecimento());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(Conhecimento conhecimento) {
		String sql = "delete from t_rpj_conhecimento where id_conhecimento = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, conhecimento.getIdConhecimento());
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