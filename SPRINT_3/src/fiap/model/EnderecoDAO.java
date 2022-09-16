package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public EnderecoDAO(Connection con) {
		setCon(con);
	}

	public String inserirEndJog(Endereco endereco) {
		String sql = "insert into t_rpj_endereco_jogador(id_endereco, nm_cidade, nr_cep, sg_estado, nm_pais) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, endereco.getIdEndereco());
			ps.setString(2, endereco.getNomeCidade());
			ps.setInt(3, endereco.getCep());
			ps.setString(4, endereco.getSiglaEstado());
			ps.setString(5, endereco.getNomePais());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterarEndJog(Endereco endereco) {
		String sql = "update t_rpj_endereco_jogador set nm_cidade = ?, nr_cep = ?, sg_estado = ?, nm_pais = ? where id_endereco = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, endereco.getNomeCidade());
			ps.setInt(2, endereco.getCep());
			ps.setString(3, endereco.getSiglaEstado());
			ps.setString(4, endereco.getNomePais());
			ps.setInt(5, endereco.getIdEndereco());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluirEndJog(Endereco endereco) {
		String sql = "delete from t_rpj_endereco_jogador where id_endereco = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, endereco.getIdEndereco());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public String inserirEndNar(Endereco endereco) {
		String sql = "insert into t_rpj_endereco_narrador (id_endereco, nm_cidade, nr_cep, sg_estado, nm_pais) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, endereco.getIdEndereco());
			ps.setString(2, endereco.getNomeCidade());
			ps.setInt(3, endereco.getCep());
			ps.setString(4, endereco.getSiglaEstado());
			ps.setString(5, endereco.getNomePais());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterarEndNar(Endereco endereco) {
		String sql = "update t_rpj_endereco_narrador set nm_cidade = ?, nr_cep = ?, sg_estado = ?, nm_pais = ? where id_endereco = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, endereco.getNomeCidade());
			ps.setInt(2, endereco.getCep());
			ps.setString(3, endereco.getSiglaEstado());
			ps.setString(4, endereco.getNomePais());
			ps.setInt(5, endereco.getIdEndereco());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluirEndNar(Endereco endereco) {
		String sql = "delete from t_rpj_endereco_narrador where id_endereco = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, endereco.getIdEndereco());
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