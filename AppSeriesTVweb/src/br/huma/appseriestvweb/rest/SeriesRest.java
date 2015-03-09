package br.huma.appseriestvweb.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.huma.appseriestvweb.bean.Series;
import br.huma.appseriestvweb.bean.SeriesDetalhe;
import br.huma.appseriestvweb.bean.SeriesTempoCapitulos;
import br.huma.appseriestvweb.bean.SeriesTemporada;
import br.huma.appseriestvweb.dao.SerieDetalheDAO;
import br.huma.appseriestvweb.dao.SeriesDAO;
import br.huma.appseriestvweb.dao.SeriesTempoCapDAO;
import br.huma.appseriestvweb.dao.SeriesTemporadaDAO;

import com.google.gson.Gson;

@Path("serierest")
public class SeriesRest {

	// @GET
	// @Path("gettodasseriestest")
	// @Produces(MediaType.APPLICATION_JSON)
	/*
	 * public String listarTodasSeriesTest() {
	 * 
	 * List<Series> list = new ArrayList<Series>();
	 * 
	 * Series serie = new Series(); serie.setId(1L); serie.setNome("Dexter");
	 * serie.setDescricao("Assasino em série"); serie.setSerieAprovada(false);
	 * serie.setNomefoto("dexter.jpg"); serie.setAnoInicial("2010");
	 * serie.setAnoFinal("2015");
	 * 
	 * list.add(serie);
	 * 
	 * Series serie2 = new Series(); serie2.setId(2L);
	 * serie2.setNome("Game of thrones");
	 * serie2.setDescricao("jogo dos tronos"); serie2.setSerieAprovada(false);
	 * serie2.setNomefoto("jogotronos.jpg"); serie2.setAnoInicial("2012");
	 * serie2.setAnoFinal("");
	 * 
	 * list.add(serie);
	 * 
	 * Gson gson = new Gson();
	 * 
	 * System.out.println(gson.toJson(list));
	 * 
	 * return gson.toJson(list); }
	 */

	@GET
	@Path("gettodasseries")
	@Produces(MediaType.APPLICATION_JSON)
	public String listarTodasSeries() {
		List<Series> list = new ArrayList<Series>();

		SeriesDAO serieDao = new SeriesDAO();

		list = serieDao.buscaTodasSeries();

		Gson gson = new Gson();
		System.out.println(gson.toJson(list));
		return gson.toJson(list);

	}

	@GET
	@Path("getserienome")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaSeriesByNome(@QueryParam("nomeserie") String nome) {
		Series series = new Series();
		SeriesDAO serieDao = new SeriesDAO();

		series = serieDao.buscaSerieByNome(nome);

		Gson gson = new Gson();
		System.out.println(gson.toJson(series));
		return gson.toJson(series);

	}

	@GET
	@Path("getseriedetalhe")
	@Produces(MediaType.APPLICATION_JSON)
	// @Produces("application/json; charset=UTF-8")
	public String buscaSerieDetalheByNome(@QueryParam("nomeserie") String nome) {
		String resultadoJson = "";
		SeriesDetalhe seriesdet = new SeriesDetalhe();
		SerieDetalheDAO serieDetDao = new SerieDetalheDAO();

		seriesdet = serieDetDao.buscaSerieDetalheByNome(nome);

		Gson gson = new Gson();
		resultadoJson = gson.toJson(seriesdet);

		// if (seriesdet.getId() != null) {
		// resultadoJson = gson.toJson(seriesdet);
		// } else {
		// resultadoJson = gson.toJson(resultadoJson);
		// }

		return resultadoJson;
	}

	@GET
	@Path("getseriestemporada")
	@Produces(MediaType.APPLICATION_JSON)
	// @Produces("application/json; charset=UTF-8")
	public String buscaSeriesTemporadaByNome(
			@QueryParam("nomeserie") String nome) {
		SeriesTemporadaDAO serieTempDao = new SeriesTemporadaDAO();

		List<SeriesTemporada> seriestempo = serieTempDao
				.buscaSerieTemporadaByNome(nome);

		Gson gson = new Gson();
		return gson.toJson(seriestempo);

	}

	@GET
	@Path("getseriestempcapitulos")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaSeriesTemporadaCapByNome(
			@QueryParam("nomeserie") String nomeserie,
			@QueryParam("temporada") String temporada) {

		SeriesTempoCapDAO stcDAO = new SeriesTempoCapDAO();

		List<SeriesTempoCapitulos> serietempcap = stcDAO
				.listarTemporadaCapitulos(nomeserie, temporada);

		Gson gson = new Gson();
		String retornoJson = gson.toJson(serietempcap);
		return retornoJson;
	}

}
