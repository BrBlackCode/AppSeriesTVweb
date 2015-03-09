package br.huma.appseriestvweb.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ususeriesdetalhe")
public class UsuSeriesDetalhe extends Persistivel implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usu;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_seriesdetalhe")
	private SeriesDetalhe seriesDetalhe;

	@Column(name = "ususeriesprogresso")
	private int ususerieProgresso;

	@Column(name = "ususerieavaliacao")
	private float usuSerieAvaliacao;

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public SeriesDetalhe getSeriesDetalhe() {
		return seriesDetalhe;
	}

	public void setSeriesDetalhe(SeriesDetalhe seriesDetalhe) {
		this.seriesDetalhe = seriesDetalhe;
	}

	public int getUsuserieProgresso() {
		return ususerieProgresso;
	}

	public void setUsuserieProgresso(int ususerieProgresso) {
		this.ususerieProgresso = ususerieProgresso;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public float getUsuSerieAvaliacao() {
		return usuSerieAvaliacao;
	}

	public void setUsuSerieAvaliacao(float usuSerieAvaliacao) {
		this.usuSerieAvaliacao = usuSerieAvaliacao;
	}

}
