package br.huma.appseriestvweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.huma.appseriestvweb.bean.Series;
import br.huma.appseriestvweb.bean.SeriesTempoCapitulos;
import br.huma.appseriestvweb.bean.SeriesTemporada;
import br.huma.appseriestvweb.db.HibernateUtil;

public class SeriesTempoCapDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();

	public List<SeriesTempoCapitulos> listarTemporadaCapitulos(
			String nomeserie, String temporada) {

		if (!session.isConnected()) {
			session = HibernateUtil.getSessionFactory().openSession();
		}

		List<SeriesTempoCapitulos> lista = new ArrayList<SeriesTempoCapitulos>();

		String colunas = "d.id, d.capitulo, d.assistido, d.descricao, "
				+ "d.seriesTemporada.id, d.seriesTemporada.temporada, d.seriesTemporada.ano, "
				+ "d.seriesTemporada.descricao, d.seriesTemporada.foto, d.seriesTemporada.qtdcapitulos, "
				+ "d.series.id, d.series.nome, d.series.descricao, d.series.nomefoto, "
				+ "d.series.serieAprovada, d.series.anoInicial, d.series.anoFinal ";

		org.hibernate.Query pesquisa = session
				.createQuery("select "
						+ colunas
						+ " FROM SeriesTempoCapitulos d inner join d.series s inner join d.seriesTemporada st "
						+ "where d.series.nome =:paramnome and d.seriesTemporada.temporada = :temporada");
		pesquisa.setParameter("paramnome", nomeserie);
		pesquisa.setParameter("temporada", Integer.parseInt(temporada));

		@SuppressWarnings("unchecked")
		List<Object[]> retorno = pesquisa.list();
		for (Object[] sd : retorno) {
			SeriesTemporada serietempo = new SeriesTemporada();
			Series serie = new Series();
			SeriesTempoCapitulos serietempcap = new SeriesTempoCapitulos();

			serietempcap.setId(Long.parseLong(sd[0].toString()));
			serietempcap.setCapitulo(Integer.parseInt(sd[1].toString()));
			if ((sd[2] == null) || (sd[2].toString().isEmpty())) {
				serietempcap.setAssistido(false);
			} else {
				serietempcap
						.setAssistido(Boolean.parseBoolean(sd[2].toString()));
			}
			serietempcap.setDescricao(sd[3].toString());

			// objeto serietemporada
			serietempo.setId(Long.parseLong(sd[4].toString()));
			serietempo.setTemporada(Integer.parseInt(sd[5].toString()));
			serietempo.setAno(sd[6].toString());
			serietempo.setDescricao(sd[7].toString());
			serietempo.setFoto(sd[8].toString());
			serietempo.setQtdcapitulos(Integer.parseInt(sd[9].toString()));

			// objeto serie
			serie.setId(Long.parseLong(sd[10].toString()));
			serie.setNome(sd[11].toString());
			serie.setDescricao(sd[12].toString());
			serie.setNomefoto(sd[13].toString());
			if ((sd[14] == null) || (sd[14].toString().isEmpty())) {
				serie.setSerieAprovada(false);
			} else {
				serie.setSerieAprovada(Boolean.parseBoolean(sd[14].toString()));
			}
			serie.setAnoInicial(sd[15].toString());
			serie.setAnoFinal(sd[16].toString());

			serietempcap.setSeriesTemporada(serietempo);
			serietempcap.setSeries(serie);

			lista.add(serietempcap);
		}

		return lista;
	}
}
