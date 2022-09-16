package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BeneficioDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public BeneficioDAO(Connection con) {
		setCon(con);
	}
	public String inserir(Beneficio beneficio) {
		String sql = "insert into t_rpj_beneficio(id_beneficio, ds_beneficio) values (?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, beneficio.getIdBeneficio());
			ps.setString(2, beneficio.getNomeBeneficio());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterar(Beneficio beneficio) {
		String sql = "update t_rpj_beneficio set ds_beneficio = ? where id_beneficio = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, beneficio.getNomeBeneficio());
			ps.setInt(2, beneficio.getIdBeneficio());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(Beneficio beneficio) {
		String sql = "delete from t_rpj_beneficio where id_beneficio = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, beneficio.getIdBeneficio());
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
