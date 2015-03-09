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
@Table(name = "ususeriestemporada")
public class UsuSeriesTemporada extends Persistivel implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usu;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_seriestemporada")
	private SeriesTemporada seriesTemporada;

	@Column(name = "usutempoprogresso")
	private int usutempoProgresso;

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public SeriesTemporada getSeriesTemporada() {
		return seriesTemporada;
	}

	public void setSeriesTemporada(SeriesTemporada seriesTemporada) {
		this.seriesTemporada = seriesTemporada;
	}

	public int getUsutempoProgresso() {
		return usutempoProgresso;
	}

	public void setUsutempoProgresso(int usutempoProgresso) {
		this.usutempoProgresso = usutempoProgresso;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
