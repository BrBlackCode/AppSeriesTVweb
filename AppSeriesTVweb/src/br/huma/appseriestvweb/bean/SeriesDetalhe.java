package br.huma.appseriestvweb.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seriesdetalhe")
public class SeriesDetalhe extends Persistivel implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_serie")
	private Series serie;

	@Column(name = "sinopse", length = 10000)
	private String sinopse;

	@Column(name = "foto1")
	private String foto1;

	@Column(name = "foto2")
	private String foto2;

	@Column(name = "foto3")
	private String foto3;

	@Column(name = "foto4")
	private String foto4;

	@Column(name = "classificacao")
	private String classificacao;

	@Column(name = "avaliacao")
	private float avaliacao;

	@Column(name = "genero")
	private String genero;

	@Column(name = "totalCapitulos")
	private int totalCapitulos;

	public Series getSerie() {
		return serie;
	}

	public void setSerie(Series serie) {
		this.serie = serie;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getFoto1() {
		return foto1;
	}

	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}

	public String getFoto2() {
		return foto2;
	}

	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}

	public String getFoto3() {
		return foto3;
	}

	public void setFoto3(String foto3) {
		this.foto3 = foto3;
	}

	public String getFoto4() {
		return foto4;
	}

	public void setFoto4(String foto4) {
		this.foto4 = foto4;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public float getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(float avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return this.sinopse;
	}

	public int getTotalCapitulos() {
		return totalCapitulos;
	}

	public void setTotalCapitulos(int totalCapitulos) {
		this.totalCapitulos = totalCapitulos;
	}

}
