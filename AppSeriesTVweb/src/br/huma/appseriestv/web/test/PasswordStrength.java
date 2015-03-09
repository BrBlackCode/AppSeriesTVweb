package br.huma.appseriestv.web.test;

public class PasswordStrength {

	private int checkPasswordStrength(String password) {
		int strengthPercentage = 0;
		String[] partialRegexChecks = { ".*[a-z]+.*", // lower
				".*[A-Z]+.*", // upper
				".*[\\d]+.*", // digits
				".*[@#$%]+.*" // symbols
		};

		if (password.matches(partialRegexChecks[0])) {
			strengthPercentage += 25;
		}
		if (password.matches(partialRegexChecks[1])) {
			strengthPercentage += 25;
		}
		if (password.matches(partialRegexChecks[2])) {
			strengthPercentage += 25;
		}
		if (password.matches(partialRegexChecks[3])) {
			strengthPercentage += 25;
		}

		return strengthPercentage;
	}

	public String validaSenha(String senha) {
		String retorno = "";
		if (checkPasswordStrength(senha) == 25) {
			retorno = "Fraca";
		} else if (checkPasswordStrength(senha) == 50) {
			retorno = "Média";
		} else if (checkPasswordStrength(senha) == 75) {
			retorno = "Forte";
		} else if (checkPasswordStrength(senha) == 100) {
			retorno = "Muito Forte";
		} else {
			retorno = "Muito Fraca";
		}

		return retorno;
	}

}