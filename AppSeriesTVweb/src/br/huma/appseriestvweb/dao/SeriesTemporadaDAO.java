package br.huma.appseriestvweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.huma.appseriestvweb.bean.Series;
import br.huma.appseriestvweb.bean.SeriesTemporada;
import br.huma.appseriestvweb.db.HibernateUtil;

public class SeriesTemporadaDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();

	public List<SeriesTemporada> buscaSerieTemporadaByNome(String nomeserie) {

		try {
			if (!session.isConnected()) {
				session = HibernateUtil.getSessionFactory().openSession();
			}
			List<SeriesTemporada> lista = new ArrayList<SeriesTemporada>();

			String colunas = "d.id, d.temporada, d.ano, d.descricao, d.foto, d.qtdcapitulos, "
					+ "d.series.id, d.series.nome, d.series.descricao, d.series.nomefoto, "
					+ "d.series.serieAprovada, d.series.anoInicial, d.series.anoFinal ";
			org.hibernate.Query pesquisa = session
					.createQuery("select "
							+ colunas
							+ " FROM SeriesTemporada d inner join d.series s where d.series.nome =:paramnome");
			pesquisa.setParameter("paramnome", nomeserie);

			// pesquisa.setMaxResults(1);

			@SuppressWarnings("unchecked")
			List<Object[]> retorno = pesquisa.list();

			for (Object[] sd : retorno) {
				SeriesTemporada serietempo = new SeriesTemporada();
				Series serie = new Series();

				serietempo.setId(Long.parseLong(sd[0].toString()));
				serietempo.setTemporada(Integer.parseInt(sd[1].toString()));
				serietempo.setAno(sd[2].toString());
				serietempo.setDescricao(sd[3].toString());
				serietempo.setFoto(sd[4].toString());
				serietempo.setQtdcapitulos(Integer.parseInt(sd[5].toString()));

				// objeto serie
				serie.setId(Long.parseLong(sd[6].toString()));
				serie.setNome(sd[7].toString());
				serie.setDescricao(sd[8].toString());
				serie.setNomefoto(sd[9].toString());
				if ((sd[10] == null) || (sd[10].toString().isEmpty())) {
					serie.setSerieAprovada(false);
				} else {

					serie.setSerieAprovada(Boolean.parseBoolean(sd[10]
							.toString()));
				}
				serie.setAnoInicial(sd[11].toString());
				serie.setAnoFinal(sd[12].toString());
				// adiciona o objeto
				serietempo.setSeries(serie);

				lista.add(serietempo);
			}

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}
}
