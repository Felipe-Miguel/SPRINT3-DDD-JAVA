package fiap.model;

import java.time.LocalDate;
import java.time.Period;

import javax.swing.JOptionPane;

public class Narrador extends Usuario {

	private int cnpj;
	private String razaoSocial, nomeFantasia, areaAtuacao, porte;
	private LocalDate dataFundacao;

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		LocalDate d1 = LocalDate.now();
		Period periodo = Period.between(d1, dataFundacao);
		int verificacao = periodo.getDays();
		if (verificacao >= 0) {
			this.dataFundacao = dataFundacao;
		} else {
			JOptionPane.showMessageDialog(null, "Data inválida");
		}
	}

}