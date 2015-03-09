package br.huma.appseriestvweb.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.huma.appseriestvweb.bean.Usuario;
import br.huma.appseriestvweb.bo.LoginBO;
import br.huma.appseriestvweb.dao.UsuarioDAO;

import com.google.gson.Gson;

@Path("usuariorest")
public class UsuarioRest {

	@POST
	@Path("recebe")
	@Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	public String recebeUsuario(@FormParam("usuario") String usuario) {
		LoginBO loginBO = new LoginBO();
		UsuarioDAO usuDao = new UsuarioDAO();

		Gson gson = new Gson();
		Usuario usu = gson.fromJson(usuario, Usuario.class);

		if (!loginBO.validarLogin(usu.getEmail(), usu.getSenha())) {

			boolean resultado = usuDao.InsereUsuario(usu);

			Usuario usuarioRetorno = usuDao.BuscaUsuarioByEmailSenha(
					usu.getEmail(), usu.getSenha());

			System.out.println(gson.toJson(usuarioRetorno));

			if (resultado) {
				return gson.toJson(usuarioRetorno);
			} else {
				return gson.toJson("erro");
			}
		} else {
			Usuario usuarioRetorno = usuDao.BuscaUsuarioByEmailSenha(
					usu.getEmail(), usu.getSenha());
			return gson.toJson(usuarioRetorno);
		}
	}

	@GET
	@Path("retornausuario")
	@Produces(MediaType.APPLICATION_JSON)
	public String retornaObjUsuario(@QueryParam("usuario") String usuario,
			@QueryParam("senha") String senha) {
		Gson gson = new Gson();
		UsuarioDAO usuDao = new UsuarioDAO();

		Usuario resultado = usuDao.BuscaUsuarioByEmailSenha(usuario, senha);

		return gson.toJson(resultado);

	}

	@GET
	@Path("teste")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String teste() {

		Gson gson = new Gson();
		return gson.toJson("Ola mundo");

	}

	@POST
	@Path("editar")
	@Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	public String atualizaUsuario(@FormParam("usuario") String usuario) {
		Gson gson = new Gson();
		Usuario usu = gson.fromJson(usuario, Usuario.class);

		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuarioRetorno = usuDao.BuscaUsuarioByID(usu.getId());

		if (usuarioRetorno != null) {

			boolean resultado = usuDao.EditaUsuario(usu);

			if (resultado) {
				usuarioRetorno = usuDao.BuscaUsuarioByID(usu.getId());
				System.out.println(gson.toJson(usuarioRetorno));
				return gson.toJson(usuarioRetorno);
			} else {
				return gson.toJson("erro");
			}
		} else {
			return gson.toJson("Usuário não encontrado!");
		}
	}

	@GET
	@Path("retornasenha")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String retornaSenhaUsuario(@QueryParam("email") String email) {
		UsuarioDAO usuDao = new UsuarioDAO();
		String senha = usuDao.BuscaSenhaByEmail(email);
		Gson gson = new Gson();
		return gson.toJson(senha);

	}

}
