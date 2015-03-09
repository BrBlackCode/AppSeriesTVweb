package br.huma.appseriestvweb.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	public static final SessionFactory session = buildSession();

	private static SessionFactory buildSession() {

		try {
			Configuration cfg = hibernateConfig();

			return cfg.buildSessionFactory();

		} catch (Throwable b) {

			System.out.println("Ocorreu um erro \n" + b);
			throw new ExceptionInInitializerError();
		}
	}

	private static Configuration hibernateConfig() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		return cfg;
	}

	public static SessionFactory getSessionFactory() {
		return session;
	}

	/**
	 * Atualiza o Schema do Banco de Dados
	 */
	public static void atualizarBD() {
		try {
			SchemaUpdate su = new SchemaUpdate(hibernateConfig());
			su.execute(true, true);
		} catch (Exception e) {
		}
	}
}
