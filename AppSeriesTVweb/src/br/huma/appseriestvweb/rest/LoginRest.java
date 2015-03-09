package br.huma.appseriestvweb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.huma.appseriestv.dominios.ValidacaoLogin;
import br.huma.appseriestvweb.bo.LoginBO;

import com.google.gson.Gson;

@Path("login")
public class LoginRest {
	private LoginBO loginBO = new LoginBO();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("plain")
	public String aloMundo() {
		return "Alo Mundo";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("html")
	public String aloMundo2(@PathParam("nome") String nome) {
		return "<html><head><title>Alo Mundo 2!</title></head><body>Ola, "
				+ nome + "! </body></html>";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("json")
	public String aloMundoJSON() {
		return "ola: {'Ola Mundo JSON'}";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("xml")
	public String aloMundoXML() {
		return "<xml><ola>Alo Mundo xml!</ola></xml>";
	}

	@GET
	@Path("logar")
	@Produces(MediaType.APPLICATION_JSON)
	public String logar(@QueryParam("usuario") String user,
			@QueryParam("senha") String pass) {
		Gson gson = new Gson();
		return gson.toJson(loginBO.validarLogin(user, pass));
	}

	@GET
	@Path("loginfacebook")
	@Produces(MediaType.APPLICATION_JSON)
	public String loginFacebook(@QueryParam("email") String email,
			@QueryParam("senha") String senha) {

		Gson gson = new Gson();
		return gson.toJson(loginBO.validarLoginFacebook(email, senha),
				ValidacaoLogin.class);
	}

}
