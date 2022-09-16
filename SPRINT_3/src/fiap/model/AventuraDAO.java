package fiap.model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AventuraDAO {
	private Connection con;
	
    public Connection getCon() {
        return con;
    }
    
    public void setCon(Connection con) {
        this.con = con;
    }
   public AventuraDAO(Connection con) {
        setCon(con);
    }
   
   public String inserir(Aventura aventura) {
	   String sql = "insert into t_rpj_aventura(id_aventura, nm_aventura, nm_instituicao, tp_aventura, ds_grau_aventura, dt_inicio, dt_fim, nr_xp) values (?,?,?,?,?,?,?,?)";
	   Date dataInicio = java.sql.Date.valueOf(aventura.getDataInicio());
	   Date dataFim = java.sql.Date.valueOf(aventura.getDataFim());
	   try {
		   PreparedStatement ps = getCon().prepareStatement(sql);
		   ps.setInt(1, aventura.getId());
		   ps.setString(2, aventura.getNomeAventura());
		   ps.setString(3, aventura.getNomeInstituicao());
		   ps.setString(4, aventura.getTipoAventura());
		   ps.setString(5, aventura.getGrauAventura());
		   ps.setDate(6, dataInicio);
		   ps.setDate(7, dataFim); 
		   ps.setInt(8, aventura.getXp());
		   if (ps.executeUpdate() > 0) {
               return "Inserido com sucesso";
           } else {
               return "Erro ao inserir";
           }
		   } catch (Exception e) {
			   return e.getMessage();
		   }
   }
   public String alterar(Aventura aventura) {
	   String sql = "update t_rpj_aventura set nm_aventura = ?, nm_instituicao = ?, tp_aventura = ?, ds_grau_aventura = ?, dt_inicio = ?, dt_fim = ?,nr_xp = ? where id_aventura = ?";
	   try {
		   Date dataInicio = java.sql.Date.valueOf(aventura.getDataInicio());
		   Date dataFim = java.sql.Date.valueOf(aventura.getDataFim());
		   PreparedStatement ps = getCon().prepareStatement(sql);
		   ps.setString(1, aventura.getNomeAventura());
		   ps.setString(2, aventura.getNomeInstituicao());
		   ps.setString(3, aventura.getTipoAventura());
		   ps.setString(4, aventura.getGrauAventura());
		   ps.setDate(5, dataInicio);
		   ps.setDate(6, dataFim); 
		   ps.setInt(7, aventura.getXp());
		   ps.setInt(8, aventura.getId());
		   if (ps.executeUpdate() > 0) {
               return "Banco alterado com sucesso";
           } else {
               return "Erro ao alterar";
           }
       } catch (SQLException e) {
           return e.getMessage();
       }
   }
   public String excluir(Aventura aventura) {
	   String sql = "delete from t_rpj_aventura where id_aventura = ?";
	   try {
		   PreparedStatement ps = getCon().prepareStatement(sql);
		   ps.setInt(1, aventura.getId());
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
