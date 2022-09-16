package fiap.model;

import java.time.LocalDate;

public class Campanha {
	private String areaAtuacao, nomeCampanha, descCampanha, tipoContrato, local, tipoJornada, periodo, feedNeg, feedApr;

	public String getFeedNeg() {
		return feedNeg;
	}

	public void setFeedNeg(String feedNeg) {
		this.feedNeg = feedNeg;
	}

	public String getFeedApr() {
		return feedApr;
	}

	public void setFeedApr(String feedApr) {
		this.feedApr = feedApr;
	}

	public String getDescCampanha() {
		return descCampanha;
	}

	public void setDescCampanha(String descCampanha) {
		this.descCampanha = descCampanha;
	}

	private int idCampanha;
	private LocalDate dataCriacao;

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getNomeCampanha() {
		return nomeCampanha;
	}

	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTipoJornada() {
		return tipoJornada;
	}

	public void setTipoJornada(String tipoJornada) {
		this.tipoJornada = tipoJornada;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getIdCampanha() {
		return idCampanha;
	}

	public void setIdCampanha(int idCampanha) {
		this.idCampanha = idCampanha;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		LocalDate dataSistema = LocalDate.now();
		this.dataCriacao = dataSistema;
	}

}