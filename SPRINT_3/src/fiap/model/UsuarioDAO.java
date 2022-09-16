package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public UsuarioDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Usuario usuario) {
		String sql = "insert into t_rpj_usuario (id_usuario, ds_email, ds_senha) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, usuario.getId());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterarSenha(Usuario usuario) {
		String sql = "update t_rpj_usuario set ds_senha = ? where id_usuario = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, usuario.getSenha());
			ps.setInt(2, usuario.getId());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(Usuario usuario) {
		String sql = "delete from t_rpj_usuario where id_usuario = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, usuario.getId());
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