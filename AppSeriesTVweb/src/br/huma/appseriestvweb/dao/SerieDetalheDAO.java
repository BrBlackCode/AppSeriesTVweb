package br.huma.appseriestvweb.dao;

import java.util.List;

import org.hibernate.Session;

import br.huma.appseriestvweb.bean.Series;
import br.huma.appseriestvweb.bean.SeriesDetalhe;
import br.huma.appseriestvweb.db.HibernateUtil;

public class SerieDetalheDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();

	public SeriesDetalhe buscaSerieDetalheByNome(String nome) {

		try {
			if (!session.isConnected()) {
				session = HibernateUtil.getSessionFactory().openSession();
			}
			String colunas = "d.id, d.sinopse, d.foto1, d.foto2, d.foto3, d.foto4, "
					+ "d.classificacao, d.avaliacao, d.genero, d.totalCapitulos, "
					+ "d.serie.id, d.serie.nome, d.serie.descricao, d.serie.nomefoto, "
					+ "d.serie.serieAprovada, d.serie.anoInicial, d.serie.anoFinal ";

			SeriesDetalhe seriedet = new SeriesDetalhe();
			Series serie = new Series();

			org.hibernate.Query pesquisa = session
					.createQuery("select "
							+ colunas
							+ " FROM SeriesDetalhe d inner join d.serie s where d.serie.nome =:paramnome");
			pesquisa.setParameter("paramnome", nome);

			pesquisa.setMaxResults(1);

			@SuppressWarnings("unchecked")
			List<Object[]> retorno = pesquisa.list();

			for (Object[] sd : retorno) {

				seriedet.setId(Long.parseLong(sd[0].toString()));
				seriedet.setSinopse(sd[1].toString());
				seriedet.setFoto1(sd[2].toString());
				seriedet.setFoto2(sd[3].toString());
				seriedet.setFoto3(sd[4].toString());
				seriedet.setFoto4(sd[5].toString());
				seriedet.setClassificacao(sd[6].toString());
				seriedet.setAvaliacao(Float.parseFloat(sd[7].toString()));
				seriedet.setGenero(sd[8].toString());
				seriedet.setTotalCapitulos(Integer.parseInt(sd[9].toString()));

				// objeto serie
				serie.setId(Long.parseLong(sd[10].toString()));
				serie.setNome(sd[11].toString());
				serie.setDescricao(sd[12].toString());
				serie.setNomefoto(sd[13].toString());
				if ((sd[14] == null) || (sd[14].toString().isEmpty())) {
					serie.setSerieAprovada(false);
				} else {

					serie.setSerieAprovada(Boolean.parseBoolean(sd[14]
							.toString()));
				}
				serie.setAnoInicial(sd[15].toString());
				serie.setAnoFinal(sd[16].toString());
				// adiciona o objeto
				seriedet.setSerie(serie);
			}

			return seriedet;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}
	// SQL Correto
	// .createQuery("FROM SeriesDetalhe d inner join d.serie s where d.serie.nome =:paramnome");

	/*
	 * org.hibernate.Query pesquisa = session .createQuery(
	 * "FROM SeriesDetalhe d inner join d.serie s on d.serie.id = s.id where s.serie.nome =:paramnome"
	 * ); pesquisa.setParameter("paramnome", nome);
	 */

}
