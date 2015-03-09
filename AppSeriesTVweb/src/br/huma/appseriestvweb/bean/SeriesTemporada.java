package br.huma.appseriestvweb.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seriestemporada")
public class SeriesTemporada extends Persistivel implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_serie")
	private Series series;

	@Column(name = "temporada")
	private Integer temporada;

	@Column(name = "ano")
	private String ano;

	@Column(name = "descricao", length = 10000)
	private String descricao;

	@Column(name = "foto")
	private String foto;

	@Column(name = "qtdcapitulos")
	private Integer qtdcapitulos;

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public Integer getTemporada() {
		return temporada;
	}

	public void setTemporada(Integer temporada) {
		this.temporada = temporada;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getQtdcapitulos() {
		return qtdcapitulos;
	}

	public void setQtdcapitulos(Integer qtdcapitulos) {
		this.qtdcapitulos = qtdcapitulos;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

}
