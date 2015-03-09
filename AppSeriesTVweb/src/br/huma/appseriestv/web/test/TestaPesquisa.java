package br.huma.appseriestv.web.test;

import java.lang.reflect.Type;
import java.util.List;

import br.huma.appseriestv.dominios.ValidacaoLogin;
import br.huma.appseriestvweb.bean.SeriesDetalhe;
import br.huma.appseriestvweb.bean.SeriesTempoCapitulos;
import br.huma.appseriestvweb.bean.SeriesTemporada;
import br.huma.appseriestvweb.bo.LoginBO;
import br.huma.appseriestvweb.dao.SerieDetalheDAO;
import br.huma.appseriestvweb.dao.SeriesTempoCapDAO;
import br.huma.appseriestvweb.dao.SeriesTemporadaDAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TestaPesquisa {

	public static void main(String[] args) {
		// testaConsultaDeLogin();

		// testaConsultaSerieDetalhe();

		// testaConsultaSerieTemporada();

		// testaConsultaSerieTempCapitulos();

		System.out.println(loginFacebook("marcelofscarpim@gmail.com",
				"facebookXPTOappSeriesTV123"));
	}

	private static void testaConsultaDeLogin() {
		LoginBO loginbo = new LoginBO();

		boolean usu = loginbo.validarLogin("marcelo@teste.com.br", "123");

		if (usu) {
			System.out.println("Achou");
		}
	}

	private static void testaConsultaSerieDetalhe() {
		SerieDetalheDAO sdDAO = new SerieDetalheDAO();

		SeriesDetalhe sd = sdDAO
				.buscaSerieDetalheByNome("American Horror Story");

		Gson gson = new Gson();

		System.out.println(gson.toJson(sd));
	}

	private static void testaConsultaSerieTemporada() {
		SeriesTemporadaDAO stDAO = new SeriesTemporadaDAO();

		List<SeriesTemporada> sd = stDAO
				.buscaSerieTemporadaByNome("American Horror Story");

		Gson gson = new Gson();

		System.out.println(gson.toJson(sd));
	}

	private static void testaConsultaSerieTempCapitulos() {
		SeriesTempoCapDAO stDAO = new SeriesTempoCapDAO();

		List<SeriesTempoCapitulos> sd = stDAO.listarTemporadaCapitulos(
				"American Horror Story", "1");

		Gson gson = new Gson();

		for (SeriesTempoCapitulos obj : sd) {
			System.out.println("id temporada = "
					+ obj.getSeriesTemporada().getTemporada().toString());
			System.out.println("id serie = "
					+ obj.getSeries().getId().toString());
		}

		String json = gson.toJson(sd);

		System.out.println(json);

		Type collectionType = new TypeToken<List<SeriesTempoCapitulos>>() {
		}.getType();

		List<SeriesTempoCapitulos> lista = gson.fromJson(json, collectionType);

		for (SeriesTempoCapitulos seriesTempCap : lista) {

			System.out.println(seriesTempCap.getSeries().getNome());
			System.out.println(seriesTempCap.getSeriesTemporada()
					.getDescricao());
			System.out.println(seriesTempCap.getDescricao());

		}
	}

	public static String loginFacebook(String email, String senha) {

		Gson gson = new Gson();

		LoginBO loginBO = new LoginBO();

		return gson.toJson(loginBO.validarLoginFacebook(email, senha),
				ValidacaoLogin.class);
	}
}
