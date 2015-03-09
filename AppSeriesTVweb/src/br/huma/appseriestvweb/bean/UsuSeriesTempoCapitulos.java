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
@Table(name = "ususeriestempocapitulos")
public class UsuSeriesTempoCapitulos extends Persistivel implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usu;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_serietempocaps")
	private SeriesTempoCapitulos serieTempoCaps;

	@Column(name = "ususerieavaliacao", nullable = false)
	private Boolean assistido;

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public SeriesTempoCapitulos getSerieTempoCaps() {
		return serieTempoCaps;
	}

	public void setSerieTempoCaps(SeriesTempoCapitulos serieTempoCaps) {
		this.serieTempoCaps = serieTempoCaps;
	}

	public Boolean getAssistido() {
		return assistido;
	}

	public void setAssistido(Boolean assistido) {
		this.assistido = assistido;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
