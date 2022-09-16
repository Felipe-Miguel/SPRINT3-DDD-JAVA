package fiap.model;

import java.time.LocalDate;
import java.time.Period;

import javax.swing.JOptionPane;

public class Jogador extends Usuario {
	private int cpf, nivel;
	private String nome, sobrenome, tipoSexo;
	private LocalDate dataNasc;

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(String tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		LocalDate inicio = LocalDate.parse("1899-12-31");
		LocalDate fim = LocalDate.now();
		try {
			if (dataNasc.isAfter(inicio) && dataNasc.isBefore(fim)) {
				this.dataNasc = dataNasc;
			} else {
				throw new Exception("Data inválida");
			}
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

	public int calcularNivel() {
		return 0;
	}

	public int calculaIdade() {
        LocalDate dataFim = LocalDate.now();
        Period periodo = Period.between(dataNasc, dataFim);
        int anos = periodo.getYears();
        System.out.println("Idade: " + anos + " anos.");
        return anos;
    }
}
