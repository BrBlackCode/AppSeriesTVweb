package br.huma.appseriestv.web.test;

public class FuncoesUteis {

	public static String StringReplace(String texto,
			String[] caracterSubstituir, String caracterSubtituto) {
		for (int i = 0; i < caracterSubstituir.length; i++)
			texto = texto.replaceAll(caracterSubstituir[i], caracterSubtituto);

		// System.out.println(texto);

		return texto;
	}

}
