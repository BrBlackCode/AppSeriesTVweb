package br.huma.appseriestv.dominios;

import br.huma.appseriestvweb.bean.Usuario;

public class ValidacaoLogin {

	private boolean valido;
	private String mensagem;
	private Usuario usu;

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}
}