package br.huma.appseriestvweb.dao;

import org.hibernate.Session;

import br.huma.appseriestvweb.bean.Usuario;
import br.huma.appseriestvweb.db.HibernateUtil;

public class UsuarioDAO extends HibernateUtil {

	Session session = HibernateUtil.getSessionFactory().openSession();

	public boolean InsereUsuario(Usuario usuario) {
		try {
			try {
				if (!session.isConnected()) {
					session = HibernateUtil.getSessionFactory().openSession();
				}
				session.beginTransaction();
				session.save(usuario);
				session.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
		} finally {
			session.close();
		}
		return true;

	}

	public Usuario BuscaUsuarioByEmailSenha(String email, String senha) {
		try {
			if (!session.isConnected()) {
				session = HibernateUtil.getSessionFactory().openSession();
			}
			Usuario usu = new Usuario();
			org.hibernate.Query pesquisa = session
					.createQuery("FROM Usuario WHERE email = :user AND senha = :pass");
			pesquisa.setParameter("user", email);
			pesquisa.setParameter("pass", senha);
			pesquisa.setMaxResults(1);
			usu = (Usuario) pesquisa.uniqueResult();
			if (!(usu == null)) {
				return usu;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}

	}

	public Usuario BuscaUsuarioByID(Long id) {
		try {
			if (!session.isConnected()) {
				session = HibernateUtil.getSessionFactory().openSession();
			}
			Usuario usu = new Usuario();
			org.hibernate.Query pesquisa = session
					.createQuery("FROM Usuario WHERE id = :iduser");
			pesquisa.setParameter("iduser", id);
			pesquisa.setMaxResults(1);
			usu = (Usuario) pesquisa.uniqueResult();
			if (!(usu == null)) {
				return usu;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}

	}

	public boolean EditaUsuario(Usuario usuario) {
		try {
			try {
				if (!session.isConnected()) {
					session = HibernateUtil.getSessionFactory().openSession();
				}
				session.beginTransaction();
				session.merge(usuario);
				session.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				return false;
			}
		} finally {
			session.close();
		}
		return true;
	}

	public String BuscaSenhaByEmail(String email) {
		try {
			if (!session.isConnected()) {
				session = HibernateUtil.getSessionFactory().openSession();
			}
			org.hibernate.Query pesquisa = session
					.createQuery("FROM Usuario WHERE email = :paramemail");
			pesquisa.setParameter("paramemail", email);
			pesquisa.setMaxResults(1);
			Usuario usu = new Usuario();
			usu = (Usuario) pesquisa.uniqueResult();
			if (!(usu == null)) {
				return usu.getSenha();
			} else {
				return "Erro: Email não cadastrado!";
			}
		} catch (Exception e) {
			return "Erro: " + e.getMessage();
		} finally {
			session.close();
		}

	}

	public Usuario BuscaUsuarioFacebook(String email, String senha) {
		try {
			if (!session.isConnected()) {
				session = HibernateUtil.getSessionFactory().openSession();
			}
			Usuario usu = new Usuario();
			org.hibernate.Query pesquisa = session
					.createQuery("FROM Usuario WHERE email = :email and senha = :senha");
			pesquisa.setParameter("email", email);
			pesquisa.setParameter("senha", senha);
			pesquisa.setMaxResults(1);
			usu = (Usuario) pesquisa.uniqueResult();
			if (!(usu == null)) {
				return usu;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}

	}
}
