package br.huma.appseriestv.web.test;

public class TestaFuncao {

	public static void main(String[] args) {
		TestarFuncaoTrocadeCaracter();

		TestarSenha("marcelo");

		TestarSenha("123456");

		TestarSenha("123");

		TestarSenha("Marcelo123");

		TestarSenha("drumslo4633");

		TestarSenha("XpTo10@45%");

		TestarSenha("AbCd(*9876/*-+!=");

		TestarSenha("seriestv");

		TestarSenha("TELEVISAO");

		TestarSenha("NOTEBOOK");

		TestarSenha("Android");
	}

	public static void TestarFuncaoTrocadeCaracter() {
		String teste = "American Horror Story";
		String resultado = "";

		resultado = FuncoesUteis
				.StringReplace(teste, new String[] { " " }, "+");

		System.out.println(resultado);

	}

	public static void TestarSenha(String vlSenha) {
		PasswordStrength pass = new PasswordStrength();
		String resultado = pass.validaSenha(vlSenha);
		System.out.println("A senha: " + vlSenha + " é " + resultado);
	}

}
