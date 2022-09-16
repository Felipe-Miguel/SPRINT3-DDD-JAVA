package fiap.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NarradorDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public NarradorDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Narrador narrador) {
		String sql = "insert into t_rpj_narrador(id_usuario, ds_email, ds_senha, nr_cnpj, nm_fantasia, nm_razao_social, dt_fundacao, ds_area_atuacao, tp_porte) values (?,?,?,?,?,?,?,?,?)";
		try {
			Date dataFund = java.sql.Date.valueOf(narrador.getDataFundacao());
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, narrador.getId());
			ps.setString(2, narrador.getEmail());
			ps.setString(3, narrador.getSenha());
			ps.setInt(4, narrador.getCnpj());
			ps.setString(5, narrador.getNomeFantasia());
			ps.setString(6, narrador.getRazaoSocial());
			ps.setDate(7, dataFund);
			ps.setString(8, narrador.getAreaAtuacao());
			ps.setString(9, narrador.getPorte());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterar(Narrador narrador) {
		String sql = "update t_rpj_narrador set nm_fantasia = ?, nm_razao_social = ?, ds_area_atuacao = ?, tp_porte = ? where id_usuario = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, narrador.getNomeFantasia());
			ps.setString(2, narrador.getRazaoSocial());
			ps.setString(3, narrador.getAreaAtuacao());
			ps.setString(4, narrador.getPorte());
			ps.setInt(5, narrador.getId());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public String alterarSenha(Narrador narrador) {
		String sql = "update t_rpj_usuario set ds_senha = ? where id_usuario = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, narrador.getSenha());
			ps.setInt(2, narrador.getId());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public String excluir(Narrador narrador) {
		String sql = "delete from t_rpj_narrador where id_usuario = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, narrador.getId());
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