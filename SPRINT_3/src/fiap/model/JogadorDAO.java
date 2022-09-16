package fiap.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class JogadorDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public JogadorDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Jogador jogador) {
		String sql = "insert into t_rpj_jogador(id_usuario, ds_email, ds_senha, nr_cpf, nm_jogador, nm_sobrenome, dt_nascimento, tp_sexo, nr_nivel) values (?,?,?,?,?,?,?,?,?)";
		Date dataNasc = java.sql.Date.valueOf(jogador.getDataNasc());
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, jogador.getId());
			ps.setString(2, jogador.getEmail());
			ps.setString(3, jogador.getSenha());
			ps.setInt(4, jogador.getCpf());
			ps.setString(5, jogador.getNome());
			ps.setString(6, jogador.getSobrenome());
			ps.setDate(7, dataNasc);
			ps.setString(8, jogador.getTipoSexo());
			ps.setInt(9, jogador.getNivel());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterar(Jogador jogador) {
		String sql = "update t_rpj_jogador set nm_jogador = ?, nm_sobrenome = ?, dt_nascimento = ?, tp_sexo = ?, nr_nivel = ? where id_usuario = ?";
		Date dataNasc = java.sql.Date.valueOf(jogador.getDataNasc());
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, jogador.getNome());
			ps.setString(2, jogador.getSobrenome());
			ps.setDate(3, dataNasc);
			ps.setString(4, jogador.getTipoSexo());
			ps.setInt(5, jogador.getNivel());
			ps.setInt(6, jogador.getId());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public String alterarSenha(Jogador jogador) {
		String sql = "update t_rpj_jogador set ds_senha = ? where id_usuario = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, jogador.getSenha());
			ps.setInt(2, jogador.getId());
			if (ps.executeUpdate() > 0) {
				return "Banco alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public String excluir(Jogador jogador) {
		String sql = "delete from t_rpj_jogador where id_usuario = ?";
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
    public String listarTodos() {
           String sql = "select * from t_rpj_jogador";
           String listaJogador = "Lista dos jogadores \n\n";
           try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                    	listaJogador+= "\nNome da aventura: " + rs.getString(3) + "\nNome da instituição: " + rs.getString(4) + "\nTipo de aventura: " + rs.getString(5)
                        + "\nGrau aventura: " + rs.getString(6) + "\nData de início: " + rs.getString(7) + "\nData de conclusão: " + rs.getString(8);
                    }
                    return listaJogador;
                } else {
                    return null;
                }
            } catch (SQLException e) {
                return null;
            }
       }
}