package fiap.model;

import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

public class Aventura {
	private int id,xp;
	private String nomeAventura, nomeInstituicao, tipoAventura, grauAventura;
	private LocalDate dataInicio, dataFim;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public String getNomeAventura() {
		return nomeAventura;
	}
	public void setNomeAventura(String nomeAventura) {
		this.nomeAventura = nomeAventura;
	}
	public String getNomeInstituicao() {
		return nomeInstituicao;
	}
	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}
	public String getTipoAventura() {
		return tipoAventura;
	}
	public void setTipoAventura(String tipoAventura) {
		this.tipoAventura = tipoAventura;
	}
	public String getGrauAventura() {
		return grauAventura;
	}
	public void setGrauAventura(String grauAventura) {
		this.grauAventura = grauAventura;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		LocalDate d1 = LocalDate.now() ;
		Period periodo = Period.between(d1, dataInicio);
		int verificacao = periodo.getDays();
		if (verificacao >= 0) {
			this.dataInicio = dataInicio;
		} else {
			JOptionPane.showMessageDialog(null, "Data inválida");
		}
		
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	public int calculaXP() {
		return 0;
	}
	
	public int calculaPeriodoAven() {
		Period periodo = Period.between(dataInicio, dataFim);
		int anos = periodo.getYears();
		System.out.println("Período da aventura: " + anos + " anos.");
		return anos;
	}
}
