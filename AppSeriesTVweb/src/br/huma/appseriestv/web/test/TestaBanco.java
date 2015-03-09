package br.huma.appseriestv.web.test;

import org.hibernate.Session;

import br.huma.appseriestvweb.bean.Series;
import br.huma.appseriestvweb.bean.UsuSeries;
import br.huma.appseriestvweb.bean.Usuario;
import br.huma.appseriestvweb.db.HibernateUtil;

public class TestaBanco {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		HibernateUtil.atualizarBD();

		Usuario usu = new Usuario();
		usu.setNome("MarceloHibernate");
		usu.setEmail("marcelo@hibernate.com");
		usu.setSenha("123");

		Series serie = new Series();
		serie.setNome("Dexter");
		serie.setDescricao("Serial killer");

		UsuSeries ususerie = new UsuSeries();
		ususerie.setAprovada(true);
		ususerie.setUsuario(usu);
		ususerie.setSerie(serie);

		session.beginTransaction();
		session.save(ususerie);
		session.getTransaction().commit();
		session.close();

		/*
		 * Usuario usu = new Usuario(); usu.setNome("MarceloHibernate");
		 * usu.setEmail("marcelo@hibernate.com"); usu.setSenha("123");
		 * 
		 * session.beginTransaction(); session.save(usu);
		 * session.getTransaction().commit(); session.close();
		 */

	}

}
