																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtributoDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public AtributoDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Atributo atributo) {
		String sql = "insert into t_rpj_atributo(id_atributo, nm_atributo) values (?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, atributo.getIdAtributo());
			ps.setString(2, atributo.getNomeAtributo());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterar(Atributo atributo) {
		String sql = "update t_rpj_atributo set nm_atributo = ? where id_atributo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, atributo.getNomeAtributo());
			ps.setInt(2, atributo.getIdAtributo());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(Atributo atributo) {
		String sql = "delete from t_rpj_atributo where id_atributo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, atributo.getIdAtributo());
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
