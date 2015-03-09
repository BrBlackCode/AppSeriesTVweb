package br.huma.appseriestvweb.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seriestempocapitulos")
public class SeriesTempoCapitulos extends Persistivel implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_serietemporada")
	private SeriesTemporada seriesTemporada;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_serie")
	private Series series;

	@Column(name = "capitulo")
	private int capitulo;

	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;

	@Column(name = "assistido")
	private Boolean assistido;

	public SeriesTemporada getSeriesTemporada() {
		return seriesTemporada;
	}

	public void setSeriesTemporada(SeriesTemporada seriesTemporada) {
		this.seriesTemporada = seriesTemporada;
	}

	public int getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAssistido() {
		return assistido;
	}

	public void setAssistido(Boolean assistido) {
		this.assistido = assistido;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	/*
	 * @Column( name="colu(1)mnName"; boolean un(2)ique() default false; boolean
	 * nu(3)llable() default true; boolean in(4)sertable() default true; boolean
	 * up(5)datable() default true; String col(6)umnDefinition() default "";
	 * String tab(7)le() default ""; int length(8)() default 255; int
	 * precis(9)ion() default 0; // decimal precision int scale((10)) default 0;
	 * // decimal scale
	 */
}
