package br.huma.appseriestvweb.bo;

import br.huma.appseriestv.dominios.ValidacaoLogin;
import br.huma.appseriestvweb.bean.Usuario;
import br.huma.appseriestvweb.dao.UsuarioDAO;

public class LoginBO {

	public boolean validarLogin(String email, String senha) {
		boolean resultado = false;
		try {
			UsuarioDAO usuDao = new UsuarioDAO();

			Usuario usu = usuDao.BuscaUsuarioByEmailSenha(email, senha);

			if (usu != null)
				resultado = true;

		} finally {

		}

		return resultado;
	}

	public ValidacaoLogin validarLoginFacebook(String email, String senha) {
		ValidacaoLogin resultado = new ValidacaoLogin();
		try {
			UsuarioDAO usuDao = new UsuarioDAO();

			Usuario usu = usuDao.BuscaUsuarioFacebook(email, senha);

			if (usu == null) {
				resultado.setValido(false);
				resultado.setUsu(null);
				resultado.setMensagem("Usuário não encontrado.");
			} else {
				resultado.setValido(true);
				resultado.setUsu(usu);
				resultado.setMensagem("OK");
			}

		} finally {

		}

		return resultado;
	}

	/*
	 * public boolean validarLogin(String email, String senha) { boolean
	 * resultado = false; Connection con = null; try { con =
	 * DBUtil.getConexao(); // busca a conexão com o banco // de dados
	 * 
	 * String sql =
	 * "SELECT * FROM tb_usuario WHERE USU_EMAIL = ? AND USU_SENHA = ?"; //
	 * escreve // o // SQL
	 * 
	 * PreparedStatement st = con.prepareStatement(sql); // prepara o SQL //
	 * para receber // os parâmetros st.setString(1, email); // passa os
	 * parâmetros na ordem correta st.setString(2, senha);
	 * 
	 * ResultSet rs = st.executeQuery(); // executa a query e retorna um //
	 * objeto ResultSet
	 * 
	 * resultado = rs.next(); // ResultSet é um objeto que contém os dados // da
	 * query executa, se next retornar true // significa que existem dados
	 * 
	 * } catch (ClassNotFoundException | SQLException e) { e.printStackTrace();
	 * } finally { if (con != null) { try { con.close(); } catch (SQLException
	 * e) { e.printStackTrace(); } }
	 * 
	 * }
	 * 
	 * return resultado; }
	 */

}
