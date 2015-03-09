package br.huma.appseriestvweb.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "series")
public class Series extends Persistivel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "nomefoto")
	private String nomefoto;

	@Column(name = "serieaprovada")
	private Boolean serieAprovada;

	@Column(name = "anoinicial")
	private String anoInicial;

	@Column(name = "anofinal")
	private String anoFinal;

	public String getAnoInicial() {
		return anoInicial;
	}

	public void setAnoInicial(String anoInicial) {
		this.anoInicial = anoInicial;
	}

	public String getAnoFinal() {
		return anoFinal;
	}

	public void setAnoFinal(String anoFinal) {
		this.anoFinal = anoFinal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomefoto() {
		return nomefoto;
	}

	public void setNomefoto(String nomefoto) {
		this.nomefoto = nomefoto;
	}

	public Boolean getSerieAprovada() {
		return serieAprovada;
	}

	public void setSerieAprovada(Boolean serieAprovada) {
		this.serieAprovada = serieAprovada;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
