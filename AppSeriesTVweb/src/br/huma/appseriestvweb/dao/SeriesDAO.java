package br.huma.appseriestvweb.dao;

import java.util.List;

import org.hibernate.Session;

import br.huma.appseriestvweb.bean.Series;
import br.huma.appseriestvweb.db.HibernateUtil;

public class SeriesDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();

	@SuppressWarnings("unchecked")
	public List<Series> buscaTodasSeries() {

		try {
			if (!session.isConnected()) {
				session = HibernateUtil.getSessionFactory().openSession();
			}
			org.hibernate.Query pesquisa = session.createQuery("FROM Series");
			return (List<Series>) pesquisa.list();

		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public Series buscaSerieByNome(String nome) {

		try {
			if (!session.isConnected()) {
				session = HibernateUtil.getSessionFactory().openSession();
			}

			Series serie = new Series();
			org.hibernate.Query pesquisa = session
					.createQuery("FROM Series where nome =:paramnome");
			pesquisa.setParameter("paramnome", nome);

			pesquisa.setMaxResults(1);

			serie = (Series) pesquisa.uniqueResult();

			return serie;

		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}

	}
}
